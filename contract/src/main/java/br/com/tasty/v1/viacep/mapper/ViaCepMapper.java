package br.com.tasty.v1.viacep.mapper;

import br.com.tasty.v1.viacep.model.response.ViaCepResponse;
import br.com.tasty.viacepservice.model.response.ViaCepResponseImpl;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ViaCepMapper {

    public static ViaCepResponse mapToViaCepResponse(ViaCepResponseImpl response) {

        return ViaCepResponse.builder()
                .cep(response.cep())
                .logradouro(response.logradouro())
                .complemento(response.complemento())
                .bairro(response.bairro())
                .cidade(response.cidade())
                .estado(response.estado())
                .uf(response.uf())
                .build();
    }

}