package br.com.tasty.autenticacaoservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "${openFeign.autenticacao-service.name}",
        url = "${openFeign.autenticacao-service.url}"
)
public interface AutenticacaoFeign {

    @GetMapping(value = "/tasty-auth-service/v1/oauth/token/info")
    String validarToken(@RequestHeader("accessToken") String accessToken);
}
