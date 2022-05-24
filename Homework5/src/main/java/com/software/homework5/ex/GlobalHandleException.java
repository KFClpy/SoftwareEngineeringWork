package com.software.homework5.ex;

import com.alibaba.fastjson.JSONObject;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalHandleException {
    @ExceptionHandler(ServiceException.class)
    public JSONObject handleException(Throwable e)
    {
        JSONObject obj=new JSONObject();
        if(e instanceof UsernameDuplicateException)
        {
            obj.put("state",4000);
        }
        else if(e instanceof DeleteException)
        {
            obj.put("state",3000);
        }
        else if(e instanceof InsertException)
        {
            obj.put("state",5000);
        }
        else if(e instanceof PasswordNotMatchException)
        {
            obj.put("state",6000);
        }
        else if(e instanceof UpdateException)
        {
            obj.put("state",7000);
        }
        else if(e instanceof UsernotfoundException)
        {
            obj.put("state",8000);
        }
        return obj;
    }
}
