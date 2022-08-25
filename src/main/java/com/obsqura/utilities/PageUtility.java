package com.obsqura.utilities;

import java.time.Duration;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageUtility {
	
	public WebElement waitForElementTobeVisible(WebDriver driver,WebElement elementToBeLoaded, Duration Time) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));//new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOf(elementToBeLoaded));
        return element;
    }
	
	public WebElement waitForElementTobeClickable( WebDriver driver,WebElement elementToBeClickable, Duration Time) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(40));//new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(elementToBeClickable));
        return element;
    }
	public void elementClick(WebDriver driver,WebElement element) {
		Actions actions = new Actions(driver);
	    actions.moveToElement(element).click().build().perform();
}
	public void dropdown(WebDriver driver,WebElement element) {
		Select dropdown=new Select(element);
	}
}