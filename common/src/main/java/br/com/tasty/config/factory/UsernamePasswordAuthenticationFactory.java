package br.com.tasty.config.factory;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.List;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class UsernamePasswordAuthenticationFactory {
    private static final int BEGIN_TOKEN_INDEX = 7;

    public static UsernamePasswordAuthenticationToken create(String codigoUsuario) {
        return new UsernamePasswordAuthenticationToken(
                codigoUsuario,
                null,
                List.of(new SimpleGrantedAuthority("ROLE_USER"))
        );
    }

    public static UsernamePasswordAuthenticationToken create(Object principal, String token) {
        return new UsernamePasswordAuthenticationToken(principal, token.substring(BEGIN_TOKEN_INDEX));
    }
}