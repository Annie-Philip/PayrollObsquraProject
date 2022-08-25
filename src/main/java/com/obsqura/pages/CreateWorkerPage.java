package com.obsqura.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.obsqura.constants.Constants;

public class CreateWorkerPage {
	WebDriver driver;
	@FindBy(xpath="//*[@id='worker-first_name']")
	WebElement firstName;
	@FindBy(xpath="//*[@id='worker-last_name']")
	WebElement lastName;
	@FindBy(xpath="//*[@id='worker-phone']")
	WebElement phone;
	@FindBy(xpath="//*[@id='worker-email']")
	WebElement email;
	@FindBy(xpath="//*[@id='worker-dob']")
	WebElement dob;
	@FindBy(xpath="//*[@id='worker-address1']")
	WebElement addressLine;
	@FindBy(xpath="//*[@id='worker-postcode']")
	WebElement postcode;
	@FindBy(xpath="//*[@id='worker-ni_number']")
	WebElement niNumber;
	@FindBy(xpath="//*[@id='worker-gender']")
	WebElement gender;
	@FindBy(xpath="//*[@id='worker-branch_id']")
	WebElement branch;
	@FindBy(xpath="//*[@id='worker-division_id']")
	WebElement division;
	@FindBy(xpath="//*[@id='worker-employment_type']")
	WebElement employmentType;
	@FindBy(xpath="//*[@id='worker-payslip_method']")
	WebElement payslipMethod;
	@FindBy(xpath="//button[text()='Next']")
	WebElement nextButton;
	@FindBy(tagName="h1")
	WebElement pageHeading;
	
	
	public CreateWorkerPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void setFirstName(String FirstName) {
		firstName.clear();
		firstName.sendKeys(FirstName);
	}
	public void setLastName(String LastName) {
		lastName.clear();
		lastName.sendKeys(LastName);
	}
	public void setPhone(String Phone) {
		phone.clear();
		phone.sendKeys(Phone);
	}
	public void setAddressLine(String AddressLine) {
		addressLine.clear();
		addressLine.sendKeys(AddressLine);
	}
	public void setPostcode(String PostCode) {
		postcode.clear();
		postcode.sendKeys(PostCode);
	}
	public void setEmail(String Email) {
		email.clear();
		email.sendKeys(Email);
	}
	public void setDob(String Dob) {
		dob.clear();
		dob.sendKeys(Dob);
	}
	public void setNiNumber(String NiNumber) {
		niNumber.clear();
		niNumber.sendKeys(NiNumber);
	}
	public void genderDropdown() {
		Select dropdown=new Select(gender);
		dropdown.selectByVisibleText(Constants.GENDER);
	}
	public void branchDropdown() {
		Select dropdown=new Select(branch);
		dropdown.selectByVisibleText(Constants.BRANCH);
	}
	public void divisionDropdown() {
		Select dropdown=new Select(division);
		dropdown.selectByVisibleText(Constants.DIVISION);
	}
	public void employmentTypeDropdown() {
		Select dropdown=new Select(employmentType);
		dropdown.selectByVisibleText(Constants.EMPLOYMENTTYPE);
	}
	public void payslipMethodDropdown() {
		Select dropdown=new Select(payslipMethod);
		dropdown.selectByVisibleText(Constants.PAYSLIPMETHOD);
	}
	public void clickNextButton() {
		nextButton.click();
	}
	public String getPageHeading() {
		return pageHeading.getText();
	}
}
