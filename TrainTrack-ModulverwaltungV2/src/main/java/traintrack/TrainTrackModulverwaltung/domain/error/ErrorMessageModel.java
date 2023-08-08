package traintrack.TrainTrackModulverwaltung.domain.error;

import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

public record ErrorMessageModel(
        String path,
        String message,
        LocalDateTime localDateTime,
        HttpStatus status
) {
}
