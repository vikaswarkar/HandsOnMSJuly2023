package handsonms.util;

import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
@Data
public class HttpErrorInfo {
    private final ZonedDateTime zonedDateTime;
    private final String path;
    private final HttpStatus httpStatus;
    private final String message;

    public HttpErrorInfo(String path, HttpStatus httpStatus, String message) {
        this.zonedDateTime = ZonedDateTime.now();
        this.path = path;
        this.httpStatus = httpStatus;
        this.message = message;
    }
}
