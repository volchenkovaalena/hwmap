package volchenkova.hwmap.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class InvalidNameException extends RuntimeException{
    public InvalidNameException (String message) {super (message);}
}
