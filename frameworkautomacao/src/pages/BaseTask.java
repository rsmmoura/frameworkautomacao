package pages;

import org.openqa.selenium.By;

import core.BasePage;

public class BaseTask extends BasePage {
	
	public void clicarbotaonewtask() {
		clicarbotaoby(By.id("insert-button"));
		}
	
	public void preenchertask () {
		escreva(By.id("title"), "Tarefa Teste Rafael");
		escreva(By.id("dueDate"), "15/04/2019");
		escreva(By.xpath("//*[@id='add-task']/div[4]/div/div/input"), "TAG RAFAEL");
		clicarbotaoby(By.id("form-submit-button"));		
	}
	
	
	
}
