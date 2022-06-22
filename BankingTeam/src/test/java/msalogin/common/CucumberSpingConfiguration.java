package msalogin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import msalogin.BankingTeamApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { BankingTeamApplication.class })
public class CucumberSpingConfiguration {}
