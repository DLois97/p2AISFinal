package es.codeurjc.ais.tictactoe;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Apptest {
	private WebDriver navegador1;
	private WebDriver navegador2;
	
	@BeforeClass
	public static void setupClass() {
	System.setProperty("webdriver.gecko.driver", "/absolute/path/to/geckodriver");
	WebApp.start();
	}
	
	@AfterClass
	public static void teardownClass() {
		WebApp.stop();
	}
	
	@Before
	public void setUp() {
		navegador1 = new FirefoxDriver();
		navegador2 = new FirefoxDriver();
	}
	
	@After
	public void teardown() {
		if (navegador1 != null) {
			navegador1.quit();
		}
		if (navegador2 != null) {
			navegador2.quit();
		}
	}
	
	@Test
	public void testIfWinsFirst() {
		navegador1.get("http://localhost:8080");
		navegador2.get("http://localhost:8080");
		
		
		String nombre1 = "Javi";
		String nombre2 = "Dani";
		navegador1.findElement(By.id("nickname")).sendKeys(nombre1);
		navegador1.findElement(By.id("startBtn")).click();
		navegador2.findElement(By.id("nickname")).sendKeys(nombre2);
		navegador2.findElement(By.id("startBtn")).click();
		navegador1.findElement(By.id("cell-0")).click();
		navegador2.findElement(By.id("cell-3")).click();
		navegador1.findElement(By.id("cell-1")).click();
		navegador2.findElement(By.id("cell-7")).click();
		navegador1.findElement(By.id("cell-2")).click();
		navegador1.switchTo().alert().getText();
		//assertThat("Javi wins! Dani looses.").isEqualTo(navegador1.switchTo().alert().getText());
		assertEquals("Javi wins! Dani looses.",navegador1.switchTo().alert().getText());
		
	}
	
	@Test
	public void testIfWinsSecond() {
		navegador1.get("http://localhost:8080");
		navegador2.get("http://localhost:8080");
		
		
		String nombre1 = "Javi";
		String nombre2 = "Dani";
		navegador1.findElement(By.id("nickname")).sendKeys(nombre1);
		navegador1.findElement(By.id("startBtn")).click();
		navegador2.findElement(By.id("nickname")).sendKeys(nombre2);
		navegador2.findElement(By.id("startBtn")).click();
		navegador1.findElement(By.id("cell-3")).click();
		navegador2.findElement(By.id("cell-0")).click();
		navegador1.findElement(By.id("cell-7")).click();
		navegador2.findElement(By.id("cell-1")).click();
		navegador1.findElement(By.id("cell-5")).click();
		navegador2.findElement(By.id("cell-2")).click();;
		//assertThat("Javi wins! Dani looses.").isEqualTo(navegador1.switchTo().alert().getText());
		assertEquals("Dani wins! Javi looses.",navegador1.switchTo().alert().getText());
		
	}
	
	
	@Test
	public void testCheckDraw() {
		navegador1.get("http://localhost:8080");
		navegador2.get("http://localhost:8080");
		
		
		String nombre1 = "Javi";
		String nombre2 = "Dani";
		navegador1.findElement(By.id("nickname")).sendKeys(nombre1);
		navegador1.findElement(By.id("startBtn")).click();
		navegador2.findElement(By.id("nickname")).sendKeys(nombre2);
		navegador2.findElement(By.id("startBtn")).click();
		navegador1.findElement(By.id("cell-0")).click();
		navegador2.findElement(By.id("cell-3")).click();
		navegador1.findElement(By.id("cell-1")).click();
		navegador2.findElement(By.id("cell-4")).click();
		navegador1.findElement(By.id("cell-6")).click();
		navegador2.findElement(By.id("cell-7")).click();
		navegador1.findElement(By.id("cell-5")).click();
		navegador2.findElement(By.id("cell-2")).click();
		navegador2.findElement(By.id("cell-8")).click();
		//assertThat("Javi wins! Dani looses.").isEqualTo(navegador1.switchTo().alert().getText());
		assertEquals("Draw!",navegador1.switchTo().alert().getText());
		
	}
	
	
	
	
}
