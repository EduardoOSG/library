package com.uam.microservices.catalog.exceptions;

import com.uam.microservices.catalog.utils.Constants;
import lombok.extern.slf4j.Slf4j;
import org.hibernate.id.IdentifierGenerationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.time.LocalDateTime;
import java.util.NoSuchElementException;
import java.util.Objects;

import static com.uam.microservices.catalog.utils.Constants.TIME_ZONE_MX;


@Slf4j
@ControllerAdvice()
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    public static final String TRACE = "trace";



    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ErrorResponse> handleNoSuchElementException(
            NoSuchElementException ex, WebRequest request) {

        log.error("-:Error:-", ex);

        return buildErrorResponse(
                ex,
                ex.getMessage(),
                HttpStatus.NOT_FOUND,
                request
        );
    }

    @ExceptionHandler(AlreadyExistsElementException.class)
    public ResponseEntity<ErrorResponse> handleAlreadyExistsElementException(
            AlreadyExistsElementException ex, WebRequest request) {

        log.error("-:Error:-", ex);

        return buildErrorResponse(
                ex,
                ex.getMessage(),
                HttpStatus.INTERNAL_SERVER_ERROR,
                request
        );
    }

    @ExceptionHandler(GenericException.class)
    public ResponseEntity<ErrorResponse> genericExceptionHandler(
            Exception ex,
            WebRequest request) {

        log.error("-:Error:-", ex);

        return buildErrorResponse(
                ex,
                ex.getMessage(),
                HttpStatus.BAD_REQUEST,
                request
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> globalExceptionHandler(
            Exception ex,
            WebRequest request) {

        log.error("-:Error:-", ex);

        if (ex instanceof IdentifierGenerationException) {
            log.error("GENERIC ERROR::{}", Constants.MESSAGE_ERROR_GENERIC_ERROR);
        }

        return buildErrorResponse(
                ex,
                Constants.MESSAGE_ERROR_GENERIC_ERROR,
                HttpStatus.BAD_REQUEST,
                request
        );
    }

    private ResponseEntity<ErrorResponse> buildErrorResponse(
            Exception exception,
            String message,
            HttpStatus httpStatus,
            WebRequest request
    ) {
        ErrorResponse errorResponse = new ErrorResponse(
                httpStatus.value(),
                message,
                LocalDateTime.now(TIME_ZONE_MX)
        );

        if (isTraceOn(request)) {
            errorResponse.setStackTrace(ExceptionUtils.getStackTrace(exception));
        }

        return ResponseEntity.status(httpStatus).body(errorResponse);
    }

    private boolean isTraceOn(WebRequest request) {
        String[] value = request.getParameterValues(TRACE);
        return Objects.nonNull(value)
                && value.length > 0
                && value[0].contentEquals("true");
    }
}