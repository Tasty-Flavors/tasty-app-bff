package br.com.tasty.restauranteservice.model.response;

import br.com.tasty.endereco.EnderecoResponse;
import lombok.Builder;

@Builder
public record RestauranteResponseIntegration(
        Integer codigoUsuario,
        String nomeEstabelecimento,
        String email,
        String telefone,
        String cnpj,
        String role,
        Boolean ativo,
        String imagem,
        String descricao,
        EnderecoResponse endereco
) {
}