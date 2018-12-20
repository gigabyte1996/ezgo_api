package com.example.demo.security;

import com.example.demo.entity.UserEntity;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

@Component
public class JwtValidator {

	private String secret = "ezgo";

    public UserEntity validate(String token) {
        UserEntity userEntity = null;
        try {
            Claims body = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();

            userEntity = new UserEntity();

            userEntity.setUsername(body.getSubject());
            userEntity.setUserID(Integer.parseInt(body.get("userId").toString()));
            userEntity.setRole((String) body.get("role"));
        }
        catch (Exception e) {
            System.out.println(e);
        }

        return userEntity;
    }
}
