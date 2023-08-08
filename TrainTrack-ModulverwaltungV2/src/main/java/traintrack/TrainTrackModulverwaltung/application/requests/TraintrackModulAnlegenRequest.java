package traintrack.TrainTrackModulverwaltung.application.requests;

public record TraintrackModulAnlegenRequest(
        String titel,
        String zusammenfassung,
        int Teilnehmerzahl,
        float dauer,
        String art,
        boolean mitPruefung
) {
}
