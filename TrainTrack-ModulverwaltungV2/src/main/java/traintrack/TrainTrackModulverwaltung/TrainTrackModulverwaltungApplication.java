package traintrack.TrainTrackModulverwaltung;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;


@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "TrainTack-Modulverwaltung",
				version = "0.1",
				description = "Übungsprojekt zum Erstellen eines Microservice-Leitfadens der ITGAIN"
		)
)
public class TrainTrackModulverwaltungApplication {

	public static void main(String[] args) {
		ApplicationContext ctx = SpringApplication.run(TrainTrackModulverwaltungApplication.class, args);
	}

}
