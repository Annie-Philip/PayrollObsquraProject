package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TimesheetPage {
WebDriver driver;
@FindBy(xpath="//button[text()='Generate Playslip']")
WebElement generatePayslip;
@FindBy(tagName="h1")
WebElement heading;
public TimesheetPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void clickGeneratePayslip() {
	generatePayslip.click();
}
public String getHeading() {
	return heading.getText();
}
}
