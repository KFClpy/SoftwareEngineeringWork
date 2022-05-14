package com.software.homework5.Impl;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.software.homework5.Dao.UserMapper;
import com.software.homework5.EX.*;
import com.software.homework5.Entity.FileUpLoad;
import com.software.homework5.Entity.User;
import com.software.homework5.Service.UserService;
import com.software.homework5.Util.RedisUtils;
import com.software.homework5.Util.TokenUtils;
import com.software.homework5.Util.UploadFileTool;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    RedisUtils redisUtils;
    @Autowired
    TokenUtils tokenUtils;
    @Autowired
    UserMapper userMapper;
    @Autowired
    UploadFileTool uploadFileTool;
    @Override
    public void reg(User user)
    {
        JSONObject json=new JSONObject();
        System.err.println("UserServiceImpl.reg()");
        String username = user.getUsername();
        User result=userMapper.findByUsername(username);
        if(result!=null){
            throw new UsernameDuplicateException();

        }
        Date now=new Date();
        String salt= UUID.randomUUID().toString();
        user.setSalt(salt);
        String md5Password=getMd5Password(user.getPassword(),salt);
        user.setPassword(md5Password);
        user.setIsDelete(0);
        user.setCreatedUser(username);
        user.setCreatedTime(now);
        user.setModifiedUser(username);
        user.setModifiedTime(now);
        Integer rows=userMapper.insert(user);
        if(rows!=1)
        {
            throw new InsertException();
        }

    }
    @Override
    public User login(String username,String password)
    {
        System.err.println("UserServiceImpl.login()");
        User result= userMapper.findByUsername(username);
        if(result==null)
        {
            throw new UsernotfoundException("登陆失败，用户名不存在!");
        }
        if(result.getIsDelete()==1)
        {
            throw new UsernotfoundException("登录失败，用户数据已被删除！");
        }
        String salt=result.getSalt();
        String md5Password=getMd5Password(password,salt);
        if(!md5Password.equals(result.getPassword()))
        {
            throw new PasswordNotMatchException("登陆失败，密码错误");
        }
        User user=new User();
        user.setUid(result.getUid());
        user.setUsername(result.getUsername());
        user.setAvatar(result.getAvatar());
        user.setPassword(result.getPassword());
        return user;
    }
    private String getMd5Password(String password,String salt)
    {
        String result=salt+password+salt;
        for(int i=0;i<3;i++)
        {
            result= DigestUtils.md5Hex(result);

        }
        System.err.println("\tpassword=" + password);
        System.err.println("\tsalt=" + salt);
        System.err.println("\tmd5Password=" + result);
        return result;
    }
    @Override
    public void changePassword(String username,String oldPassword,String newPassword)
    {
        System.err.println("UserServiceImpl.changePassword()");
        User result=userMapper.findByUsername(username);
        if(result==null)
        {
            throw new UsernotfoundException("修改失败，尝试访问的用户数据不存在");
        }
        if(result.getIsDelete()==1)
        {
            throw new UsernotfoundException("修改失败，用户数据已被删除");
        }
        String salt=result.getSalt();
        String oldMd5password=getMd5Password(oldPassword,salt);
        if(!oldMd5password.equals(result.getPassword()))
        {
            throw new PasswordNotMatchException("修改密码失败,原密码错误");
        }
        System.err.println("\t验证通过，更新密码！");
        String newMd5password=getMd5Password(newPassword,salt);
        String token=tokenUtils.getToken();
        redisUtils.del(new String[]{token});
        String newToken= JWT.create().withAudience(username)
                .withIssuer("KKKFFFCCC")
                .sign(Algorithm.HMAC256(newMd5password));
        redisUtils.set(newToken,username,30, TimeUnit.MINUTES);
        Integer rows=userMapper.updatePasswordByUid(newMd5password,username,new Date());
        if(rows!=1)
        {
            throw new UpdateException("修改密码失败，更新密码时出现未知错误!");
        }
    }
    @Value("${uploadFile.path}")
    String path;
    @Override
    public void updateAvatar(String username, MultipartFile file)
    {
        User user= userMapper.findByUsername(username);
        FileUpLoad fileUpLoad= uploadFileTool.upload(username,file.getOriginalFilename(),file);
        String filePath=path+user.getAvatar();
        File preAvatar=new File(filePath);
        if(preAvatar.isFile()&&preAvatar.exists())
        {
            boolean res=preAvatar.delete();
            System.out.println("删除旧头像"+(res?"成功":"失败"));
        }
        Integer rows=userMapper.updateAvatarByUid(fileUpLoad.getType()+ File.separator+fileUpLoad.getFilename(),username,new Date());
        if(rows!=1)
        {
            throw new UpdateException("修改头像失败，修改头像时出现未知错误");
        }
    }
    @Override
    public void updateInfo(String username,String nickname,String phone,Integer gender,Integer identity,String email)
    {
        Date date=new Date();
        Integer rows=userMapper.updateAllByUsername(nickname,phone,gender,identity,email,username,date);
        if(rows!=1)
        {
            throw new UpdateException("修改用户信息失败，修改时出现未知错误");
        }
    }
    @Override
    public JSONObject getUserInfo(String username)
    {
        JSONObject obj=new JSONObject();
        User user= userMapper.findByUsername(username);
        obj.put("avatar",user.getAvatar()!=null?user.getAvatar():"/image/image.png");
        obj.put("name",user.getNickname()!=null?user.getNickname():"未知");
        obj.put("tel",user.getPhone()!=null?user.getPhone():"未知");
        obj.put("sex",user.getGender()!=null?user.getGender():2);
        obj.put("other",user.getIdentity()!=null?user.getIdentity():3);
        obj.put("email",user.getEmail()!=null?user.getEmail():"未知");
        return obj;
    }
}
