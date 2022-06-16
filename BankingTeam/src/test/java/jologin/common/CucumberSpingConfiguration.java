package jologin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import jologin.BankingTeamApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { BankingTeamApplication.class })
public class CucumberSpingConfiguration {}
