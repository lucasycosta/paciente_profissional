package com.zeussh.gestao_pessoas;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;

@CucumberOptions(features = "src/test/resources/feature",
				snippets = SnippetType.CAMELCASE,
				plugin = {"pretty", "html:target/report-html/report-unittest.html"},
				glue = {"com.zeussh.gestao_pessoas.controller"},
				tags = "@unitario",
				monochrome = true) 
@RunWith(Cucumber.class)
public class CucumberTest {

}
