package jologin.common;

import io.cucumber.spring.CucumberContextConfiguration;
import jologin.FrontApplication;
import org.springframework.boot.test.context.SpringBootTest;

@CucumberContextConfiguration
@SpringBootTest(classes = { FrontApplication.class })
public class CucumberSpingConfiguration {}
