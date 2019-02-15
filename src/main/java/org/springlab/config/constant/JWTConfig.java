package org.springlab.config.constant;

import com.auth0.jwt.algorithms.Algorithm;

public class JWTConfig {
    public static final Long expireTime = 36000000l;
    public static final String secretKey = "sofhjxovjopaisejr39089v23onji90v";
    public static final Algorithm algorithmHS = Algorithm.HMAC256(secretKey);

}
