package br.com.tasty.v1.dashboard.model.response;

import br.com.tasty.endereco.EnderecoResponse;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RestauranteResponse {
    private Integer codigoUsuario;
    private String nomeEstabelecimento;
    private String email;
    private String telefone;
    private String cnpj;
    private String role;
    private Boolean ativo;
    private String imagem;
    private EnderecoResponse endereco;
}