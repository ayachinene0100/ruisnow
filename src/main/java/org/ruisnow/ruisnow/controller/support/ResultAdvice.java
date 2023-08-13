package org.ruisnow.ruisnow.controller.support;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.HashMap;

@RestControllerAdvice
public class ResultAdvice implements ResponseBodyAdvice<Object> {

    private static final Logger logger = LoggerFactory.getLogger(ResultAdvice.class);

    @Override
    public boolean supports(@NonNull MethodParameter returnType, @NonNull Class<? extends HttpMessageConverter<?>> converterType) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, @NonNull MethodParameter returnType, @NonNull MediaType selectedContentType, @NonNull Class<? extends HttpMessageConverter<?>> selectedConverterType, @NonNull ServerHttpRequest request, @NonNull ServerHttpResponse response) {
        if (body == null) {
            return Result.ok(new HashMap<>());
        }

        if (body instanceof Result) {
            return body;
        }

        /*
         * 当Controller的方法返回值为String类型时，默认会启用StringHttpMessageConverter
         * 此时这里如果返回Result类型，会尝试将Result转换为String，从而导致类型转换错误
         * 故这里特殊判断，如果response body为String类型，则手动将其转换为Json string
         */
        if (body instanceof String) {
            ObjectMapper mapper = new ObjectMapper();
            try {
                return mapper.writeValueAsString(Result.ok(body));
            } catch (JsonProcessingException e) {
                logger.error("Failed to convert response body {} to Json string.", body, e);
            }
        }

        return Result.ok(body);
    }
}
