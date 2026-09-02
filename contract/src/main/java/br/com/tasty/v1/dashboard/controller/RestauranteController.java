package br.com.tasty.v1.dashboard.controller;

import br.com.tasty.v1.dashboard.RestauranteFacade;
import br.com.tasty.v1.dashboard.model.response.RestauranteResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/restaurante")
@SecurityRequirement(name = "BearerAuth")
public class RestauranteController {

    private final RestauranteFacade restauranteFacade;

    public RestauranteController(RestauranteFacade restauranteFacade) {
        this.restauranteFacade = restauranteFacade;
    }

    @GetMapping("/dashboard")
    @ResponseStatus(HttpStatus.OK)
    public RestauranteResponse dashboard(@RequestAttribute("id") Integer codigoUsuario) {
        return restauranteFacade.dashboard(codigoUsuario);
    }
}