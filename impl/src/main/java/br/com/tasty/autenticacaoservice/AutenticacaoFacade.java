package br.com.tasty.autenticacaoservice;

import br.com.tasty.autenticacaoservice.service.AutenticacaoService;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Component;

@Component
public class AutenticacaoFacade {
    private final AutenticacaoService autenticacaoService;

    public AutenticacaoFacade(AutenticacaoService autenticacaoService) {
        this.autenticacaoService = autenticacaoService;
    }

    public UsernamePasswordAuthenticationToken validarToken(String token) {
        return autenticacaoService.validarToken(token);
    }
}
