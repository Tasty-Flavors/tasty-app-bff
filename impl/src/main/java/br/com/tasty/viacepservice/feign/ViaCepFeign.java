package br.com.tasty.viacepservice.feign;

import br.com.tasty.viacepservice.model.response.ViaCepResponseImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "${openFeign.viacep-service.name}", url = "${openFeign.viacep-service.url}")
public interface ViaCepFeign {

    @GetMapping("/{cep}/json")
    ViaCepResponseImpl buscarCep(@PathVariable("cep") String cep);

}