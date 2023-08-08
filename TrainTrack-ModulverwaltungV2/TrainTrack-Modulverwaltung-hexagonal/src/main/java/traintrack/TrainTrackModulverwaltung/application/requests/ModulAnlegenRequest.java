package traintrack.TrainTrackModulverwaltung.application.requests;

public record ModulAnlegenRequest(
        String titel,
        String zusammenfassung,
        float dauer,
        String art,
        boolean mitPruefung){
}
