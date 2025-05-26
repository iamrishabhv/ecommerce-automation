package software.Testing.Board.Site;

import org.testng.annotations.Test;

import SoftwareTestingBoardSite.BaseTest;
import SoftwareTestingBoardSite.CreateAccountPage;

public class CreateAccountTest extends BaseTest{
	
	@Test	//End to End Successful Registration on the Website.
	public void testCreateAccountPage() {
		CreateAccountPage cap = new CreateAccountPage(driver);
		cap.CreateAccPage("John", "Sina", "John.Sina@dummy.com", "Ert@#$123");
	}

}
