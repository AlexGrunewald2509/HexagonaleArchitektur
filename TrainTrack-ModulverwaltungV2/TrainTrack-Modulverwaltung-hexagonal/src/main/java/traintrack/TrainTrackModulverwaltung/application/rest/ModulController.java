package traintrack.TrainTrackModulverwaltung.application.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import traintrack.TrainTrackModulverwaltung.application.requests.ModulAnlegenRequest;
import traintrack.TrainTrackModulverwaltung.domain.Modul;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/moduls")
public class ModulController {

    private final ModulService modulService;

    @Autowired
    public ModulController(ModulService modulService) {
        this.modulService = modulService;
    }

    @PostMapping("/anlegen")
    public void modulAnlegen(@RequestBody ModulAnlegenRequest modulAnlegenRequest){
        //Domainlog.info("Neues Modul angelegt {}", modulAnlegenRequest);
        modulService.modulAnlegen(modulAnlegenRequest);
    }
    @GetMapping("/")
    public List<Modul> alleModuleAnzeigen(){
        log.info("Ausgabe aller Module");
        return modulService.alleModuleAnzeigen();
    }
    @PutMapping("/aendern")
    public void modulAendern(@RequestBody ModulAendernRequest modulAendernRequest){
        modulService.modulAendern(modulAendernRequest);
    }
    @PutMapping("/veroeffentlichen")
    public void modulVeroeffentlichen(@RequestBody ModulVeroeffentlichenRequest modulVeroeffentlichenRequest){
        modulService.modulVeroeffentlichen(modulVeroeffentlichenRequest);
    }
    @DeleteMapping("/loeschen/{id}")
    public void modulLoeschen(@PathVariable("id") Integer id){
        modulService.modulLoeschen(id);
    }
}
