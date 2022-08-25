package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
WebDriver driver;
@FindBy(tagName="h1")
WebElement heading;
@FindBy(xpath="//a[text()='Clients']")   
WebElement clients;
@FindBy(xpath="//a[text()='Workers']")
WebElement workersButton;
@FindBy(xpath="//a[text()='Home']")
WebElement homeButton;
@FindBy(xpath="//a[text()='Deduction']")
WebElement deductionButton;
@FindBy(xpath="//a[text()='TimeSheet']")
WebElement timesheetButton;
@FindBy(xpath="//a[text()='Payslip']")
WebElement payslipButton;
@FindBy(xpath="//a[text()='Invoice']") 
WebElement invoiceButton;
@FindBy(xpath="//a[text()='Report']")
WebElement reportButton;

public HomePage (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public String getHeading() {
	return heading.getText();
}
public void clickClients() {
	clients.click();
}
public void clickHome() {
	homeButton.click();
}
public void clickWorkers() {
	workersButton.click();
}
public void clickDeduction() {
	deductionButton.click();
}
public void clickTimesheet() {
	timesheetButton.click();
}
public void clickPayslip() {
	payslipButton.click();
}
public void clickInvoice() {
	invoiceButton.click();
}
public void clickReport() {
	reportButton.click();
}
}
