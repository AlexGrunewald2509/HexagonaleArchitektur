package traintrack.TrainTrackModulverwaltung.domain.primaryports;

import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;

public interface ModulAnlegen {
    TraintrackModul modulAnlegen(TraintrackModul modul) throws IllegalAccessException;
}
