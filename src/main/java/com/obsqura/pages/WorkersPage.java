package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WorkersPage {
	WebDriver driver;
	@FindBy(xpath="//input[@id='workersearch-first_name']")
	WebElement firstNameBox;
	@FindBy(xpath="//input[@id='workersearch-last_name']")
	WebElement lastNameBox;
	@FindBy(xpath="//input[@id='workersearch-postcode']")
	WebElement postCodeBox;
	@FindBy(xpath="//input[@id='workersearch-ni_number']")
	WebElement niNumberBox;
	@FindBy(xpath="//button[text()='Search']")
	WebElement searchButton ;
	@FindBy(tagName="h1")
	WebElement workersheading;
	@FindBy(xpath="//button[text()='Reset']")
	WebElement resetButton;
	@FindBy(xpath="//td[text()='SZ593292A']")
	WebElement niNumber;
	@FindBy(tagName="td")
	WebElement workersName;
	@FindBy(xpath="//a[text()='Create Worker']")
	WebElement createWorker;
	@FindBy(xpath="//a[text()='Workers']")
	WebElement workersButton;
	@FindBy(xpath="//div[text()='No results found.']")
	WebElement errorMessage;
	
	public WorkersPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setFirstName(String firstname) {
		firstNameBox.clear();
		firstNameBox.sendKeys(firstname);
	}
	public void setLastName(String lastname) {
		lastNameBox.clear();
		lastNameBox.sendKeys(lastname);
	}
	public void setPostCode(String postcode) {
		postCodeBox.clear();
		postCodeBox.sendKeys(postcode);
	}
	public void setNiNumber(String ninumber) {
		niNumberBox.clear();
		niNumberBox.sendKeys(ninumber);
	}
	public void clickSearchButton() {
		searchButton.click();
	}
	public void clickResetButton() {
		resetButton.click();
	}
	public String getWorkersHeading() {
		return workersheading.getText();
	}
	public String getWorkersFirstName() {
		return firstNameBox.getText();
	}
	public String getWorkersName() {
		return workersName.getText();
	}
	public void clickCreateWorker() {
		createWorker.click();
	}
	public void clickWorkersButton() {
		workersButton.click();
	}
	public String getErrorMessage() {
		return errorMessage.getText();
	}
}
