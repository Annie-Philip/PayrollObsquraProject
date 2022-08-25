package com.obsqura.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import com.obsqura.constants.Constants;

public class CreateClientPage {
	WebDriver driver;
	@FindBy(id="client-branch_id")
	WebElement branch;
	@FindBy(id="client-division_id")
	WebElement division;
	@FindBy(id="client-client_name")
	WebElement clientName;
	@FindBy(id="client-client_address")
	WebElement address;
	@FindBy(id="client-postcode")
	WebElement postcode;
	@FindBy(id="client-your_ref")
	WebElement yourRef;
	@FindBy(id="client-invoice_contact")
	WebElement invoiceContact;
	@FindBy(id="client-phone")
	WebElement phone;
	@FindBy(id="client-email")
	WebElement email;
	@FindBy(id="client-company_reg")
	WebElement companyReg;
	@FindBy(id="client-invoice_order")
	WebElement invoiceOrder;
	@FindBy(id="client-invoice_delivery_method")
	WebElement invoiceDeliveryMethod;
	@FindBy(id="client-master_document")
	WebElement masterDocument;
	@FindBy(id="client-settilement_days")
	WebElement settlementDays;
	@FindBy(id="client-vat_rate")
	WebElement vatRate;
	@FindBy(xpath="//button[@class='btn btn-success']")
	WebElement saveButton;
	@FindBy(xpath="//h1[text()='Derik Pearson']")
	WebElement newClient;
	
	public CreateClientPage (WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void branchDropdown() {
		Select dropdown=new Select(branch);
		dropdown.selectByVisibleText(Constants.BRANCH);
	}
	public void divisionDropdown() {
		Select dropdown=new Select(division);
		dropdown.selectByVisibleText(Constants.DIVISION);
	}
	public void invoiceOrderDropdown() {
		Select dropdown=new Select(invoiceOrder);
		dropdown.selectByVisibleText(Constants.INVOICEORDER);
	}
	public void invoiceDeliveryMethodDropdown() {
		Select dropdown=new Select(invoiceDeliveryMethod);
		dropdown.selectByVisibleText(Constants.INVOICEDELIVERYMETHOD);
	}
	public void masterDocumentDropdown() {
		Select dropdown=new Select(masterDocument);
		dropdown.selectByVisibleText(Constants.MASTERDOCUMENT);
	}
	public void vatRateDropdown() {
		Select dropdown=new Select(vatRate);
		dropdown.selectByVisibleText(Constants.VATRATE);
	}
	public void setClientName(String ClientName) {
		clientName.clear();
		clientName.sendKeys(ClientName);
	}
	public void setClientAddress(String ClientAddress) {
		address.clear();
		address.sendKeys(ClientAddress);
	}
	public void setPostcode(String Postcode) {
		postcode.clear();
		postcode.sendKeys(Postcode);
	}
	public void setYourRef(String YourRef) {
		yourRef.clear();
		yourRef.sendKeys(YourRef);
	}
	public void setInvoiceContact(String InvoiceContact) {
		invoiceContact.clear();
		invoiceContact.sendKeys(InvoiceContact);
	}
	public void setPhone(String Phone) {
		phone.clear();
		phone.sendKeys(Phone);
	}
	public void setEmail(String Email) {
		email.clear();
		email.sendKeys(Email);
	}
	public void setCompanyReg(String CompanyReg) {
		companyReg.clear();
		companyReg.sendKeys(CompanyReg);
	}
	public void setSettlementDays(String SettlementDays) {
		settlementDays.clear();
		settlementDays.sendKeys(SettlementDays);
	}
	public void clickSaveButton() throws InterruptedException {
		((JavascriptExecutor)driver).executeScript("arguments[0].click();", saveButton);
		//Thread.sleep(10000);
		//saveButton.click();
	}
	public String getNewClient() {
		return newClient.getText();
	}


}
