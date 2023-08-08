package traintrack.TrainTrackModulverwaltung.domain.repository;

import traintrack.TrainTrackModulverwaltung.domain.Modul;

import java.util.List;
import java.util.Optional;

public interface ModulRepository {

    void modulAnlegen(Modul modul);

    List<Modul> alleModuleAnzeigen();

    public void modulAendern(Modul modul);

    public void modulVeroeffentlichen(Modul modul);

    void modulLoeschen(Modul modul);
}
