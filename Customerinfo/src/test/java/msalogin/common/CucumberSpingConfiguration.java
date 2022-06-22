package msalogin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msalogin.CustomerinfoApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomerinfoApplication.class })
public class CucumberSpingConfiguration {}
