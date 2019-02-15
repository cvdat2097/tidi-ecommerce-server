package org.springlab.core.guard;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import org.springlab.config.constant.JWTConfig;

public class JWTService {
    private static JWTVerifier verifier = JWT.require(JWTConfig.algorithmHS).build();

    public static String generateToken(String username, String permission) {
        try {

            String token = JWT.create().withClaim(username, username).withClaim(permission, permission)
                    .withExpiresAt(new Date(new Date().getTime() + JWTConfig.expireTime)).sign(JWTConfig.algorithmHS);

            return token;
        } catch (JWTCreationException e) {
            e.printStackTrace();
        }

        return null;
    }

    public static Boolean isValidToken(String token) {
        try {
            verifier.verify(token);
        } catch (JWTVerificationException exc) {
            exc.printStackTrace();
            return false;
        }

        return true;
    }
}
