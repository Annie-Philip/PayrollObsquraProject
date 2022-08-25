package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
WebDriver driver;
@FindBy(id="passwordresetrequestform-email")
WebElement email;
@FindBy(xpath="//button[text()='Send']")
WebElement sendButton;
@FindBy(xpath="//a[text()='Cancel']")
WebElement cancelButton;
@FindBy(tagName="h1")
WebElement pageHeading;

public ForgotPasswordPage (WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void setEmail(String eMail) {
	email.clear();
	email.sendKeys(eMail);
}
public void clickSendButton() {
	sendButton.click();
}
public void clickCancelButton() {
	cancelButton.click();
}
public String getPageHeading() {
	return pageHeading.getText();
}

}

