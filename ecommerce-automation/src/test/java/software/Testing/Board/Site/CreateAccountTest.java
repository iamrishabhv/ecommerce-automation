package software.Testing.Board.Site;

import org.testng.annotations.Test;

import SoftwareTestingBoardSite.Pages.CreateAccountPage;

public class CreateAccountTest extends BaseTest{
	
	@Test	//End to End Successful Registration on the Website.
	public void TC01() {
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.CreateAccPage("John", "Cina", "John.Cina@dummy.com", "Ert@#$123");
	}
	
	@Test	//Validation for First Name
	public void TC02() {
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.CreateAccPage("j0hn", "Cina", "John.Cina@dummy.com", "Ert@#$123");
	}
	
	@Test	//Validation for Last Name
	public void TC03() {
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.CreateAccPage("John", "c!n@", "John.Cina@dummy.com", "Ert@#$123");
	}
	
	@Test	//Validation for Email Address
	public void TC04() {
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.CreateAccPage("John", "Cina", "John.Cina", "Ert@#$123");
	}
	
	@Test	//Validation for Password
	public void TC05() {
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.CreateAccPage("John", "Cina", "John.Cina@dummy.com", "Ert123");
	}

}
