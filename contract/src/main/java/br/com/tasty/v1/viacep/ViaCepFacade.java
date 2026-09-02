package br.com.tasty.v1.viacep;

import br.com.tasty.v1.viacep.model.response.ViaCepResponse;
import br.com.tasty.viacepservice.ViaCepFacadeImpl;
import org.springframework.stereotype.Component;

import static br.com.tasty.v1.viacep.mapper.ViaCepMapper.mapToViaCepResponse;

@Component
public class ViaCepFacade {

    private final ViaCepFacadeImpl viaCepFacadeImpl;

    public ViaCepFacade(ViaCepFacadeImpl viaCepFacadeImpl) {
        this.viaCepFacadeImpl = viaCepFacadeImpl;
    }

    public ViaCepResponse buscarCep(String cep) {
        return mapToViaCepResponse(viaCepFacadeImpl.buscarCep(cep));
    }
}