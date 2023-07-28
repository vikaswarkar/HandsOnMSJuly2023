package handsonms.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
@Slf4j
public class GlobalControllerExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NotFoundException.class)
    public @ResponseBody HttpErrorInfo handleNotFoundExceptions(Exception ex, ServletWebRequest serverHttpRequest){
        return createHtpErrorInfo( HttpStatus.NOT_FOUND, ex, serverHttpRequest );
    }

    @ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
    @ExceptionHandler(InvalidInputException.class)
    public @ResponseBody HttpErrorInfo handleInvalidInputException(Exception ex, ServletWebRequest request ){
        return createHtpErrorInfo( HttpStatus.UNPROCESSABLE_ENTITY, ex, request );
    }
    private HttpErrorInfo createHtpErrorInfo(HttpStatus httpStatus, Exception exception, ServletWebRequest request){
        final String path = request.toString();
        final String message = exception.getMessage();
        log.debug("Returning HTTP Status: {} for path: {}, message: {}", httpStatus, path, message);
        return new HttpErrorInfo( path,httpStatus, message);
    }
}
