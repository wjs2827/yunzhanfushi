package com.wmeimob.yzfs.util;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Component;
import com.wmeimob.yzfs.weixin.WeChatConfig;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JwtTokenUtil  extends WeChatConfig{


    private static final String CLAIM_KEY_ID = "userId";
    private static final String CLAIM_OPEN_ID = "openId";
    private static final String CLAIM_KEY_USERNAME = "userName";
    private static final String CLAIM_MOBILE = "mobile";
    private static final String CLAIM_KEY_CREATED = "created";
    public String secret="adsaqw221321#44328sdf";
    public Long expiration = (long) (604800);
    public String tokenHeader="Authorization";
    public String tokenHead = "tokenHead";
    
    public String getIdFromToken(String token) {
        String Id = null;
        try {
            final Claims claims = getClaimsFromToken(token);
            Id = (String) claims.get(CLAIM_KEY_ID);
        } catch (Exception e) {
        	Id = null;
        }
        return Id;
    }
    
    public String getOpenIDFromToken(String token) {
        String openId = null;
        try {
            final Claims claims = getClaimsFromToken(token);
            openId = (String) claims.get(CLAIM_OPEN_ID);
        } catch (Exception e) {
        	openId = null;
        }
        return openId;
    }

    public String getUsernameFromToken(String token) {
        String username;
        try {
            final Claims claims = getClaimsFromToken(token);
            username =(String) claims.get(CLAIM_KEY_USERNAME);
        } catch (Exception e) {
            username = null;
        }
        return username;
    }
    
    public String getMobileFromToken(String token) {
        String mobile = null;
        try {
            final Claims claims = getClaimsFromToken(token);
            mobile = (String) claims.get(CLAIM_MOBILE);
        } catch (Exception e) {
        	mobile = null;
        }
        return mobile;
    }


    public Date getCreatedDateFromToken(String token) {
        Date created;
        try {
            final Claims claims = getClaimsFromToken(token);
            created = new Date((Long) claims.get(CLAIM_KEY_CREATED));
        } catch (Exception e) {
            created = null;
        }
        return created;
    }

    public Date getExpirationDateFromToken(String token) {
        Date expiration;
        try {
            final Claims claims = getClaimsFromToken(token);
            expiration = claims.getExpiration();
        } catch (Exception e) {
            expiration = null;
        }
        return expiration;
    }

    private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser()
                    .setSigningKey(secret)
                    .parseClaimsJws(token)
                    .getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    private Date generateExpirationDate() {
        return new Date(System.currentTimeMillis() + expiration * 1000);
    }
    
    /**
     * 判断token是否过期
     *
     * @param token
     * @return
     */
    public Boolean isTokenExpired(String token) {
        final Date expiration = getExpirationDateFromToken(token);
        return expiration.before(new Date());
    }

    private Boolean isCreatedBeforeLastPasswordReset(Date created, Date lastPasswordReset) {
        return (lastPasswordReset != null && created.before(lastPasswordReset));
    }
    

    /**
     * 根据userDetails创建token
     *
     * @return
     */
    public String generateToken(JwtUser user) {
        Map<String, Object> claims = new HashMap<>();
        claims.put(CLAIM_KEY_ID, user.getId());
        claims.put(CLAIM_OPEN_ID, user.getOpenId());
        claims.put(CLAIM_KEY_USERNAME,user);
        claims.put(CLAIM_KEY_CREATED, new Date());
        return generateToken(claims);
    }
    

    String generateToken(Map<String, Object> claims) {
        return Jwts.builder()
                .setClaims(claims)
                .setExpiration(generateExpirationDate())
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public Boolean canTokenBeRefreshed(String token, Date lastPasswordReset) {
        final Date created = getCreatedDateFromToken(token);
        return !isCreatedBeforeLastPasswordReset(created, lastPasswordReset)
                && !isTokenExpired(token);
    }

    public String refreshToken(String token) {
        String refreshedToken;
        try {
            final Claims claims = getClaimsFromToken(token);
            claims.put(CLAIM_KEY_CREATED, new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    public Boolean validateToken(String token, JwtUser user) {
        final String username = getUsernameFromToken(token);
        final Date created = getCreatedDateFromToken(token);
        //final Date expiration = getExpirationDateFromToken(token);
        return (
                username.equals(user.getUsername())
                        && !isTokenExpired(token)
                        && !isCreatedBeforeLastPasswordReset(created, user.getLastPasswordResetDate()));
    }
}

