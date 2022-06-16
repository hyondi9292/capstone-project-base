package jologin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import jologin.DepositTeamApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { DepositTeamApplication.class })
public class CucumberSpingConfiguration {}
