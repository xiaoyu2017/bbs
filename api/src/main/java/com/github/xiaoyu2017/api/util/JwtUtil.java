package com.github.xiaoyu2017.api.util;

import com.github.xiaoyu2017.api.domain.pojo.User;
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
        String token = "eyJhbGciOiJSUzI1NiJ9.eyJVU0VSX0lORk8iOiJ7XCJpZFwiOjIsXCJjcmVhdGVUaW1lXCI6MTcxODY2MjAwMjAwMCxcInVwZGF0ZVRpbWVcIjoxNzE4NjYyMDAyMDAwLFwic3RhdHVzXCI6MCxcIm9yZGVyXCI6MCxcInZlcnNpb25cIjowLFwiZGVsZXRlXCI6ZmFsc2UsXCJ1c2VyTmFtZVwiOlwiYWRtaW5cIixcInBhc3N3b3JkXCI6XCJhZG1pblwiLFwidWlkXCI6XCIyODQ1NTUxNjM2MDYzMjMyMDBcIn0iLCJqdGkiOiJZekE0WmpneU1ETXROMk14WmkwME5XUTBMVGd4TnpjdE5HWTNZakUxTlRVNVpEazEiLCJleHAiOjE3MTk4NTEwNjh9.V6UqBqUpEPbq2mff0eO46btDdYgkCbJ2psgw4iEfjn-vDDWGHN_AA1NkRnCKWX3kSfuR44B_hWDSpvu4r1dpIgxry-72WUqfyNKwATdSapLHhkJ89_0dh4KjE7CR-k6kk-qGDfc0zg8FDlGyem0QODC-0eVwV48CPamOwrAoFDBOz5C2-mChIzVdspXlFtEbX4Zs7U88Wvw7UEmHMcCpEMrm3o3FacPzmIISrw0GtO71LYkFI3FJS2amn3HsxJd35qGZeULbz6Kwti7OpjL3Y1NtdX0KZw_8nVGxcaDcYF381lyCTulQNmC7YTMFFJdkS1_NfpXwrJPlUhMfGdpreA";
//
        Payload<User> payload = getInfoFromToken(token, RsaUtil.getPublicKey(publicKey), User.class);
        System.out.println(payload.getExpiration().getTime());
        System.out.println(System.currentTimeMillis());
        System.out.println(payload.getExpiration().getTime()>System.currentTimeMillis());
    }
}
