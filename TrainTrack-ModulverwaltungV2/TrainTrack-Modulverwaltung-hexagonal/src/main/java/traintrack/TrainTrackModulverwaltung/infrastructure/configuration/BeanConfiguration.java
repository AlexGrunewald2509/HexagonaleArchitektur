package traintrack.TrainTrackModulverwaltung.infrastructure.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import traintrack.TrainTrackModulverwaltung.TrainTrackModulverwaltungApplication;
import traintrack.TrainTrackModulverwaltung.domain.repository.ModulRepository;
import traintrack.TrainTrackModulverwaltung.domain.service.DomainModulService;

@Configuration
@ComponentScan(basePackageClasses = TrainTrackModulverwaltungApplication.class)
public class BeanConfiguration {
    @Bean
    ModulService modulService(final ModulRepository modulRepository){
        return new DomainModulService(modulRepository);
    }

}
