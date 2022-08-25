package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateWorkerBankDetailsPage {
WebDriver driver;
@FindBy(id="worker-ac_name")
WebElement accountName;
@FindBy(id="worker-ac_no")
WebElement accountNo;
@FindBy(id="worker-sort_code")
WebElement sortCode;
@FindBy(xpath="//button[text()='Save']")
WebElement saveButton;
@FindBy(tagName="h1")
WebElement pageHeading;

public CreateWorkerBankDetailsPage (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void setAccountName(String AccountName) {
	accountName.clear();
	accountName.sendKeys(AccountName);
}
public void setAccountNo(String AccountNo) {
	accountNo.clear();
	accountNo.sendKeys(AccountNo);
}
public void setSortCode(String SortCode) {
	sortCode.clear();
	sortCode.sendKeys(SortCode);
}
public void clickSaveButton() {
	saveButton.click();
}
public String getPageHeading() {
	return pageHeading.getText();
}
}
