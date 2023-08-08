package traintrack.TrainTrackModulverwaltung.domain.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class TraintrackModul {
    private int id;
    private String titel;
    private TraintrackModulStatus status;
    private String zusammenfassung;
    private int teilnehmerzahl;
    private float dauer;
    private String art;
    private boolean mitPruefung;

    public TraintrackModul update(final TraintrackModul modul){
        this.titel = modul.getTitel();
        this.zusammenfassung = modul.getZusammenfassung();
        this.teilnehmerzahl = modul.getTeilnehmerzahl();
        this.dauer = modul.getDauer();
        this.art = modul.getArt();
        this.mitPruefung = modul.isMitPruefung();
        return this;
    }

    public TraintrackModul veroeffentlichen(final TraintrackModul modul){
        this.titel = modul.getTitel();
        this.status = TraintrackModulStatus.VEROEFFENTLICHT;
        this.zusammenfassung = modul.getZusammenfassung();
        this.teilnehmerzahl = modul.getTeilnehmerzahl();
        this.dauer = modul.getDauer();
        this.art = modul.getArt();
        this.mitPruefung = modul.isMitPruefung();
        return this;
    }


}
