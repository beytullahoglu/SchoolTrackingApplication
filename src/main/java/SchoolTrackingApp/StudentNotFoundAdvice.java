package SchoolTrackingApp;

import org.springframework.http.HttpStatus;
//import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class StudentNotFoundAdvice {
    
    @ResponseBody
    @ExceptionHandler(MemberNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String studentNotFoundHandler(MemberNotFoundException ex){
        return ex.getMessage();
    }
}
