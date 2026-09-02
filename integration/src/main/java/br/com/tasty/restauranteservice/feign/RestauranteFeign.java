package br.com.tasty.restauranteservice.feign;


import br.com.tasty.restauranteservice.model.response.RestauranteResponseIntegration;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "${openFeign.restaurante-service.name}",
        url = "${openFeign.restaurante-service.url}"
)
public interface RestauranteFeign {

    @GetMapping("/v1/restaurante/dashboard")
    RestauranteResponseIntegration dashboard(@RequestParam("codigoUsuario")  Integer codigoUsuario);

}