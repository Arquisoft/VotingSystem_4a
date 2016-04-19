package es.uniovi.asw;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import es.uniovi.asw.pageobjects.PO_Login;
import es.uniovi.asw.utils.SeleniumUtils;

public class SeleniumTest {

	WebDriver driver;
	List<WebElement> elementos = null;

	String getCadenaAlfanumAleatoria(int longitud) {
		String cadenaAleatoria = "";
		long milis = new java.util.GregorianCalendar().getTimeInMillis();
		Random r = new Random(milis);
		int i = 0;
		while (i < longitud) {
			char c = (char) r.nextInt(255);
			if ((c >= '0' && c <= '9') || (c >= 'A' && c <= 'Z')) {
				cadenaAleatoria += c;
				i++;
			}
		}
		return cadenaAleatoria;
	}

	public SeleniumTest() {
	}

	@Before
	public void run() {
		// Creamos el driver para Firefox. Recomendable usar Firefox.
		driver = new FirefoxDriver();
		// Vamos a la página principal de mi aplicación
		// driver.get("http://localhost:8280/sdi2-20"); // TODO
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	@After
	public void end() {
		// Cerramos el navegador
		driver.quit();
	}

	@Test
	public void IdVal() {
		SeleniumUtils.EsperaCargaPagina(driver, "id", "login-form", 10);
		new PO_Login().rellenaFormulario(driver, "usuario1", "usuario1");	// TODO
		SeleniumUtils.EsperaCargaPagina(driver, "id", "tablalistado", 10);
		SeleniumUtils.textoPresentePagina(driver, "Opciones");
	}

}
