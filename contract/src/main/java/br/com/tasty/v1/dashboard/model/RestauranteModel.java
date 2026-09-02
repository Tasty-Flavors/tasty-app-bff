package br.com.tasty.v1.dashboard.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class RestauranteModel {
    private Integer codigoUsuario;
    private String nomeEstabelecimento;
    private String email;
    private String foto;
    private String endereco;
    private String descricao;

}