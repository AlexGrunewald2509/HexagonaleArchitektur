package traintrack.TrainTrackModulverwaltung.domain.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import traintrack.TrainTrackModulverwaltung.domain.error.TrainTrackModulNotFound;
import traintrack.TrainTrackModulverwaltung.domain.error.TraintrackModulAlreadyExist;
import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;
import traintrack.TrainTrackModulverwaltung.domain.primaryports.*;
import traintrack.TrainTrackModulverwaltung.domain.secondaryports.TraintrackModulRepository;

import java.util.List;
import java.util.Optional;

@Slf4j
public class TraintrackModulService implements ModulAnlegen, AlleModuleAnzeigen, ModulVeroeffentlichen, ModulAendern, ModulLoeschen {

    private final TraintrackModulRepository traintrackModulRepository;

    @Autowired
    public TraintrackModulService(TraintrackModulRepository traintrackModulRepository){
        this.traintrackModulRepository = traintrackModulRepository;
    }
    @Override
    public TraintrackModul modulAnlegen(TraintrackModul modul){
        final Optional<TraintrackModul> existingTraintrackModul = traintrackModulRepository.findByTitle(modul.getTitel());
        if(existingTraintrackModul.isPresent()){
            throw new TraintrackModulAlreadyExist(
                    String.format("Es gibt bereits ein Traintrack-Modul mit dem Titel: %s", modul.getTitel())
            );
        }
        traintrackModulRepository.save(modul);
        return modul;
    }


    @Override
    public List<TraintrackModul> alleModuleAnzeigen() {
        return traintrackModulRepository.findAll();
    }

    @Override
    public void modulVeroeffentlichen(int id) {
        final TraintrackModul foundTraintrackModul = traintrackModulRepository.findById(id)
                .orElseThrow(
                        () -> new TrainTrackModulNotFound(String.format("Das Modul mit der angegebenen Id gibt es nicht", id))
                );
        log.info("found Modul {}",foundTraintrackModul.toString());
        final TraintrackModul updatedTraintrackModul = foundTraintrackModul.veroeffentlichen(foundTraintrackModul);
        log.info("updated Modul {}",updatedTraintrackModul.toString());
        traintrackModulRepository.updateTraintrackModul(updatedTraintrackModul);
    }

    @Override
    public TraintrackModul modulAendern(TraintrackModul modul) {
        if(modul == null) throw  new IllegalArgumentException("Modul ändern Aufruf darf nicht Null sein!");

        final TraintrackModul foundTraintrackModul = traintrackModulRepository.findById(modul.getId())
                .orElseThrow(
                        () -> new TrainTrackModulNotFound(String.format("Das Modul mit der angegebenen Id gibt es nicht", modul.getId()))
                );
        final TraintrackModul updatedTraintrackModul = foundTraintrackModul.update(modul);
        traintrackModulRepository.updateTraintrackModul(updatedTraintrackModul);
        return updatedTraintrackModul;

    }

    @Override
    public void modulLoeschen(int id) {
        traintrackModulRepository.findById(id)
                .orElseThrow(
                        () -> new TrainTrackModulNotFound(String.format("Das Modul mit der angegebenen Id gibt es nicht", id))
                );
        traintrackModulRepository.deleteById(id);
    }
}
