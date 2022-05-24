package com.software.homework5.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.software.homework5.dao.UserMapper;
import com.software.homework5.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Objects;

@Component
public class TokenUtils {

    @Autowired
    UserMapper userMapper;

    public  String getToken() {

        // 从 http 请求头中取出 token
        String token = Objects.requireNonNull(getRequest()).getHeader("token");
        return token;
    }

    /**
     * 获取request
     * @return
     */
    public static HttpServletRequest getRequest() {

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
    public String CreateToken(User user)
    {
        return JWT.create().withAudience(user.getUsername())
                .withIssuer("KKKFFFCCC")
                .sign(Algorithm.HMAC256(user.getPassword()));

    }
    public String getUsername(String token)
    {
        return JWT.decode(token).getAudience().get(0);
    }
    public  boolean verify(String token)
    {
        try {
            String username=getUsername(token);
            User user=userMapper.findByUsername(username);
            if(user==null)return false;
            String SECRET=user.getPassword();
            if(SECRET==null)return false;
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(SECRET)).withIssuer("KKKFFFCCC").build();
            DecodedJWT jwt = verifier.verify(token);
            System.err.println("认证通过:");
            System.err.println("issuer:" + jwt.getIssuer());
            System.err.println("username:" + user.getUsername());
            System.err.println("过期时间" + jwt.getExpiresAt());
            return true;
        }catch (Exception e)
        {
            return false;
        }
    }

}