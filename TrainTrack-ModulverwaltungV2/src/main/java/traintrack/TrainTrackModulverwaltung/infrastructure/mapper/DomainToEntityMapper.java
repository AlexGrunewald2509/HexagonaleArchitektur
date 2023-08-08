package traintrack.TrainTrackModulverwaltung.infrastructure.mapper;


import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;
import traintrack.TrainTrackModulverwaltung.infrastructure.models.TraintrackModulEntity;

import java.util.function.Function;

public class DomainToEntityMapper implements Function<TraintrackModul, TraintrackModulEntity> {
    @Override
    public TraintrackModulEntity apply(final TraintrackModul traintrackModul) {
        if(traintrackModul == null) return null;

        return TraintrackModulEntity.builder()
                .titel(traintrackModul.getTitel())
                .status(traintrackModul.getStatus())
                .zusammenfassung(traintrackModul.getZusammenfassung())
                .teilnehmerzahl(traintrackModul.getTeilnehmerzahl())
                .dauer(traintrackModul.getDauer())
                .art(traintrackModul.getArt())
                .mitPruefung(traintrackModul.isMitPruefung())
                .build();
    }
}
