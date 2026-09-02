package br.com.tasty.viacepservice;

import br.com.tasty.viacepservice.model.response.ViaCepResponseImpl;
import br.com.tasty.viacepservice.service.ViaCepService;
import org.springframework.stereotype.Component;

@Component
public class ViaCepFacadeImpl {
    private final ViaCepService viaCepService;

    public ViaCepFacadeImpl(ViaCepService viaCepService) {
        this.viaCepService = viaCepService;
    }

    public ViaCepResponseImpl buscarCep(String cep) {
        return viaCepService.buscarCep(cep);
    }
}
