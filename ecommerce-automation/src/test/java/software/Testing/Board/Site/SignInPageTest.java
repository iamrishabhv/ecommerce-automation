package software.Testing.Board.Site;

import org.testng.annotations.Test;

import SoftwareTestingBoardSite.BaseTest;
import SoftwareTestingBoardSite.SignInPage;

public class SignInPageTest extends BaseTest{
	
	@Test
	public void signInTest() throws InterruptedException {
		SignInPage sip = new SignInPage(driver);
		sip.SignInPage("John.Sina@dummy.com", "Ert@#$123", "John Sina");		
	}
}
