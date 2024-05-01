package com.example.jpa.exception;



import com.example.jpa.common.api.ApiResponse;
import com.example.jpa.common.api.ApiStatus;
import com.example.jpa.common.api.EmptyJsonResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Component
public class RestExceptionHandler extends ResponseEntityExceptionHandler {


    @Override
    protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        return super.handleHttpRequestMethodNotSupported(ex, headers, status, request);
    }

    @ExceptionHandler(BusinessException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            BusinessException ex
    ) {

        return buildResponseEntity(new ApiStatus(NOT_FOUND.value(), ex.getMessage()));
    }

    public ResponseEntity<Object> buildResponseEntity(ApiStatus apiStatus) {
        ApiResponse<Object> apiResponse = new ApiResponse<>(apiStatus, new EmptyJsonResponse());
        return new ResponseEntity<>(apiResponse, BAD_REQUEST);
    }
}
