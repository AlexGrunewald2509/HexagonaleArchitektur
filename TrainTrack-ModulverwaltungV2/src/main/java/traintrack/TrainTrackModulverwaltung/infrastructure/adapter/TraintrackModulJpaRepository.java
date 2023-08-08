package traintrack.TrainTrackModulverwaltung.infrastructure.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import traintrack.TrainTrackModulverwaltung.domain.error.TrainTrackModulNotFound;
import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;
import traintrack.TrainTrackModulverwaltung.domain.secondaryports.TraintrackModulRepository;
import traintrack.TrainTrackModulverwaltung.infrastructure.TraintrackModulSpringDataJpaRepository;
import traintrack.TrainTrackModulverwaltung.infrastructure.mapper.DomainToEntityMapper;
import traintrack.TrainTrackModulverwaltung.infrastructure.mapper.EntityToDomainMapper;
import traintrack.TrainTrackModulverwaltung.infrastructure.mapper.TraintrackModulEntityModeller;
import traintrack.TrainTrackModulverwaltung.infrastructure.models.TraintrackModulEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
@Slf4j
public class TraintrackModulJpaRepository implements TraintrackModulRepository {

    private final TraintrackModulSpringDataJpaRepository repository;

    private final DomainToEntityMapper DomainToEntityMapper;

    private final EntityToDomainMapper entityToDomainMapper;

    @Autowired
    public TraintrackModulJpaRepository(TraintrackModulSpringDataJpaRepository repository, DomainToEntityMapper domainToEntityMapper, EntityToDomainMapper entityToDomainMapper) {
        this.repository = repository;
        this.DomainToEntityMapper = domainToEntityMapper;
        this.entityToDomainMapper = entityToDomainMapper;
    }

    @Override
    public Optional<TraintrackModul> findByTitle(final String title) {
        if(title == null) throw new IllegalArgumentException("Title darf nicht Null sein");
        Optional<TraintrackModulEntity> traintrackModulEntity = repository.findByTitel(title);
        return traintrackModulEntity.map(entityToDomainMapper);
    }

    @Override
    public Optional<TraintrackModul> findById(final int id) {
        return repository.findById(id).map(entityToDomainMapper);
    }

    @Override
    public List<TraintrackModul> findAll() {
        return repository.findAll().stream().map(entityToDomainMapper).toList();
    }

    @Override
    public void save(TraintrackModul traintrackModul) {
        log.info("Saving Traintrack-Modul.....");
        log.info("status",traintrackModul.getStatus());
        final TraintrackModulEntity modulEntity = DomainToEntityMapper.apply(traintrackModul);
        repository.save(modulEntity);
    }

    @Override
    public TraintrackModul updateTraintrackModul(TraintrackModul traintrackModul) {
        if(traintrackModul == null) throw new IllegalArgumentException("Traintrack-Modul darf nicht Null sein");
        log.info("Im Repo",traintrackModul.toString());
        final TraintrackModulEntity traintrackModulEntity = repository.findById(traintrackModul.getId())
                .orElseThrow(
                        () -> new TrainTrackModulNotFound("Traintrack-Modul mit der übergebenen Id konnte nicht gefunden werden" + traintrackModul.getId())
                );

        final TraintrackModulEntity updatedTraintrackModul = TraintrackModulEntityModeller.applyChangesFrom(traintrackModul).to(traintrackModulEntity);
        repository.save(updatedTraintrackModul);

        return traintrackModul;
    }

    @Override
    public void deleteById(int id) {
        repository.deleteById(id);
    }


}
