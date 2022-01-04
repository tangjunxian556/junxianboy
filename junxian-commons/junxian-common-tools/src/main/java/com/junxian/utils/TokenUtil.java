package com.junxian.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Classname: TokenService
 * @Date: 2021-12-31 15:21
 * @Author: tang_junXian
 * @Description: token服务
 */
public class TokenUtil {

    /**
     * 设置过期时间 1小时钟 为了方便测试
     * 设置Token密匙 最好长一点
     */
    private static final long EXPIRE_TIME= 60 * 60 * 1000;
    private static final String TOKEN_SECRET="Token";

    /**
     * 生成token
     * @param useName 用户名
     * @param userId 用户ID
     * @return token
     */
    public static String createToken(String useName, long userId){
        try{
            //这里将useName 和 userId 存入了Token，在下面的解析中，也会有解析的方法可以获取到Token里面的数据
            //Token过期的时间
            Date date = new Date(System.currentTimeMillis()+EXPIRE_TIME);
            System.out.println("date"+date);
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);

            //设置头部信息
            Map<String,Object> header = new HashMap<>(2);
            header.put("typ","JWT");
            header.put("alg","HS256");

            //附带username和userid信息,存储到token中，生成签名
            return JWT.create()
                    .withHeader(header)
                    //存储自己想要留存给客户端浏览器的内容
                    .withClaim("userName",useName)
                    .withClaim("userId",userId)
                    .withExpiresAt(date)
                    .sign(algorithm);
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * token校验是否正确
     * @param token token
     */
    public static boolean verifyToken(String token){
        try{
            Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
            JWTVerifier verifier = JWT.require(algorithm).build();
            verifier.verify(token);
            return true;
        }catch (Exception e){
            System.out.println("Token超时,需要重新登录");
        }

        return false;
    }

    /**
     * 获取token中信息 userName
     * @param token token
     * @return userName
     */
    public static String getUsernameByToken(String token){
        try {
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userName").asString();
        }catch (JWTDecodeException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取token中信息 userId
     * @param token token
     * @return userId
     */
    public static Long getUserIdByToken(String token){
        try{
            DecodedJWT jwt = JWT.decode(token);
            return jwt.getClaim("userId").asLong();
        }catch (JWTDecodeException e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 校验工具类
     */
/*    public static void main(String[] args) {
        String token = createToken("张三", 123456);
        boolean verifyToken = verifyToken(token);
        String username = getUsernameByToken(token);
        Long userId = getUserIdByToken(token);
        System.out.println("---");
    }*/

}
