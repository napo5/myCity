package app.security;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenDecoder {

    public static String getUsername(TokenAuthentication IDToken) {

        String credentials = IDToken.getCredentials();
        DecodedJWT jwt = JWT.decode(credentials);
        Claim claim = jwt.getClaim("nickname");
        return claim.asString();
    }

    public static String getFullName(TokenAuthentication IDToken) {

        String credentials = IDToken.getCredentials();
        DecodedJWT jwt = JWT.decode(credentials);
        Claim claim = jwt.getClaim("name");
        return claim.asString();
    }
    
    public static String getEmail(TokenAuthentication IDToken) {

        String credentials = IDToken.getCredentials();
        DecodedJWT jwt = JWT.decode(credentials);
        Claim claim = jwt.getClaim("email");
        return claim.asString();
    }
}
