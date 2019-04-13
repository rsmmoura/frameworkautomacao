package core;

import static core.DriverFactory.getDriver;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.xml.sax.Locator;

public class BasePage {
	public void  escreva (By locator,String texto) {
		
		getDriver().findElement(locator).clear();
		getDriver().findElement(locator).sendKeys(texto);
		
	}
			
	public void escreva (String id, String texto) {
		escreva (By.id(id), texto);
	}
	public String obtervalorinput (String id) {
		return getDriver().findElement(By.id(id)).getAttribute("value");
		
	}
	public String obtervalortexto (String id) {
		return getDriver().findElement(By.id(id)).getText();
	}
	
	public void cliquebotao (By by) {
		getDriver().findElement(By.xpath("//input[@value='"+by+"']")).click();
	}

/**** areasdecliques ****/
	
	public void cliqueradio (String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public void cliquecheck (String id) {
		getDriver().findElement(By.id(id)).click();
	}
	
	public boolean verificarclique (String id) {
		return getDriver().findElement(By.id(id)).isSelected();
	}
	
/**** areadeselect ****/
	public void selecionarcombo (String id, String valor) {
		WebElement elemento = getDriver().findElement(By.id((id)));
	Select combo = new Select (elemento);
	combo.selectByVisibleText(valor);
				
	}
	
/**** areadedeselecionaropcao****/
	public void deselecionaropcao (String id, String valor) {
		WebElement elemento = getDriver().findElement(By.id((id)));
		Select combo = new Select (elemento);
		combo.deselectByVisibleText(valor); 
				
	}
	
	public String obtervalorcombo (String id) {
		WebElement elemento = getDriver().findElement(By.id((id)));
		Select combo = new Select (elemento);
		return combo.getFirstSelectedOption().getText();
	}
	public List <String> obtervaloresdocombo (String id){
		WebElement elemento = getDriver().findElement(By.id((id)));
		Select combo = new Select (elemento);
		List <WebElement> lista = combo.getAllSelectedOptions();
		List <String> valores = new ArrayList <String> ();
			for (WebElement opcao:lista) {
				valores.add(opcao.getText());
		}
		return valores;
		
	}
	public int obterquantidadedeopcoescombo (String id) {
		WebElement elemento = getDriver().findElement(By.id((id)));
		Select combo = new Select (elemento);
		List  <WebElement> lista = combo.getOptions();
		return lista.size();			
	}
	public boolean verificaropcaocombo (String id, String valor) {
		WebElement elemento = getDriver().findElement(By.id((id)));
		Select combo = new Select (elemento);
		List <WebElement> lista = combo.getOptions();
			for (WebElement opcao:lista) {
				if (opcao.getText().equals(valor)) {
					return true;
				}
		}
					return false;
	
	}
	
	
/**** area de alertas****/
	
	public String alertaobtertexto () {
		Alert alert = getDriver().switchTo().alert();
		return alert.getText();
	}
	
	public String alertaobtertextoeaceitar () {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.accept();
		return valor;			
	}
	public String alertaobtertextoenegar () {
		Alert alert = getDriver().switchTo().alert();
		String valor = alert.getText();
		alert.dismiss();
		return valor;
	}
	
	public void alertaescrever (String texto) {
		Alert alert = getDriver().switchTo().alert();
		alert.sendKeys(texto);
		alert.accept();
	}
	
/**** area de frames e janelas****/
	public void entrarframe (String id) {
		getDriver().switchTo().frame(id);
					
	}
	public void sairframe () {
		getDriver().switchTo().defaultContent();
	}
	public void trocarJanela (String id) {
		getDriver().switchTo().window(id);
	}
/**** area de tabela****/
	public void interagirtabela (int indicebusca, int indiceinteracao, String valor, String valorbusca, String acao) {
		String xpath = "//tbody/tr[td["+indicebusca+"]='"+valorbusca+"']/td["+indiceinteracao+"]/input";
		WebElement tabelaelemento= getDriver().findElement(By.xpath((xpath)));
		switch(acao) {
			case "click": tabelaelemento.click();
			break;
			case "escrever": tabelaelemento.sendKeys(valor);
			break;
		
		default:System.out.println("acaoinvalida");
		}
		
		
	}
	
	public void abrirurl (String url) {
		getDriver().get(url);
	}
	public void clicarbotaoby (By locator) {
		getDriver().findElement(locator);
		
	}
}


