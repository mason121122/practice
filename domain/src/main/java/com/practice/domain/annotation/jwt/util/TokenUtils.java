package com.practice.domain.annotation.jwt.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.practice.domain.dao.po.UserPo;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Mark Wang
 * @date 2021/10/15
 */
public class TokenUtils {
    public String getToken(UserPo user) {
//        String token="";
//        token= JWT.create().withAudience(user.getId().toString())
//                .sign(Algorithm.HMAC256(user.getPassword()));
        String token = getRequest().getHeader("token");// 从 http 请求头中取出 token
        String userId = JWT.decode(token).getAudience().get(0);
        return token;
    }
    /**
     * 获取request
     *
     * @return
     */
    public static HttpServletRequest getRequest() {
        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes();
        return requestAttributes == null ? null : requestAttributes.getRequest();
    }
}
