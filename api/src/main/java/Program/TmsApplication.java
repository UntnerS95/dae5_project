package Program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author Untner Stefan (S2010306033)
 *
 */

@SpringBootApplication(scanBasePackages = { "PresentationLayer.controller", "PresentationLayer.swagger", "Program" })
public class TmsApplication {

	public static void main(String[] args) {
		SpringApplication.run(TmsApplication.class, args);
	}

}
