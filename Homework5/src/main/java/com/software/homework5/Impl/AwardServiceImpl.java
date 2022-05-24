package com.software.homework5.Impl;

import com.software.homework5.Dao.AwardMapper;
import com.software.homework5.EX.DeleteException;
import com.software.homework5.EX.InsertException;
import com.software.homework5.EX.UpdateException;
import com.software.homework5.Entity.Award;
import com.software.homework5.Entity.FileUpLoad;
import com.software.homework5.Service.AwardService;
import com.software.homework5.Util.UploadFileTool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
@Service
public class AwardServiceImpl implements AwardService {
    @Autowired
    AwardMapper awardMapper;
    @Autowired
    UploadFileTool uploadFileTool;
    @Value("${uploadFile.path}")
    String path;
    @Override
    public List<Award> getAwardTable(String username){
        return awardMapper.findByUserName(username);
    }

    @Override
    public List<Award> addAward(String username, String aname, Integer num, String intro,MultipartFile file) {
        FileUpLoad fileUpLoad= uploadFileTool.upload(username,file.getOriginalFilename(),file);
        Award award=new Award();
        award.setUsername(username);
        award.setAname(aname);
        award.setNum(num);
        award.setIntro(intro);
        award.setImg(fileUpLoad.getType()+ File.separator+fileUpLoad.getFilename());
        Integer rows=awardMapper.insert(award);
        if(rows!=1)
        {
            throw new InsertException("插入奖品信息时错误");
        }
        return getAwardTable(username);
    }

    @Override
    public List<Award> deleteAward(Integer []aid, String username) {
        int rows=0;
        for(int val:aid) {
            delOldFile(val);
            rows += awardMapper.delete(val);
        }
        if(rows!=aid.length)
        {
            throw new DeleteException("删除信息时错误");
        }
        return getAwardTable(username);
    }

    private void delOldFile(int val) {
        Award award = awardMapper.findByAid(val);
        String filePath = path + award.getImg();
        File preImg = new File(filePath);
        if (preImg.isFile() && preImg.exists()) {
            boolean res = preImg.delete();
            System.out.println("删除旧图片" + (res ? "成功" : "失败"));
        }
    }

    @Override
    public List<Award> searchAward(String username, String aname) {
        return awardMapper.findByAname(username,aname);
    }

    @Override
    public List<Award> updateAward(Integer aid, String username, String aname, Integer num, String intro,MultipartFile file) {
        delOldFile(aid);
        FileUpLoad fileUpLoad= uploadFileTool.upload(username,file.getOriginalFilename(),file);
        Integer rows=awardMapper.updateByAid(aid,aname,num,intro,fileUpLoad.getType()+ File.separator+fileUpLoad.getFilename());
        if(rows!=1)
        {
            throw  new UpdateException("更新信息时失败");
        }
        return getAwardTable(username);
    }

    @Override
    public Award getAward(Integer aid) {
        return awardMapper.findByAid(aid);
    }
}
