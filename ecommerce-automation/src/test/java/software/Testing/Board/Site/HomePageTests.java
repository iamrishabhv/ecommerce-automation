package software.Testing.Board.Site;

import org.testng.annotations.Test;

import SoftwareTestingBoardSite.BaseTest;
import SoftwareTestingBoardSite.HomePage;

public class HomePageTests extends BaseTest{
	
	@Test
	public void TC_HP_001() throws InterruptedException {
		HomePage hp = new HomePage(driver);
		hp.HomePageElements();		
	}

}
