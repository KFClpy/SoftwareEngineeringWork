package com.example.pinksir.ex;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(ServiceException.class)
    public JSONObject handleException(Throwable e)
    {
        JSONObject obj=new JSONObject();

        if(e instanceof InsertException)
        {
            obj.put("state",5000);
            obj.put("message","插入失败");
        }
        else if(e instanceof UpdateException)
        {
            obj.put("state",7000);
            obj.put("message","更新失败");
        }
        else if(e instanceof DeleteException)
        {
            obj.put("state",8000);
            obj.put("message","删除失败");
        }
        return obj;
    }
}
