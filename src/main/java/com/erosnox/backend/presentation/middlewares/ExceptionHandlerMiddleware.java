package com.erosnox.backend.presentation.middlewares;


import com.erosnox.backend.application.exceptions.BadRequestException;
import com.erosnox.backend.application.exceptions.ConflictException;
import com.erosnox.backend.application.exceptions.NotFoundException;
import com.erosnox.backend.application.exceptions.UnauthorizedException;
import com.erosnox.backend.presentation.schemas.common.ErrorSchema;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionHandlerMiddleware {

    @ExceptionHandler(ConflictException.class)
    public ResponseEntity<ErrorSchema> handleConflictException(ConflictException ex) {
        return errorMessage(HttpStatus.CONFLICT, ex.getMessage());
    }

    @ExceptionHandler({BadRequestException.class, IllegalArgumentException.class})
    public ResponseEntity<ErrorSchema> handleBadRequestException(Exception ex) {
        return errorMessage(HttpStatus.BAD_REQUEST, ex.getMessage());
    }

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorSchema> handleNotFoundException(NotFoundException ex) {
        return errorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<ErrorSchema> handleUnauthorizedException(UnauthorizedException ex) {
        return errorMessage(HttpStatus.UNAUTHORIZED, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorSchema> handleInternalServerError(Exception ex) {
        return errorMessage(HttpStatus.INTERNAL_SERVER_ERROR,
                "An internal server error occurred: \n" + ex.getMessage());
    }

    private ResponseEntity<ErrorSchema> errorMessage(HttpStatus status, String message) {
        return ResponseEntity.status(status)
                .body(new ErrorSchema(status.value(), message));
    }
}
