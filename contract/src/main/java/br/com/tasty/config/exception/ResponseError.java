package br.com.tasty.config.exception;

import java.util.List;

public record ResponseError(List<ErrorDetail> errors) {

    public record ErrorDetail(String message) {
    }

}
