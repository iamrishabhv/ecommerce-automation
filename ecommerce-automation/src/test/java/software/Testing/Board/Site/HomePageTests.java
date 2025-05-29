package software.Testing.Board.Site;

import org.testng.annotations.Test;

import SoftwareTestingBoardSite.BaseTest;
import SoftwareTestingBoardSite.HomePage;

public class HomePageTests extends BaseTest{
	
	/*Home page loads without errors, main elements are displayed*/
	@Test
	public void TC_HP_001() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.HomePageElements();		
	}

	/*Check for the presence of the logo
	 * Verify search bar is visible
	 * Confirm shopping cart and user login links are displayed*/
	@Test
	public void TC_HP_002() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.HomePageHeaderElements();
	}

}
