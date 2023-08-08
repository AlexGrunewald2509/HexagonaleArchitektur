package traintrack.TrainTrackModulverwaltung.domain.error;

public class TraintrackModulAlreadyExist extends RuntimeException{
    public TraintrackModulAlreadyExist(final String message){
        super(message);
    }
}
