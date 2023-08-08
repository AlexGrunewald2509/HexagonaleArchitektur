package traintrack.TrainTrackModulverwaltung.application.adapter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import traintrack.TrainTrackModulverwaltung.application.mapper.AendernRequestToTraintrackModulMapper;
import traintrack.TrainTrackModulverwaltung.application.mapper.AnlegenRequestToTraintrackModulMapper;
import traintrack.TrainTrackModulverwaltung.application.requests.TraintrackModulAendernRequest;
import traintrack.TrainTrackModulverwaltung.application.requests.TraintrackModulAnlegenRequest;
import traintrack.TrainTrackModulverwaltung.domain.error.TraintrackModulAlreadyExist;
import traintrack.TrainTrackModulverwaltung.domain.models.TraintrackModul;
import traintrack.TrainTrackModulverwaltung.domain.primaryports.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/moduls")
public class TraintrackModulController {

    private final ModulAnlegen modulAnlegen;
    private final AlleModuleAnzeigen alleModuleAnzeigen;
    private final ModulAendern modulAendern;
    private final ModulLoeschen modulLoeschen;
    private final ModulVeroeffentlichen modulVeroeffentlichen;
    private final AnlegenRequestToTraintrackModulMapper RequestToTraintrackModulMapper;
    private final AendernRequestToTraintrackModulMapper aendernRequestToTraintrackModulMapper;

    @Autowired
    public TraintrackModulController(final ModulAnlegen modulAnlegen, AlleModuleAnzeigen alleModuleAnzeigen, ModulAendern modulAendern, ModulLoeschen modulLoeschen, ModulVeroeffentlichen modulVeroeffentlichen, AnlegenRequestToTraintrackModulMapper mapper, AendernRequestToTraintrackModulMapper aendernRequestToTraintrackModulMapper){
        this.alleModuleAnzeigen = alleModuleAnzeigen;
        this.modulAnlegen = modulAnlegen;
        this.modulAendern = modulAendern;
        this.modulLoeschen = modulLoeschen;
        this.modulVeroeffentlichen = modulVeroeffentlichen;
        this.RequestToTraintrackModulMapper = mapper;
        this.aendernRequestToTraintrackModulMapper = aendernRequestToTraintrackModulMapper;
    }

    @PostMapping("/anlegen")
    public ResponseEntity<TraintrackModul> modulAnlegen(@RequestBody TraintrackModulAnlegenRequest request) throws IllegalAccessException, TraintrackModulAlreadyExist {
        final TraintrackModul modul = RequestToTraintrackModulMapper.apply(request);
        return new ResponseEntity<>(modulAnlegen.modulAnlegen(modul), HttpStatus.CREATED);
    }

    @GetMapping("/")
    public ResponseEntity<List<TraintrackModul>> alleModuleAnzeigen(){
        final List<TraintrackModul> response = alleModuleAnzeigen.alleModuleAnzeigen();
        return ResponseEntity.ok(response);
    }

    @PutMapping("/aendern")
    public ResponseEntity<TraintrackModul> modulAendern(@RequestBody TraintrackModulAendernRequest request) {
        final TraintrackModul response = aendernRequestToTraintrackModulMapper.apply(request);
        modulAendern.modulAendern(response);
        return ResponseEntity.ok(response);
    }

    @PutMapping("/veroeffentlichen/{id}")
    public ResponseEntity<TraintrackModul> modulVeroeffentlichen(@PathVariable("id") int id){
        modulVeroeffentlichen.modulVeroeffentlichen(id);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/loeschen/{id}")
    public ResponseEntity<Void> deleteby(@PathVariable("id") int id){
        modulLoeschen.modulLoeschen(id);
        return ResponseEntity.noContent().build();
    }

}
