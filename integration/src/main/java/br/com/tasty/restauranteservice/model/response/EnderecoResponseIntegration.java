package br.com.tasty.restauranteservice.model.response;

import lombok.Builder;

@Builder
public record EnderecoResponseIntegration(
        String cep,
        String logradouro,
        Integer numero,
        String complemento,
        String bairro,
        String cidade,
        String estado,
        String pais
) {
}