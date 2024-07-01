package com.github.xiaoyu2017.api.util;

import com.github.xiaoyu2017.api.domain.vo.Payload;
import io.jsonwebtoken.*;

import java.security.PrivateKey;
import java.security.PublicKey;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

/**
 * TODO
 *
 * @author xiaoyu
 * @version 1.0
 */
public class JwtUtil {
    private static final String JWT_PAYLOAD_USER_KEY = "USER_INFO";

    /**
     * 私钥加密token
     *
     * @param userInfo   载荷中的数据
     * @param privateKey 私钥
     * @param expire     过期时间，单位分钟
     * @return JWT
     */
    public static String generateTokenExpireInMinutes(Object userInfo, PrivateKey privateKey, int expire) {
        return Jwts.builder()
                .claim(JWT_PAYLOAD_USER_KEY, JsonUtils.toString(userInfo))
                .setId(createJTI())
                .setExpiration(dateUtil(expire))
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

    /**
     * 私钥加密token
     *
     * @param userInfo   载荷中的数据
     * @param privateKey 私钥
     * @param expire     过期时间，单位秒
     * @return JWT
     */
    public static String generateTokenExpireInSeconds(Object userInfo, PrivateKey privateKey, int expire) {
        return Jwts.builder()
                .claim(JWT_PAYLOAD_USER_KEY, userInfo)
                .setId(createJTI())
                .setExpiration(dateUtil(expire))
                .signWith(SignatureAlgorithm.RS256, privateKey)
                .compact();
    }

    /**
     * 公钥解析token
     *
     * @param token     用户请求中的token
     * @param publicKey 公钥
     * @return Jws<Claims>
     */
    private static Jws<Claims> parserToken(String token, PublicKey publicKey) {
        return Jwts.parser().setSigningKey(publicKey).parseClaimsJws(token);
    }

    private static String createJTI() {
        return new String(Base64.getEncoder().encode(UUID.randomUUID().toString().getBytes()));
    }

    /**
     * 获取token中的用户信息
     *
     * @param token     用户请求中的令牌
     * @param publicKey 公钥
     * @return 用户信息
     */
    public static <T> Payload<T> getInfoFromToken(String token, PublicKey publicKey, Class<T> userType) {
        Jws<Claims> claimsJws = parserToken(token, publicKey);
        Claims body = claimsJws.getBody();
        Payload<T> claims = new Payload<>();
        claims.setId(body.getId());
        claims.setUserInfo(JsonUtils.toBean(body.get(JWT_PAYLOAD_USER_KEY).toString(), userType));
        claims.setExpiration(body.getExpiration());
        return claims;
    }

    /**
     * 获取token中的载荷信息
     *
     * @param token     用户请求中的令牌
     * @param publicKey 公钥
     * @return 用户信息
     */
    public static <T> Payload<T> getInfoFromToken(String token, PublicKey publicKey) {
        Jws<Claims> claimsJws = parserToken(token, publicKey);
        Claims body = claimsJws.getBody();
        Payload<T> claims = new Payload<>();
        claims.setId(body.getId());
        claims.setExpiration(body.getExpiration());
        return claims;
    }

    private static Date dateUtil(int expire) {
        LocalDateTime localDateTime = LocalDateTime.now().plusMinutes(expire);
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }

    public static void main(String[] args) throws Exception {
        String privateKey = "/Users/yujiangzhong/IdeaProjects/Java/id_rsa";
        String publicKey = "/Users/yujiangzhong/IdeaProjects/Java/id_rsa.pub";
        String token = "    eyJhbGciOiJSUzI1NiJ9.eyJVU0VSX0lORk8iOiJ7XCJpZFwiOm51bGwsXCJjcmVhdGVUaW1lXCI6bnVsbCxcInVwZGF0ZVRpbWVcIjpudWxsLFwic3RhdHVzXCI6bnVsbCxcIm5pY2tOYW1lXCI6XCJmaXNoXCIsXCJlbWFpbFwiOlwiMTg4OTUzMTEzMDlAZ21haWwuY29tXCIsXCJwaG9uZVwiOlwiMDU2NDY3NjM0NzlcIixcImJpcnRoZGF5XCI6MTcxNjMwNTUyNzkyOH0iLCJqdGkiOiJPV1prTWpNMU1EQXROMlpoTkMwME9UZzVMV0V6TURFdFlqbGtabUZtT0dKaU9XUmsiLCJleHAiOjE3MTYzMDczMjh9.JtAdN97RP0ZQYteopo-JMGOpxGAr-YKcv9S0pig0C-rdnhS7ytKdaMhBzMUW3DrQ5JdmJQmrETfTlnb1UQUDF441SFqJ32GMLmUD8NBCklTlwmf7LHHqSorfzUdtnz3SXiZko7IIFdJTeevvRRZveon876oQGVKZKBXTUm3LGCiAvd_TzXn7WdpKS3NVTLDmzfy8-1IDGsrueVsH3KQTlHxIrFzgpI4lynIeEtrk7FHM0DXLNYxMwf_KYJ1shn-afNZjbdL1zKlISc1fnViR3TexBrgu7JpkGrcfTccJEvSy1SIY1QEPeffP6LjH0_X2PRbX1t0nx4mLMMuG2w9MJA";
//
//        Payload<UserInfo> payload = getInfoFromToken(token, RsaUtil.getPublicKey(publicKey), UserInfo.class);
//        System.out.println(payload);
    }
}
