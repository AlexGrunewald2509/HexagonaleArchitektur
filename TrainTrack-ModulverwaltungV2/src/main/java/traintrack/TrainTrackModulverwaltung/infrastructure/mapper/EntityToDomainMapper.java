package traintrack.TrainTrackModulverwaltung.infrastructure.mapper;

import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;
import traintrack.TrainTrackModulverwaltung.infrastructure.models.TraintrackModulEntity;

import java.util.function.Function;

public class EntityToDomainMapper implements Function<TraintrackModulEntity, TraintrackModul> {
    @Override
    public TraintrackModul apply(TraintrackModulEntity traintrackModulEntity) {
        if(traintrackModulEntity == null) return null;

        return TraintrackModul.builder()
                .id(traintrackModulEntity.getId())
                .titel(traintrackModulEntity.getTitel())
                .status(traintrackModulEntity.getStatus())
                .zusammenfassung(traintrackModulEntity.getZusammenfassung())
                .teilnehmerzahl(traintrackModulEntity.getTeilnehmerzahl())
                .dauer(traintrackModulEntity.getDauer())
                .art(traintrackModulEntity.getArt())
                .mitPruefung(traintrackModulEntity.isMitPruefung())
                .build();
    }

}
