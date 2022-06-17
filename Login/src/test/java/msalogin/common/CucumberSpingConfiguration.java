package msalogin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msalogin.LoginApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { LoginApplication.class })
public class CucumberSpingConfiguration {}
