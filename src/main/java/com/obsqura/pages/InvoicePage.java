package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvoicePage {
WebDriver driver;

@FindBy(tagName="h1")
WebElement heading;

public InvoicePage (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public String getHeading() {
	return heading.getText();
}

}
