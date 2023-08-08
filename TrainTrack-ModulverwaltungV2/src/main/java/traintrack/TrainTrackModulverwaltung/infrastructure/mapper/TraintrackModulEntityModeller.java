package traintrack.TrainTrackModulverwaltung.infrastructure.mapper;

import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;
import traintrack.TrainTrackModulverwaltung.infrastructure.modelling.Modeller;
import traintrack.TrainTrackModulverwaltung.infrastructure.models.TraintrackModulEntity;

public class TraintrackModulEntityModeller implements Modeller<TraintrackModulEntity> {

    private final TraintrackModul traintrackModul;

    public TraintrackModulEntityModeller(TraintrackModul traintrackModul) {
        this.traintrackModul = traintrackModul;
    }

    public static TraintrackModulEntityModeller applyChangesFrom(TraintrackModul traintrackModul){
        return new TraintrackModulEntityModeller(traintrackModul);
    }

    @Override
    public TraintrackModulEntity to(final TraintrackModulEntity modulEntity) {
        modulEntity.setTitel(traintrackModul.getTitel());
        modulEntity.setStatus(traintrackModul.getStatus());
        modulEntity.setZusammenfassung(traintrackModul.getZusammenfassung());
        modulEntity.setTeilnehmerzahl(traintrackModul.getTeilnehmerzahl());
        modulEntity.setDauer(traintrackModul.getDauer());
        modulEntity.setArt(traintrackModul.getArt());
        modulEntity.setMitPruefung(traintrackModul.isMitPruefung());

        return modulEntity;
    }
}
