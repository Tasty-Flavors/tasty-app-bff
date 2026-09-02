package br.com.tasty.common.feign;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import feign.FeignException;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.springframework.util.StringUtils;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

import static br.com.tasty.config.exception.ExceptionMaker.buildGenericException;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class FeignExceptionBff {

    private static final ObjectMapper mapper = new ObjectMapper();

    public static String extrairMessageFromFeignException(FeignException e) {
        var content = extrairBody(e);
        validarConteudo(content, e);
        try {
            var root = mapper.readTree(content);
            var errors = root.path("errors");

            if (errors.isArray() && !errors.isEmpty()) {
                return errors.get(0).path("message").asText();
            }

            return e.getMessage();

        } catch (JsonProcessingException ex) {
            throw buildGenericException("erro.feign.message", e.getMessage(), INTERNAL_SERVER_ERROR);
        }
    }

    private static void validarConteudo(String content, FeignException e) {
        if (!StringUtils.hasText(content)) {
            throw buildGenericException("erro.service.feign", e.getMessage(), INTERNAL_SERVER_ERROR);
        }
    }

    private static String extrairBody(FeignException e) {
        if (Objects.isNull(e))
            throw buildGenericException("erro.service.feign.body", INTERNAL_SERVER_ERROR);

        return e.responseBody()
                .map(ByteBuffer::array)
                .map(bytes -> new String(bytes, StandardCharsets.UTF_8))
                .orElse(null);
    }

}
