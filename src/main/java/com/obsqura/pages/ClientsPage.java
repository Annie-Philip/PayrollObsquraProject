package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ClientsPage {
	WebDriver driver;
	@FindBy(xpath="//input[@id='clientsearch-client_name']")
	WebElement clientNameBox;
	@FindBy(xpath="//input[@id='clientsearch-id']")
	WebElement clientIdBox;
	@FindBy(xpath="//button[@type='submit']")
	WebElement searchButton;
	@FindBy(tagName="h1")
	WebElement clients;
	@FindBy(linkText="Home")
	WebElement homeButton;
	@FindBy(xpath="//a[text()='Create Client']")
	WebElement createClient;
	@FindBy(xpath="//button[text()='Reset']")
	WebElement resetButton;
	@FindBy(xpath="//td[text()='Selenium']")
	WebElement clientName;
	@FindBy(xpath="//a[text()='Create Client']")
	WebElement createClientButton;
	@FindBy(xpath="//div[text()='No results found.']")
	WebElement errorMessage;
	@FindBy(xpath="//a[text()='Clients']")
	WebElement clientsButton;
	
	public ClientsPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public String getClientNameBox() {
		return clientNameBox.getText();
	}
	public void clickSearch() {
		searchButton.click();
	}
	public void setClientName(String clientName) {
		clientNameBox.clear();
		clientNameBox.sendKeys(clientName);
	}
	public void setClientId(String clientId) {
		clientIdBox.clear();
		clientIdBox.sendKeys(clientId);
		}
	public String getClientName() {
		return clientName.getText();
	}
	public String getClientsHeading() {
		return clients.getText();
	}
	public void clickHome() {
		homeButton.click();
	}
	public void clickResetButton() {
		resetButton.click();
	}
	public void clickCreateClient() {
		createClientButton.click();
	}
	public String getErrorMessage() {
		return errorMessage.getText();
	}
	public void clickClientsButton() {
		clientsButton.click();
	}
}
