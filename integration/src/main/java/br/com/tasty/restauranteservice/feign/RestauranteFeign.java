package br.com.tasty.restauranteservice.feign;

import br.com.tasty.restauranteservice.model.response.RestauranteResponseIntegration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "${openFeign.tasty-api-service.name}", url = "${openFeign.tasty-api-service.url}")
public interface RestauranteFeign {
    @GetMapping("/tasty-api-service/v1/restaurante/dashboard")
    RestauranteResponseIntegration dashboard(@RequestParam("codigoUsuario") Integer codigoUsuario);

}