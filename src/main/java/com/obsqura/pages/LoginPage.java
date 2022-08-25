package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
WebDriver driver;

@FindBy(xpath="//input[@id='loginform-username']")
private WebElement username;
@FindBy(xpath="//input[@id='loginform-password']")
private WebElement password;
@FindBy(name="login-button")
private WebElement loginButton;
@FindBy(xpath="//a[text()='reset it']")
private WebElement forgottenPassword;
@FindBy(tagName="h1")
WebElement pageHeading;


public LoginPage(WebDriver driver) {
	this.driver=driver;
	PageFactory.initElements(driver, this);
}
public void setUserName(String userName) {
	username.clear();
	username.sendKeys(userName);
}
public void setPassword(String passWord) {
	password.clear();
	password.sendKeys(passWord);
}
public void clickLogin() {
	loginButton.click();
}
public void clearUsername() {
	username.clear();
}
public void clearPassword() {
	password.clear();
}
public String getPageHeading() {
	return pageHeading.getText();
}
public void clickForgotPassword() {
	forgottenPassword.click();
}
}
