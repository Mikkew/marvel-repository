package mx.com.mms.marvel.service.app.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import mx.com.mms.marvel.service.app.models.errors.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Object> badRequestException(ResourceNotFoundException ex, HttpServletRequest request) {
        ErrorResponse<String> response = new ErrorResponse<>(
                HttpStatus.BAD_REQUEST.value(),
                LocalDateTime.now(),
                request.getRequestURI(),
                ex.getMessage());
        return response.createResponse(HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<Object> resourceNotFoundException(ResourceNotFoundException ex, HttpServletRequest request) {
        ErrorResponse<String> response = new ErrorResponse<>(
                HttpStatus.NOT_FOUND.value(),
                LocalDateTime.now(),
                request.getRequestURI(),
                ex.getMessage());
        return response.createResponse(HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> globalExceptionHandler(Exception ex, HttpServletRequest request) {
        ErrorResponse<String> response = new ErrorResponse<>(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                LocalDateTime.now(),
                request.getRequestURI(),
                ex.getMessage());
        return response.createResponse(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
