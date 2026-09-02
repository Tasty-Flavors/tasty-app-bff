package br.com.tasty.autenticacaoservice.service;

import br.com.tasty.autenticacaoservice.feign.AutenticacaoFeign;
import br.com.tasty.config.factory.UsernamePasswordAuthenticationFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AutenticacaoService {

    private final AutenticacaoFeign autenticacaoFeign;

    public UsernamePasswordAuthenticationToken validarToken(String token) {
        try {
            return UsernamePasswordAuthenticationFactory.create(autenticacaoFeign.validarToken(token));
        } catch (RuntimeException e) {
            throw new BadCredentialsException("Token inválido", e);
        }
    }
}
