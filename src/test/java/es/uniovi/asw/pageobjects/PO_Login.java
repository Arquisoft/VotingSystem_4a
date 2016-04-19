package es.uniovi.asw.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PO_Login {

    public void rellenaFormulario(WebDriver driver, String pnombre, String ppass) {
	WebElement userid = driver.findElement(By.id("login-form:lg_username"));
	userid.click();
	userid.clear();
	userid.sendKeys(pnombre);
	WebElement password = driver.findElement(By.id("login-form:lg_password"));
	password.click();
	password.clear();
	password.sendKeys(ppass);

	// Pulsar el boton de Alta.
	By boton = By.id("login-form:lg_button");
	driver.findElement(boton).click();
    }

}
