package traintrack.TrainTrackModulverwaltung.domain.service;

import traintrack.TrainTrackModulverwaltung.application.requests.ModulAnlegenRequest;
import traintrack.TrainTrackModulverwaltung.domain.Modul;
import traintrack.TrainTrackModulverwaltung.domain.ModulStatus;
import traintrack.TrainTrackModulverwaltung.domain.repository.ModulRepository;

import java.util.List;

public class DomainModulService implements ModulService{

    private final ModulRepository modulRepository;

    public DomainModulService(ModulRepository modulRepository) {
        this.modulRepository = modulRepository;
    }

    @Override
    public void modulAnlegen(ModulAnlegenRequest modulAnlegenRequest) {
        Modul modul = Modul.builder()
                .titel(modulAnlegenRequest.titel())
                .status(ModulStatus.ERSTELLT)
                .zusammenfassung(modulAnlegenRequest.zusammenfassung())
                .dauer(modulAnlegenRequest.dauer())
                .art(modulAnlegenRequest.art())
                .mitPruefung(modulAnlegenRequest.mitPruefung())
                .build();
        modulRepository.modulAnlegen(modul);
    }

    @Override
    public List<Modul> alleModuleAnzeigen() {
        return modulRepository.alleModuleAnzeigen();
    }

    @Override
    public void modulAendern(ModulAendernRequest modulAendernRequest) {
        Modul modul = Modul.builder()
                .id(modulAendernRequest.id())
                .titel(modulAendernRequest.titel())
                .zusammenfassung(modulAendernRequest.zusammenfassung())
                .dauer(modulAendernRequest.dauer())
                .art(modulAendernRequest.art())
                .mitPruefung(modulAendernRequest.mitPruefung())
                .build();
        modulRepository.modulAendern(modul);
    }

    @Override
    public void modulVeroeffentlichen(ModulVeroeffentlichenRequest modulVeroeffentlichenRequest) {
        Modul modul = Modul.builder()
                .id(modulVeroeffentlichenRequest.id())
                .status(ModulStatus.VEROEFFENTLICHT)
                .build();
        modulRepository.modulVeroeffentlichen(modul);
    }

    @Override
    public void modulLoeschen(Integer id) {
        Modul modul = Modul.builder()
                .id(id)
                .build();

        modulRepository.modulLoeschen(modul);
    }
}
