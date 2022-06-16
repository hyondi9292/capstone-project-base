package jologin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import jologin.CustomerTeamApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { CustomerTeamApplication.class })
public class CucumberSpingConfiguration {}
