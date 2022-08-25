package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.constants.Constants;

public class AddDeductionPage {
	WebDriver driver;
	@FindBy(id="select2-deduction-worker_id-container")
	WebElement worker;
	@FindBy(id="deduction-type")
	WebElement type;
	@FindBy(id="deduction-amount")
	WebElement amount;
	@FindBy(xpath="//button[text()='Save']")
	WebElement saveButton;
	@FindBy(tagName="h1")
	WebElement pageHeading;
	
	public  AddDeductionPage  (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void workerDropdown() {
		Select dropdown=new Select(worker);
		dropdown.selectByVisibleText(Constants.WORKERSNAME);
	}
	public void typeDropdown() {
		Select dropdown=new Select(type);
		dropdown.selectByVisibleText(Constants.TYPE);
	}
	public void setAmount(String Amount) {
		amount.clear();
		amount.sendKeys(Amount);
	}
	public void clickSaveButton() {
		saveButton.click();
	}
	public String getPageHeading() {
		return pageHeading.getText();
	}
}
