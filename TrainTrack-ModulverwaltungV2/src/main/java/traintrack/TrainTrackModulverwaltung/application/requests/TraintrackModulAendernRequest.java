package traintrack.TrainTrackModulverwaltung.application.requests;

public record TraintrackModulAendernRequest(
        int id,
        String titel,
        String zusammenfassung,
        int Teilnehmerzahl,
        float dauer,
        String art,
        boolean mitPruefung
) {
}
