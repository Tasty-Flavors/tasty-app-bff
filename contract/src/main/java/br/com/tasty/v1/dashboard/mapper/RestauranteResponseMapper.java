package br.com.tasty.v1.dashboard.mapper;

import br.com.tasty.endereco.EnderecoResponse;
import br.com.tasty.restauranteservice.model.response.EnderecoResponseIntegration;
import br.com.tasty.restauranteservice.model.response.RestauranteResponseIntegration;
import br.com.tasty.v1.dashboard.model.response.RestauranteResponse;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class RestauranteResponseMapper {
    public static RestauranteResponse mapToRestauranteResponse(RestauranteResponseIntegration restauranteResponseIntegration) {
        return RestauranteResponse.builder()
                .nomeEstabelecimento(restauranteResponseIntegration.nomeEstabelecimento())
                .email(restauranteResponseIntegration.email())
                .role(restauranteResponseIntegration.role())
                .build();
    }

    public static EnderecoResponse mapToEnderecoResponse(EnderecoResponseIntegration enderecoResponseIntegration) {
        return EnderecoResponse.builder()
                .cep(enderecoResponseIntegration.cep())
                .logradouro(enderecoResponseIntegration.logradouro())
                .numero(enderecoResponseIntegration.numero())
                .complemento(enderecoResponseIntegration.complemento())
                .bairro(enderecoResponseIntegration.bairro())
                .cidade(enderecoResponseIntegration.cidade())
                .estado(enderecoResponseIntegration.estado())
                .pais(enderecoResponseIntegration.pais())
                .build();
    }

}
