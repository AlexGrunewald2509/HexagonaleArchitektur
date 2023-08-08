package traintrack.TrainTrackModulverwaltung.infrastructure;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.Repository;
import traintrack.TrainTrackModulverwaltung.infrastructure.models.TraintrackModulEntity;

import java.util.List;
import java.util.Optional;

public interface TraintrackModulSpringDataJpaRepository extends Repository<TraintrackModulEntity, Integer> {
Optional<TraintrackModulEntity> findByTitel(String titel);

Optional<TraintrackModulEntity> findById(int id);

List<TraintrackModulEntity> findAll();

void save(TraintrackModulEntity modulEntity);

void deleteById(int id);
}
