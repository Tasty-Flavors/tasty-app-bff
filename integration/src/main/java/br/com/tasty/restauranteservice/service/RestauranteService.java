package br.com.tasty.restauranteservice.service;

import br.com.tasty.restauranteservice.feign.RestauranteFeign;
import br.com.tasty.restauranteservice.model.response.RestauranteResponseIntegration;
import org.springframework.stereotype.Service;

@Service
public class RestauranteService {

    private final RestauranteFeign restauranteFeign;

    public RestauranteService(RestauranteFeign restauranteFeign) {
        this.restauranteFeign = restauranteFeign;
    }

    public RestauranteResponseIntegration dashboard(Integer codigoUsuario) {
        return restauranteFeign.dashboard(codigoUsuario);
    }

}