package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.*;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Apptest {
	private WebDriver navegador1 = new FirefoxDriver();
	private WebDriver navegador2 = new FirefoxDriver();
	@Test
	public void test() {
		navegador1.get("http://localhost:8080");
		navegador2.get("http://localhost:8080");
	}

}
