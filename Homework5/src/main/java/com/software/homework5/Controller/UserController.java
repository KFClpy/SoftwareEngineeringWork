package com.software.homework5.Controller;

import com.alibaba.fastjson.JSONObject;
import com.software.homework5.Entity.User;
import com.software.homework5.Service.UserService;
import com.software.homework5.Util.RedisUtils;
import com.software.homework5.Util.TokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.TimeUnit;

@RequestMapping("users")
@RestController
public class UserController
{
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    private UserService userService;
    private static final int OK=2000;
    @PostMapping("reg")
    public JSONObject reg(@RequestBody User user)
    {
        userService.reg(user);
        JSONObject object=new JSONObject();
        object.put("state",OK);
        System.out.println("注册成功");
        return object;
    }
    @PostMapping("login")
    public JSONObject login(@RequestParam String username, @RequestParam String password)
    {
        User data=userService.login(username, password);
        String token= tokenUtils.CreateToken(data);
        JSONObject obj=new JSONObject();
        redisUtils.set(token,username,30, TimeUnit.MINUTES);
        obj.put("state",OK);
        obj.put("token",token);
        System.out.println(obj);
        System.out.println(username+"登陆成功");
        return obj;
    }
    @PostMapping("password/change")
    public JSONObject changePassword(@RequestParam String oldPassword,@RequestParam String newPassword)
    {
        String token= tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        userService.changePassword(username,oldPassword,newPassword);
        JSONObject obj=new JSONObject();
        obj.put("state",OK);
        System.out.println(obj);
        System.out.println(username+"修改密码成功");
        return obj;
    }
    @PostMapping("logout")
    public JSONObject logout()
    {
        String token= tokenUtils.getToken();
        redisUtils.del(new String[] { token});
        JSONObject obj=new JSONObject();
        obj.put("state",OK);
        System.out.println(obj);
        System.out.println("注销成功");
        return obj;
    }
    @PostMapping("updateAvatar")
    public JSONObject updateAvatar(@RequestParam MultipartFile file)
    {
        JSONObject OBJ=new JSONObject();
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        userService.updateAvatar(username,file);
        OBJ.put("state",OK);
        System.out.println(OBJ);
        System.out.println(username+"修改头像成功");
        return OBJ;
    }
    @PostMapping("information")
    public JSONObject updateInformation(@RequestBody User user)
    {
        JSONObject obj=new JSONObject();
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        userService.updateInfo(username,user.getNickname(),user.getPhone(),
                user.getGender(),user.getIdentity(),user.getEmail());
        obj.put("state",OK);
        System.out.println(obj);
        System.out.println(username+"修改信息成功");
        return obj;
    }
    @GetMapping("userInfo")
    public JSONObject getUserInfo()
    {
        String token=tokenUtils.getToken();
        String username=tokenUtils.getUsername(token);
        JSONObject obj=userService.getUserInfo(username);
        return obj;
    }
}