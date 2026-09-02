package br.com.tasty.v1.dashboard;

import br.com.tasty.restauranteservice.RestauranteFacadeIntegration;
import br.com.tasty.v1.dashboard.model.response.RestauranteResponse;
import org.springframework.stereotype.Component;

import static br.com.tasty.v1.dashboard.mapper.RestauranteResponseMapper.mapToRestauranteResponse;

@Component
public class RestauranteFacade {

    private final RestauranteFacadeIntegration restauranteFacadeIntegration;

    public RestauranteFacade(RestauranteFacadeIntegration restauranteFacadeIntegration) {
        this.restauranteFacadeIntegration = restauranteFacadeIntegration;
    }

    public RestauranteResponse dashboard(Integer codigoUsuario) {
        return mapToRestauranteResponse(restauranteFacadeIntegration.dashboard(codigoUsuario));
    }
}