package br.com.tasty.autenticacaoservice.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(
        name = "${openFeign.autenticacao-service.name}",
        url = "${openFeign.autenticacao-service.url}"
)
public interface AutenticacaoFeign {

    @PostMapping(value = "/tasty-auth-service/login")
    String validarToken(@RequestHeader("accessToken") String token);
}
