package traintrack.TrainTrackModulverwaltung.application.mapper;

import traintrack.TrainTrackModulverwaltung.application.requests.TraintrackModulAnlegenRequest;
import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;
import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModulStatus;

import java.util.function.Function;

public class AnlegenRequestToTraintrackModulMapper implements Function<TraintrackModulAnlegenRequest, TraintrackModul> {
    @Override
    public TraintrackModul apply(TraintrackModulAnlegenRequest request) {
        if(request == null) return null;
        return TraintrackModul.builder()
                .titel(request.titel())
                .status(TraintrackModulStatus.ERSTELLT)
                .zusammenfassung(request.zusammenfassung())
                .teilnehmerzahl(request.Teilnehmerzahl())
                .dauer(request.dauer())
                .art(request.art())
                .mitPruefung(request.mitPruefung())
                .build();
    }
}
