package br.com.tasty.v1.viacep.controller;

import br.com.tasty.v1.viacep.ViaCepFacade;
import br.com.tasty.v1.viacep.model.response.ViaCepResponse;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/cep")
public class ViaCepController {

    private final ViaCepFacade viaCepFacade;

    public ViaCepController(ViaCepFacade viaCepFacade) {
        this.viaCepFacade = viaCepFacade;
    }

    @GetMapping("/{cep}")
    @ResponseStatus(HttpStatus.OK)
    public ViaCepResponse buscarCep(@PathVariable String cep) {
        return viaCepFacade.buscarCep(cep);
    }
}