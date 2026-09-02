package br.com.tasty.config.exception;

import br.com.tasty.config.exception.model.GenericException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ResponseError> handleException(GenericException ex) {
        var errorResponse = new ResponseError(
                List.of(new ResponseError.ErrorDetail(ex.getMessage()))
        );

        return new ResponseEntity<>(errorResponse, ex.getStatus());
    }

    @ExceptionHandler(HttpServerErrorException.class)
    public ResponseEntity<ResponseError> handleException(HttpServerErrorException ex) {
        var errorResponse = new ResponseError(
                List.of(new ResponseError.ErrorDetail(ex.getMessage()))
        );

        return new ResponseEntity<>(errorResponse, ex.getStatusCode());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleValidationException(MethodArgumentNotValidException ex) {

        var errorDetails = ex.getBindingResult()
                .getAllErrors()
                .stream()
                .map(error -> new ResponseError.ErrorDetail(error.getDefaultMessage()))
                .toList();

        return ResponseEntity.badRequest().body(new ResponseError(errorDetails));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ResponseError> handleMissingParams(MissingServletRequestParameterException ex) {

        var errorDetails = List.of(
                new ResponseError.ErrorDetail(
                        String.format(
                                "Parâmetro obrigatório ausente: %s do tipo %s",
                                ex.getParameterName(),
                                ex.getParameterType()
                        )
                )
        );

        return ResponseEntity.badRequest().body(new ResponseError(errorDetails));
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ResponseError> handleTypeMismatch(MethodArgumentTypeMismatchException ex) {

        var requiredType = ex.getRequiredType();

        var message = String.format(
                "Parâmetro '%s' recebeu um valor inválido: '%s'. Esperado tipo: %s",
                ex.getName(),
                ex.getValue(),
                requiredType != null ? requiredType.getSimpleName() : "desconhecido"
        );

        var errors = List.of(
                new ResponseError.ErrorDetail(message)
        );

        return ResponseEntity.badRequest().body(new ResponseError(errors));
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ResponseError> handleConstraintViolationException(ConstraintViolationException ex) {

        var errors = ex.getConstraintViolations()
                .stream()
                .map(violation -> new ResponseError.ErrorDetail(violation.getMessage()))
                .collect(Collectors.toList());

        return new ResponseEntity<>(new ResponseError(errors), HttpStatus.BAD_REQUEST);
    }

}