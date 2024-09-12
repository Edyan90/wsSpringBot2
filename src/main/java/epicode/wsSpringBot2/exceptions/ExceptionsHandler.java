package epicode.wsSpringBot2.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ExceptionsHandler {
    @ExceptionHandler(NotFoundEx.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorPayload handleNotfoundEx(NotFoundEx ex) {
        return new ErrorPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(BadRequestEx.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorPayload handleBadRequest(BadRequestEx ex) {
        return new ErrorPayload(ex.getMessage(), LocalDateTime.now());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorPayload handleGenericErrors(Exception ex) {
        ex.printStackTrace();
        return new ErrorPayload("Problema lato server, apri un ticket e aspetta il tuo turno!", LocalDateTime.now());
    }
}
