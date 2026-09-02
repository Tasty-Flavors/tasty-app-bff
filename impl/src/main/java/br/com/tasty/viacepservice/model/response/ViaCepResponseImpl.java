package br.com.tasty.viacepservice.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

@Builder
public record ViaCepResponseImpl(
        String cep,
        String logradouro,
        String complemento,
        String bairro,
        @JsonProperty("localidade")
        String cidade,
        String uf,
        String estado,
        String regiao,
        String ibge,
        String gia,
        String ddd,
        String siafi,
        Boolean erro
) {
}