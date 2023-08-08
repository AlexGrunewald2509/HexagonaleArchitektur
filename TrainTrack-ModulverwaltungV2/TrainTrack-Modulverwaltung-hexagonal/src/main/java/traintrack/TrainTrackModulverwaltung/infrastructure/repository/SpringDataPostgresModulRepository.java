package traintrack.TrainTrackModulverwaltung.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import traintrack.TrainTrackModulverwaltung.infrastructure.repository.ModulEntity;

@Repository
public interface SpringDataPostgresModulRepository extends JpaRepository<ModulEntity, Integer> {
    ModulEntity findById(int id);
}
