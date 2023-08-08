package traintrack.TrainTrackModulverwaltung.domain.secondaryports;

import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;

import java.util.List;
import java.util.Optional;

public interface TraintrackModulRepository {
    Optional<TraintrackModul> findByTitle(String title);

    Optional<TraintrackModul> findById(int id);

    List<TraintrackModul> findAll();

    void save(TraintrackModul traintrackModul);

    TraintrackModul updateTraintrackModul(TraintrackModul traintrackModul);

    void deleteById(int id);
}
