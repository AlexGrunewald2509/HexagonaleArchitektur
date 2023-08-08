package traintrack.TrainTrackModulverwaltung.infrastructure.repository;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import traintrack.TrainTrackModulverwaltung.domain.Modul;
import traintrack.TrainTrackModulverwaltung.domain.ModulStatus;
import traintrack.TrainTrackModulverwaltung.domain.repository.ModulRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
@Slf4j
@Component
public class ModulRepositoryImpl implements ModulRepository {

    private final SpringDataPostgresModulRepository modulRepository;

    @Autowired
    public ModulRepositoryImpl(SpringDataPostgresModulRepository springDataPostgresModulRepository, SpringDataPostgresModulRepository modulRepository) {
        this.modulRepository = modulRepository;
    }


    @Override
    public void modulAnlegen(Modul modul) {
        ModulEntity modulEntity = ModulEntity.builder()
                .id(modul.getId())
                .titel(modul.getTitel())
                .status(ModulStatus.ERSTELLT)
                .zusammenfassung(modul.getZusammenfassung())
                .dauer(modul.getDauer())
                .art(modul.getArt())
                .mitPruefung(modul.isMitPruefung())
                .build();
        modulRepository.save(modulEntity);
    }

    @Override
    public List<Modul> alleModuleAnzeigen() {
        List<ModulEntity> modulEntities = modulRepository.findAll();
        List<Modul> moduls = new ArrayList<>();
        modulEntities.forEach(modulEntity -> moduls.add(modulEntity.convertToModul(modulEntity)));
        return moduls;
    }

    @Override
    public void modulAendern(Modul modul) {
        ModulEntity modulEntity = modulRepository.findById(modul.getId());
        modulEntity.setTitel(modul.getTitel());
        modulEntity.setZusammenfassung(modul.getZusammenfassung());
        modulEntity.setDauer(modul.getDauer());
        modulEntity.setArt(modul.getArt());
        modulEntity.setMitPruefung(modul.isMitPruefung());
        modulRepository.save(modulEntity);
    }

    @Override
    public void modulVeroeffentlichen(Modul modul) {
        ModulEntity modulEntity = modulRepository.findById(modul.getId());
        modulEntity.setStatus(ModulStatus.VEROEFFENTLICHT);
        modulRepository.save(modulEntity);
    }

    @Override
    public void modulLoeschen(Modul modul) {
        modulRepository.deleteById(modul.getId());
    }

}
