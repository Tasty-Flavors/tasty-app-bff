package br.com.tasty.security;

import br.com.tasty.autenticacaoservice.AutenticacaoFacade;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RemoteAuthenticationProvider implements AuthenticationProvider {

    private final AutenticacaoFacade autenticacaoFacade;

    @Override
    public UsernamePasswordAuthenticationToken authenticate(Authentication authentication)
            throws AuthenticationException {

        var token = authentication.getCredentials().toString();
        return autenticacaoFacade.validarToken(token);
    }

    @Override
    public boolean supports(Class<?> authentication) {
        return UsernamePasswordAuthenticationToken.class.isAssignableFrom(authentication);
    }
}
