package traintrack.TrainTrackModulverwaltung.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Modul {

    private int id;
    private String titel;
    private ModulStatus status;
    private String zusammenfassung;

    private float dauer;
    private String art;
    private boolean mitPruefung;


}
