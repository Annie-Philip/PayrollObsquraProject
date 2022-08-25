package com.obsqura.scripts;

import java.io.IOException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.obsqura.pages.AddDeductionPage;
import com.obsqura.pages.ClientsPage;
import com.obsqura.pages.CreateClientPage;
import com.obsqura.pages.CreateWorkerBankDetailsPage;
import com.obsqura.pages.CreateWorkerPage;
import com.obsqura.pages.DeductionPage;
import com.obsqura.pages.ForgotPasswordPage;
import com.obsqura.pages.HomePage;
import com.obsqura.pages.InvoicePage;
import com.obsqura.pages.LoginPage;
import com.obsqura.pages.PayslipPage;
import com.obsqura.pages.ReportPage;
import com.obsqura.pages.TimesheetPage;
import com.obsqura.pages.WorkersPage;
import com.obsqura.utilities.ExcelUtility;
import com.obsqura.constants.Constants;

public class TestClass extends TestBase {
LoginPage log;
ForgotPasswordPage frgp;
HomePage hom;
ClientsPage clp;
WorkersPage wrkp;
DeductionPage ddp;
TimesheetPage tsp;
PayslipPage psp; 
InvoicePage inp;
ReportPage rpp;
CreateClientPage ccp;
CreateWorkerPage cwp;
CreateWorkerBankDetailsPage cwbdp;
AddDeductionPage adp;

@Test(priority=5)
public void verifyLogin() throws IOException {
	log=new LoginPage(driver);
	driver.navigate().refresh();
	String username =  ExcelUtility.getCellData(0, 0);
	try {
		username = ExcelUtility.getCellData(0, 0);
	} catch (IOException e) {
		e.printStackTrace();
	}
	String password=ExcelUtility.getCellData(0, 1);
	log.setUserName(username);
	log.setPassword(password);
	log.clickLogin();
	hom=new HomePage(driver);
	String expectedHeading=Constants.HOMEPAGEHEADING;
	String actualHeading=hom.getHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
}
@Test(priority=2)
public void blankPassword() throws IOException{
	frgp =new ForgotPasswordPage(driver);
	frgp.clickCancelButton();
	log=new LoginPage(driver);
	String username = ExcelUtility.getCellData(3, 0);
	try {
		username = ExcelUtility.getCellData(3, 0);
	} catch (IOException e) {
		e.printStackTrace();
	}
	log.setUserName(username);
	log.clearPassword();
	log.clickLogin();
	String expectedHeading=Constants.LOGINPAGEHEADING;
	String actualHeading=log.getPageHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
}
@Test(priority=3)
public void blankUsername() throws IOException  {
	log=new LoginPage(driver);
	driver.navigate().refresh();
	  synchronized (log) {
		    try {
		    	log.wait(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}}
	String password = ExcelUtility.getCellData(2, 1);
	try {
		password = ExcelUtility.getCellData(2, 1);
	} catch (IOException e) {
		e.printStackTrace();
	}
	log.clearUsername();
	log.clearPassword();
	log.setPassword(password);
	log.clickLogin();
	String expectedHeading=Constants.LOGINPAGEHEADING;
	String actualHeading=log.getPageHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
}
@Test(priority=4)
public void invalidUsernameValidPassword() throws IOException  {
	log=new LoginPage(driver);
	driver.navigate().refresh();
	String username = ExcelUtility.getCellData(1, 0);
	try {
		username = ExcelUtility.getCellData(1, 0);
	} catch (IOException e) {
		e.printStackTrace();
	}
	String password=ExcelUtility.getCellData(1, 1);
	log.setUserName(username);
	log.setPassword(password);
	log.clickLogin();
	String expectedHeading=Constants.LOGINPAGEHEADING;
	String actualHeading=log.getPageHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
}
@Test(priority=6)
public void verifyClientsPage() throws IOException  {
    hom=new HomePage(driver);
    synchronized (hom) {
    try {
    	hom.wait(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}}
    hom.clickClients();
	clp=new ClientsPage(driver);
	String expectedClientsHeading=Constants.CLIENTSPAGEHEADING;
	String actualClientsHeading=clp.getClientsHeading();
	Assert.assertEquals(actualClientsHeading, expectedClientsHeading);
    } 
@Test(priority=7)
public void verifyWorkersPage() throws IOException {
	hom=new HomePage(driver);
	synchronized (hom) {
		try {
	    	hom.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	hom.clickHome();
	hom.clickWorkers();
	wrkp=new WorkersPage(driver);
	String expectedWorkersHeading=Constants.WORKERSPAGEHEADING;
	String actualWorkersHeading=wrkp.getWorkersHeading();
	Assert.assertEquals(actualWorkersHeading, expectedWorkersHeading);
}
@Test(priority=8)
public void verifyDeductionPage() {
	hom=new HomePage(driver);
	synchronized (hom) {
		try {
	    	hom.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	hom.clickHome();
	hom.clickDeduction();
	ddp=new DeductionPage(driver);
	String expectedDeductionDetails=Constants.DEDUCTIONPAGEHEADING;
	String actualDeductionDetails=ddp.getDeductionsHeading();
	Assert.assertEquals(actualDeductionDetails, expectedDeductionDetails);
}
@Test(priority=9)
public void verifyTimesheetPage() {
	hom=new HomePage(driver);
	synchronized (hom) {
		try {
	    	hom.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	hom.clickHome();
	hom.clickTimesheet();
	tsp=new TimesheetPage(driver);
	tsp.clickGeneratePayslip();
	driver.switchTo().alert().accept();
	String expectedHeading=Constants.TIMESHEETPAGEHEADING;
	String actualHeading=tsp.getHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
}
@Test(priority=10)
public void verifyPayslipPage() {
	hom=new HomePage(driver);
	synchronized (hom) {
		try {
	    	hom.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	hom.clickHome();
	hom.clickPayslip();
	psp=new PayslipPage(driver);
	String expectedHeading=Constants.PAYSLIPPAGEHEADING;
	String actualHeading=psp.getHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
}
@Test(priority=11)
public void verifyInvoicePage() {
	hom=new HomePage(driver);
	synchronized (hom) {
		try {
	    	hom.wait(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	hom.clickHome();
	hom.clickInvoice();
	inp=new InvoicePage(driver);
	String expectedHeading=Constants.INVOICEPAGEHEADING;
	String actualHeading=inp.getHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
}
@Test(priority=12)
public void verifyReportPage() {
	hom=new HomePage(driver);
	synchronized (hom) {
		try {
	    	hom.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	hom.clickHome();
	hom.clickReport();
	rpp=new ReportPage(driver);
	String expectedHeading=Constants.REPORTPAGEHEADING;
	String actualHeading=rpp.getHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
} 

  @DataProvider(name = "emailDetail")
public static Object[] loginByDataProvider(){
     	return new Object[]{"carol@gmail.com"};
	}
@Test(dataProvider ="emailDetail")
public void verifyPasswordResetCancel(String eMail) {
    log=new LoginPage(driver);
	driver.navigate().refresh();
	log.clickForgotPassword();
	frgp=new ForgotPasswordPage(driver);
    frgp.setEmail(eMail);
    frgp.clickCancelButton();
    String expectedHeading=Constants.LOGINPAGEHEADING;
	String actualHeading=log.getPageHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
 }
@Test(priority=1)
public void verifyPasswordResetInvaidEmail() throws IOException {
	log=new LoginPage(driver);
	driver.navigate().refresh();
	log.clickForgotPassword();
	frgp =new ForgotPasswordPage(driver);
	String eMail =ExcelUtility.getCellData(4, 0);
	try {
		eMail = ExcelUtility.getCellData(4, 0);
	} catch (IOException e) {
		e.printStackTrace();
	}
	frgp.setEmail(eMail);
	frgp.clickSendButton();
	String expectedHeading=Constants.PASSWORDRESETPAGEHEADING;
	String actualHeading=frgp.getPageHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
}
@Test(priority=13)
public void verifyClientsPageSearch() throws IOException  {
    hom=new HomePage(driver);
    synchronized (hom) {
    try {
    	hom.wait(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}}
    hom.clickClients();
	clp=new ClientsPage(driver);
	String clientName = ExcelUtility.getCellData(5, 0);
    clp.setClientName(clientName);
    String clientId=ExcelUtility.getNumericData(5, 1);
    clp.setClientId(clientId);
    clp.clickSearch();
    String expectedClientName=Constants.CLIENTSPAGESEARCHNAME;
    String actualClientName=clp.getClientName();
	Assert.assertEquals(actualClientName, expectedClientName);
    } 
@Test(priority=14)
public void verifyClientsPageSearchName() throws IOException  {
    hom=new HomePage(driver);
    synchronized (hom) {
    try {
    	hom.wait(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}}
    hom.clickClients();
	clp=new ClientsPage(driver);
	String clientName = ExcelUtility.getCellData(5, 0);
    clp.setClientName(clientName);
    clp.clickSearch();
    String expectedClientName=Constants.CLIENTSPAGESEARCHNAME;
    String actualClientName=clp.getClientName();
	Assert.assertEquals(actualClientName, expectedClientName);
    }
@Test(priority=15)
public void verifyClientsPageSearchId() throws IOException  {
    hom=new HomePage(driver);
    synchronized (hom) {
    try {
    	hom.wait(5000);
	} catch (InterruptedException e) {
		e.printStackTrace();
	}}
    hom.clickClients();
	clp=new ClientsPage(driver);
    String clientId=ExcelUtility.getNumericData(5, 1);
    clp.setClientId(clientId);
    clp.clickSearch();
    String expectedClientName=Constants.CLIENTSPAGESEARCHNAME;
    String actualClientName=clp.getClientName();
	Assert.assertEquals(actualClientName, expectedClientName);
    }
@Test(priority=16)
public void verifyClientsPageResetButton() throws IOException {
	 hom=new HomePage(driver);
	    synchronized (hom) {
	    try {
	    	hom.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	    hom.clickClients();
		clp=new ClientsPage(driver);
		String clientName = ExcelUtility.getCellData(5, 0);
	    clp.setClientName(clientName);	
	    clp.clickResetButton();
	    String expectedClientName="";
	    String actualClientName=clp.getClientNameBox();
	    Assert.assertEquals(actualClientName, expectedClientName);
}
@Test(priority=17)
public void verifyWorkersPageSearch() throws IOException {
	hom=new HomePage(driver);
	synchronized (hom) {
		try {
	    	hom.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	hom.clickHome();
	hom.clickWorkers();
	wrkp=new WorkersPage(driver);
	String firstname=ExcelUtility.getCellData(6, 0);
    wrkp.setFirstName(firstname);
    String lastname=ExcelUtility.getCellData(6, 1);
	wrkp.setLastName(lastname);
	String postcode=ExcelUtility.getCellData(6, 2);
	wrkp.setPostCode(postcode);
	String ninumber=ExcelUtility.getCellData(6, 3);
	wrkp.setNiNumber(ninumber);
	wrkp.clickSearchButton();
	String expectedWorkersName=Constants.WORKERSNAME;
	String actualWorkersName=wrkp.getWorkersName();
	Assert.assertEquals(actualWorkersName, expectedWorkersName);
}
@Test(priority=18)
public void verifyWorkersPageResetButton() throws IOException {
	hom=new HomePage(driver);
	synchronized (hom) {
		try {
	    	hom.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	hom.clickHome();
	hom.clickWorkers();
	wrkp=new WorkersPage(driver);
	String firstname=ExcelUtility.getCellData(6, 0);
    wrkp.setFirstName(firstname);
    wrkp.clickResetButton();
	String expectedFirstName="";
	String actualFirstName=wrkp.getWorkersFirstName();
	Assert.assertEquals(actualFirstName, expectedFirstName);
}
@Test(priority=19)//enabled=false
public void verifyCreateClientPage() throws IOException, InterruptedException {
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickClients();
	clp=new ClientsPage(driver);
	synchronized (clp) {
		try {
	    	clp.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	clp.clickCreateClient();
	ccp=new CreateClientPage(driver);
	ccp.branchDropdown();
	ccp.divisionDropdown();
	String ClientName=ExcelUtility.getCellData(7, 0);
	ccp.setClientName(ClientName);
	String ClientAddress=ExcelUtility.getCellData(7, 1);
	ccp.setClientAddress(ClientAddress);
	String Postcode=ExcelUtility.getCellData(7, 2);
	ccp.setPostcode(Postcode);
	String YourRef=ExcelUtility.getCellData(7, 3);
	ccp.setYourRef(YourRef);
	String InvoiceContact=ExcelUtility.getCellData(7, 4);
	ccp.setInvoiceContact(InvoiceContact);
    String Phone=ExcelUtility.getNumericData(7, 5);
    ccp.setPhone(Phone);
    String Email=ExcelUtility.getCellData(7, 6);
    ccp.setEmail(Email);
    String CompanyReg=ExcelUtility.getCellData(7, 7);
    ccp.setCompanyReg(CompanyReg);
    ccp.invoiceOrderDropdown();
    ccp.invoiceDeliveryMethodDropdown();
    ccp.masterDocumentDropdown();
    String SettlementDays=ExcelUtility.getNumericData(7, 8);
    ccp.setSettlementDays(SettlementDays);
    ccp.vatRateDropdown();
    ccp.clickSaveButton();   
    String expectedNewClient=Constants.NEWCLIENT;
    String actualNewClient=ccp.getNewClient();
	Assert.assertEquals(actualNewClient, expectedNewClient);
}
@Test(priority=20)
public void verifyCreateWorkerPage() throws IOException  {
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickWorkers();
	wrkp=new WorkersPage(driver);
	wrkp.clickCreateWorker();
	cwp=new CreateWorkerPage(driver);
	String FirstName = ExcelUtility.getCellData(8, 0);
	try {
		FirstName = ExcelUtility.getCellData(8, 0);
	} catch (IOException e) {
		e.printStackTrace();
	}
	cwp.setFirstName(FirstName);
	String LastName=ExcelUtility.getCellData(8, 1);
	cwp.setLastName(LastName);
	String Phone=ExcelUtility.getNumericData(8, 2);
	cwp.setPhone(Phone);
	String Email=ExcelUtility.getCellData(8, 3);
	cwp.setEmail(Email);
	cwp.genderDropdown();
	String Dob=ExcelUtility.getNumericData(8, 4);
	cwp.setDob(Dob);
	String AddressLine=ExcelUtility.getCellData(8, 5);
	cwp.setAddressLine(AddressLine);
	String PostCode=ExcelUtility.getCellData(8, 6);
	cwp.setPostcode(PostCode);
	cwp.branchDropdown();
	cwp.divisionDropdown();
	cwp.employmentTypeDropdown();
	cwp.payslipMethodDropdown();
	String NiNumber=ExcelUtility.getCellData(8, 7);
	cwp.setNiNumber(NiNumber);
	cwp.clickNextButton();
	String expectedHeading=Constants.CREATEWORKERPAGEHEADING;
	String actualHeading=cwp.getPageHeading();
	Assert.assertEquals(actualHeading, expectedHeading);
}
@Test(priority=21)
public void verifyWorkerBankDetailsSavePage() throws IOException  {
	cwbdp=new CreateWorkerBankDetailsPage(driver);
	String AccountName = ExcelUtility.getCellData(9, 0);
	try {
		AccountName = ExcelUtility.getCellData(9, 0);
	} catch (IOException e) {
		e.printStackTrace();
	}
	cwbdp.setAccountName(AccountName);
	String AccountNo=ExcelUtility.getNumericData(9, 1);
	cwbdp.setAccountNo(AccountNo);
	String SortCode=ExcelUtility.getCellData(9, 2);
	cwbdp.setSortCode(SortCode);
	cwbdp.clickSaveButton();
	String expectedHeading=Constants.WORKERNAMEHEADING;
	String actualHeading=cwbdp.getPageHeading();
	Assert.assertEquals(actualHeading, expectedHeading); 
}
@Test(priority=22)
public void verifyAddDeductionPage() throws IOException  {
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickDeduction();
	ddp=new DeductionPage(driver);
	ddp.clickAddDeduction();
	adp=new AddDeductionPage(driver);
	synchronized (adp) {
	    try {
	    	adp.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	adp.workerDropdown();
	adp.typeDropdown();
	String Amount=ExcelUtility.getNumericData(10, 0);
	adp.setAmount(Amount);
	adp.clickSaveButton();
	String expectedHeading=Constants.WORKERSNAME;
	String actualHeading=adp.getPageHeading();
	Assert.assertEquals(actualHeading, expectedHeading); 
}
@Test(priority=23)
public void verifyClientSearchInvalidNameBlankId() throws IOException {
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickClients();
	clp=new ClientsPage(driver);
	String clientName = ExcelUtility.getCellData(11, 0);
	try {
		clientName = ExcelUtility.getCellData(11, 0);
	} catch (IOException e) {
		e.printStackTrace();
	}
    clp.setClientName(clientName);
    clp.clickSearch();
    String expectedMessage=Constants.CLIENTPAGEERRORMESSAGE;
    String actualMessage=clp.getErrorMessage();
    Assert.assertEquals(actualMessage, expectedMessage);
}
@Test(priority=24)
public void verifyClientSearchBlankNameInvalidId() throws IOException   {
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickClients();
	clp=new ClientsPage(driver);
	String clientName = ExcelUtility.getNumericData(11, 1);
	try {
		clientName = ExcelUtility.getNumericData(11, 1);
	} catch (IOException e) {
		e.printStackTrace();
	}
    clp.setClientName(clientName);
    clp.clickSearch();
    String expectedMessage=Constants.CLIENTPAGEERRORMESSAGE;
    String actualMessage=clp.getErrorMessage();
    Assert.assertEquals(actualMessage, expectedMessage);
}
@Test(priority=25)
public void verifyClientsButton() {
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickClients();
	clp=new ClientsPage(driver);
	synchronized (clp) {
	    try {
	    	clp.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	clp.clickCreateClient();
	clp.clickClientsButton();
	String expectedClientsHeading=Constants.CLIENTSPAGEHEADING;
	String actualClientsHeading=clp.getClientsHeading();
	Assert.assertEquals(actualClientsHeading, expectedClientsHeading);
}
@Test(priority=26)
public void verifyWorkersButton() {
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickWorkers();
	wrkp=new WorkersPage(driver);
	synchronized (wrkp) {
	    try {
	    	wrkp.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	wrkp.clickCreateWorker();
	wrkp.clickWorkersButton();
	String expectedWorkersHeading=Constants.WORKERSPAGEHEADING;
	String actualWorkersHeading=wrkp.getWorkersHeading();
	Assert.assertEquals(actualWorkersHeading, expectedWorkersHeading);
}
@Test(priority=27)
public void verifyDeductionsbutton() {
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickDeduction();
	ddp=new DeductionPage(driver);
	synchronized (ddp) {
	    try {
	    	ddp.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	ddp.clickAddDeduction();
	ddp.clickDeductionsButton();
	String expectedDeductionDetails=Constants.DEDUCTIONPAGEHEADING;
	String actualDeductionDetails=ddp.getDeductionsHeading();
	Assert.assertEquals(actualDeductionDetails, expectedDeductionDetails);
}
@Test(priority=28)
public void verifyWorkersSearchInvalidNiNumber() throws IOException{
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickWorkers();
	wrkp=new WorkersPage(driver);
	String ninumber = ExcelUtility.getCellData(12, 2);
	try {
		ninumber = ExcelUtility.getCellData(12, 2);
	} catch (IOException e) {
		e.printStackTrace();
	}
	wrkp.setNiNumber(ninumber);
	wrkp.clickSearchButton();
	String expectedWorkersHeading=Constants.WORKERSPAGEERRORMESSAGE;
	String actualWorkersHeading=wrkp.getErrorMessage();
	Assert.assertEquals(actualWorkersHeading, expectedWorkersHeading);
}
@Test(priority=29)
public void verifyWorkersSearchInvalidName() throws IOException {
	hom=new HomePage(driver);
	hom.clickHome();
	hom.clickWorkers();
	wrkp=new WorkersPage(driver);
	synchronized (wrkp) {
	    try {
	    	wrkp.wait(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}}
	String firstname=ExcelUtility.getCellData(12, 0);
    wrkp.setFirstName(firstname);
    String lastname=ExcelUtility.getCellData(12, 1);
	wrkp.setLastName(lastname);
	wrkp.clickSearchButton();
	String expectedWorkersHeading=Constants.WORKERSPAGEERRORMESSAGE;
	String actualWorkersHeading=wrkp.getErrorMessage();
	Assert.assertEquals(actualWorkersHeading, expectedWorkersHeading);
	driver.quit();
}
}