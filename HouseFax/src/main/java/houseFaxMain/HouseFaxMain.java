package houseFaxMain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ComponentScan("houseFaxMain")
@ComponentScan("houseFaxRestClient")
@ComponentScan("modals")
@ComponentScan("services")

public class HouseFaxMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(HouseFaxMain.class, args);
	}
}
