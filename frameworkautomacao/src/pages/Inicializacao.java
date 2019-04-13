package pages;

import org.junit.Test;
import org.openqa.selenium.By;

import core.BasePage;

public class Inicializacao extends BasePage {
	
	public void abrirsite () {
		abrirurl("https://mark7.herokuapp.com/login");
	}
	
	public void logar () {
		
		escreva(By.id("login_email"), "rafaelsmmoura@gmail.com");
		escreva(By.id("login_password"), "Asd#$20406080");
		clicarbotaoby(By.xpath("//*[.='Login']"));
	}
	
	
}
