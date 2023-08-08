package traintrack.TrainTrackModulverwaltung.infrastructure.repository;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import traintrack.TrainTrackModulverwaltung.domain.Modul;
import traintrack.TrainTrackModulverwaltung.domain.ModulStatus;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ModulEntity {

    @Id
    @SequenceGenerator(
            name = "modul_id_sequence",
            sequenceName = "modul_id_sequence"
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "modul_id_sequence"
    )
    private int id;

    private String titel;
    private ModulStatus status;
    private String zusammenfassung;

    private float dauer;
    private String art;
    private boolean mitPruefung;

    public Modul convertToModul(ModulEntity modulEntity){
        Modul modul = new Modul();
        modul.setId(modulEntity.getId());
        modul.setTitel(modulEntity.getTitel());
        modul.setStatus(modulEntity.getStatus());
        modul.setZusammenfassung(modulEntity.getZusammenfassung());
        modul.setDauer(modulEntity.getDauer());
        modul.setArt(modulEntity.getArt());
        modul.setMitPruefung(modulEntity.isMitPruefung());
        return modul;
    }



}
