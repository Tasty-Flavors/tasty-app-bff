package br.com.tasty.viacepservice.service;

import br.com.tasty.viacepservice.feign.ViaCepFeign;
import br.com.tasty.viacepservice.model.response.ViaCepResponseImpl;
import feign.FeignException;
import org.springframework.stereotype.Service;

@Service
public class ViaCepService {

    private final ViaCepFeign viaCepFeign;

    public ViaCepService(ViaCepFeign viaCepFeign) {
        this.viaCepFeign = viaCepFeign;
    }

    public ViaCepResponseImpl buscarCep(String cep) {
        try {
            return viaCepFeign.buscarCep(cep);
        } catch (FeignException e) {
            throw new IllegalArgumentException("CEP inválido.");
        }
    }
}