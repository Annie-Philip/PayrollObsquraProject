package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeductionPage {
WebDriver driver;
@FindBy(tagName="h1")
WebElement deductionsheading;
@FindBy(xpath="//a[text()='Add Deduction']")
WebElement addDeduction;
@FindBy(xpath="//a[text()='Deductions']")
WebElement deductionsButton;

public DeductionPage (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public String getDeductionsHeading() {
	return deductionsheading.getText();
}
public void clickAddDeduction() {
	addDeduction.click();
}
public void clickDeductionsButton() {
	deductionsButton.click();
}
}
