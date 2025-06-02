package software.Testing.Board.Site;

import org.testng.annotations.Test;

import SoftwareTestingBoardSite.Pages.SignInPage;

public class SignInPageTest extends BaseTest{
	
	@Test	//TC01 - Valid Sign In
	public void signInTest_TC1() throws InterruptedException {
		SignInPage sip = new SignInPage(driver);
		sip.SignInPage("John.Sina@dummy.com", "Ert@#$123", "John Sina");		
	}
	
	@Test	//TC02 - Email & Password are NULL
	public void signInTest_TC2() throws InterruptedException {
		SignInPage sip = new SignInPage(driver);
		sip.SignInPage(null,null,null);
	}
	
	@Test	//TC03 - Check for Valid Password
	public void signInTest_TC03() throws InterruptedException {
		SignInPage sip = new SignInPage(driver);
		sip.SignInPage("Rishabh@gmail.com", "Abc123", "Rishabh Verma");
	}
	
	@Test	//TC04 - Check for Valid Email Address
	public void singInTest_TC04() throws InterruptedException {
		SignInPage sip = new SignInPage(driver);
		sip.SignInPage("Rishabh", "Ert@#$123", "Rishabh Verma");
	}
}
