package com.tweiy.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

   private static final SecretKey key = Keys.hmacShaKeyFor("mySuperSecretKeyForJwtGeneration1234567890"
            .getBytes(StandardCharsets.UTF_8));

    private static final Long expire = 43200000L;

    /**
     * 生成JWT
     */
     public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + expire)) // 12小时过期
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 解析JWT
     */
     public static Claims parseJwt(String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(key)   // 使用同一个密钥
                .build()
                .parseClaimsJws(jwt)  // 解析并验证签名
                .getBody();
    }
}
