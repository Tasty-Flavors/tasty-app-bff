package br.com.tasty.restauranteservice;

import br.com.tasty.restauranteservice.model.response.RestauranteResponseIntegration;
import br.com.tasty.restauranteservice.service.RestauranteService;
import org.springframework.stereotype.Component;

@Component
public class RestauranteFacadeIntegration {

    private final RestauranteService restauranteService;

    public RestauranteFacadeIntegration(RestauranteService restauranteService) {
        this.restauranteService = restauranteService;
    }

    public RestauranteResponseIntegration dashboard(Integer codigoUsuario) {
        return restauranteService.dashboard(codigoUsuario);
    }

}