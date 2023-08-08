package traintrack.TrainTrackModulverwaltung.application.mapper;

import traintrack.TrainTrackModulverwaltung.application.requests.TraintrackModulAendernRequest;
import traintrack.TrainTrackModulverwaltung.application.requests.TraintrackModulAnlegenRequest;
import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;
import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModulStatus;

import java.util.function.Function;

public class AendernRequestToTraintrackModulMapper implements Function<TraintrackModulAendernRequest, TraintrackModul> {
    @Override
    public TraintrackModul apply(TraintrackModulAendernRequest request) {
        if(request == null) return null;
        return TraintrackModul.builder()
                .id(request.id())
                .titel(request.titel())
                .zusammenfassung(request.zusammenfassung())
                .teilnehmerzahl(request.Teilnehmerzahl())
                .dauer(request.dauer())
                .art(request.art())
                .mitPruefung(request.mitPruefung())
                .build();
    }
}
