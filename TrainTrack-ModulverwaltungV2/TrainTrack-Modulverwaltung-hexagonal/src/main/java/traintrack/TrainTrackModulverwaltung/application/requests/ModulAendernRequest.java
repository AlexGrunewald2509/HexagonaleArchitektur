package traintrack.TrainTrackModulverwaltung.application.requests;

public record ModulAendernRequest(

        int id,
        String titel,
        String zusammenfassung,
        float dauer,
        String art,
        boolean mitPruefung) {
}
