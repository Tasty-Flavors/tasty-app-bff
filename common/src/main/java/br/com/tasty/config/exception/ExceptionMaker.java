package br.com.tasty.config.exception;

import br.com.tasty.config.exception.model.ErrorInfo;
import br.com.tasty.config.exception.model.ErrorSpec;
import br.com.tasty.config.exception.model.GenericException;
import br.com.tasty.config.msg.ProvedorDeMensagens;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.BAD_GATEWAY;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class ExceptionMaker {

    private static final String DEFAULT_USER_MSG =
            ProvedorDeMensagens.getInstance().getMensagem("erro.default");

    public static GenericException buildGenericException(
            String message,
            String complemento,
            HttpStatus status) {

        final var msg = ProvedorDeMensagens.getInstance().getMensagem(message);

        return buildException(
                String.format(msg, complemento),
                status
        );
    }

    public static GenericException buildGenericException(
            String message,
            HttpStatus status) {

        final var msg = ProvedorDeMensagens.getInstance().getMensagem(message);

        return buildException(msg, status);
    }

    public static GenericException buildGenericException(
            String message,
            FeignException exception) {

        final var msg = ProvedorDeMensagens.getInstance().getMensagem(message);

        return buildException(
                String.format(msg, exception.getMessage()),
                BAD_GATEWAY
        );
    }

    private static GenericException buildException(
            String msg,
            HttpStatus status) {

        return new GenericException(

                ErrorInfo.builder()

                        .errors(List.of(

                                ErrorSpec.builder()

                                        .namespace("Tasty APP BFF")

                                        .message(Optional.ofNullable(msg)
                                                .orElse(DEFAULT_USER_MSG))

                                        .suggestedUserActions(
                                                List.of(DEFAULT_USER_MSG))

                                        .suggestedApplicationActions(
                                                List.of(Optional.ofNullable(msg)
                                                        .orElse(DEFAULT_USER_MSG)))

                                        .httpStatusCodes(
                                                List.of(Optional.ofNullable(status)
                                                        .orElse(BAD_GATEWAY)))

                                        .build()))

                        .build(),

                status
        );
    }

}