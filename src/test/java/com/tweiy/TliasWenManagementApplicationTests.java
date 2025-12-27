package com.tweiy;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@SpringBootTest
class TliasWenManagementApplicationTests {


    SecretKey key = Keys.hmacShaKeyFor("mySuperSecretKeyForJwtGeneration1234567890"
            .getBytes(StandardCharsets.UTF_8));

    @Test
    void contextLoads() {
    }

    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 10);
        claims.put("username", "itheima");

        String jwt = Jwts.builder()
                .setClaims(claims)
                .setExpiration(new Date(System.currentTimeMillis() + 12 * 3600 * 1000))
                .signWith(key)  // 在0.11.x版本中，不需要再次指定算法
                .compact();

        System.out.println(jwt);
    }

    @Test
    public void testParseJwt() {
        // 假设这里拿到上面生成的 jwt
        String jwt = "eyJhbGciOiJIUzI1NiJ9.eyJpZCI6MTAsInVzZXJuYW1lIjoiaXRoZWltYSIsImV4cCI6MTc2NjIzOTc2OX0.gUDOceQ2g6nTismXMAm56jYmU1fY7JUmF-kdBGuRed4";

        Claims claims = Jwts.parserBuilder()
                .setSigningKey(key)   // 使用同一个密钥
                .build()
                .parseClaimsJws(jwt)  // 解析并验证签名
                .getBody();
        System.out.println(claims);
        System.out.println("id: " + claims.get("id"));
        System.out.println("username: " + claims.get("username"));
        System.out.println("过期时间: " + claims.getExpiration());
    }
}