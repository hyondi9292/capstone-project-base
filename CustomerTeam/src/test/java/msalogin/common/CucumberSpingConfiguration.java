package msalogin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msalogin.CustomerTeamApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomerTeamApplication.class })
public class CucumberSpingConfiguration {}
