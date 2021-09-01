package com.springbootpractice.examples.employeemanagement.integrationtest;

import org.junit.runner.RunWith;
import org.springframework.web.client.RestTemplate;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources", plugin = { "pretty" })
public abstract class SpringIntegrationTest {

	protected RestTemplate restTemplate = new RestTemplate();

	protected final String DEFAULT_URL = "http://localhost:8080/";

}