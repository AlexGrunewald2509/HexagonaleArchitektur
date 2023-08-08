package traintrack.TrainTrackModulverwaltung.domain.error;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(TraintrackModulAlreadyExist.class)
    ResponseEntity<ErrorMessageModel> traintrackModulAlreadyExist(final TraintrackModulAlreadyExist ex, HttpServletRequest request){
        final ErrorMessageModel errorMessageModel = new ErrorMessageModel(
                request.getRequestURI(),
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.BAD_REQUEST
        );

        return new ResponseEntity<>(errorMessageModel, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(TrainTrackModulNotFound.class)
    ResponseEntity<ErrorMessageModel> traintrackModulNotFound(final TrainTrackModulNotFound ex, HttpServletRequest request){
        final ErrorMessageModel errorMessageModel = new ErrorMessageModel(
                request.getRequestURI(),
                ex.getMessage(),
                LocalDateTime.now(),
                HttpStatus.NOT_FOUND
        );

        return new ResponseEntity<>(errorMessageModel, HttpStatus.NOT_FOUND);
    }
}
