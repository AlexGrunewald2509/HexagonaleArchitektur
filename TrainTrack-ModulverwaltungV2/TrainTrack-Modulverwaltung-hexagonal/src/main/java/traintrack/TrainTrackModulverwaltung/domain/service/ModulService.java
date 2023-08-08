package traintrack.TrainTrackModulverwaltung.domain.service;

import traintrack.TrainTrackModulverwaltung.application.requests.ModulAnlegenRequest;
import traintrack.TrainTrackModulverwaltung.domain.Modul;

import java.util.List;

public interface ModulService {

    void modulAnlegen(ModulAnlegenRequest modulAnlegenRequest);

    List<Modul>alleModuleAnzeigen();

    void modulAendern(ModulAendernRequest modulAendernRequest);

    void modulVeroeffentlichen(ModulVeroeffentlichenRequest modulVeroeffentlichenRequest);

    void modulLoeschen(Integer id);
}
