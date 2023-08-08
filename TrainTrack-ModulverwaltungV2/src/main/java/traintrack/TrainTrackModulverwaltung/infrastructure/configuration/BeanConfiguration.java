package traintrack.TrainTrackModulverwaltung.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import traintrack.TrainTrackModulverwaltung.TrainTrackModulverwaltungApplication;
import traintrack.TrainTrackModulverwaltung.application.mapper.AendernRequestToTraintrackModulMapper;
import traintrack.TrainTrackModulverwaltung.application.mapper.AnlegenRequestToTraintrackModulMapper;
import traintrack.TrainTrackModulverwaltung.domain.secondaryports.TraintrackModulRepository;
import traintrack.TrainTrackModulverwaltung.domain.service.TraintrackModulService;
import traintrack.TrainTrackModulverwaltung.infrastructure.mapper.DomainToEntityMapper;
import traintrack.TrainTrackModulverwaltung.infrastructure.mapper.EntityToDomainMapper;

@Configuration
@ComponentScan(basePackageClasses = TrainTrackModulverwaltungApplication.class)
public class BeanConfiguration {

    @Bean
    TraintrackModulService modulService(final TraintrackModulRepository traintrackModulRepository){
        return new TraintrackModulService(traintrackModulRepository);
    }

    @Bean
    DomainToEntityMapper domainToEntityMapper(){
        return new DomainToEntityMapper();
    }

    @Bean
    AnlegenRequestToTraintrackModulMapper requestToTraintrackModulMapper(){
        return new AnlegenRequestToTraintrackModulMapper();
    }

    @Bean
    EntityToDomainMapper entityToDomainMapper(){
        return new EntityToDomainMapper();
    }

    @Bean
    AendernRequestToTraintrackModulMapper aendernRequestToTraintrackModulMapper() {
        return new AendernRequestToTraintrackModulMapper();
    }
}
