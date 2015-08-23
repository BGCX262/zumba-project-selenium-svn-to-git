

package Grid;
import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.SeleneseTestNgHelper;
import com.thoughtworks.selenium.Selenium;


public class Shop extends SeleneseTestNgHelper{


		public Selenium selenium;
		
		@BeforeTest	
		public void setUpTest() throws Exception{
			
			/*selenium = new DefaultSelenium("localhost", 4444, "*iehta", "http://public.staging.zumba.com/");*/		
		selenium = new DefaultSelenium("localhost", 4444, "*firefox", "http://www.zumba.com/");
		selenium.start();
		selenium.windowMaximize();
		}	
		@Test 
		public void US_Shop_3() throws Exception {
		selenium.open("/en-US");
		waitTime(10000);
		selenium.click("xpath=(//a[contains(text(),'Shop')])[2]");
		waitTime(6000);
		selenium.click("//div[@id='layout-page-content']/div[7]/div/section[2]/div/div/div/div/ul/li/div/a/img");
		waitTime(6000);
		selenium.click("//div[@id='layout-page-content']/div[3]/form/section/div[2]/div/fieldset/div/ol/li/a");
		waitTime(6000);
		selenium.click("//div[@id='layout-page-content']/div[3]/form/section/div[2]/div/fieldset[2]/div/ul/li/span");
		waitTime(6000);
		selenium.select("//div[@id='layout-page-content']/div[3]/form/section/div[2]/div/fieldset[2]/div[2]/div/select", "label=2");
		selenium.click("//div[@id='layout-page-content']/div[3]/form/section/div[2]/div/fieldset[3]/div/button");
		waitTime(6000);
		selenium.click("//div[@id='layout-page-content']/div[3]/form/section/div[2]/div/fieldset[3]/div/button");
		waitTime(1000);
		selenium.click("//a[2]");
		waitTime(6000);
		selenium.click("link=Proceed with Checkout");
		waitTime(20000);
		selenium.type("name=first_name", "Javed");
		selenium.type("name=last_name", "Chowdhury");
		selenium.type("name=email", "javed.chowdhury@zumba.com");
		selenium.type("name=phone", "9542222222");
		selenium.type("id=street_address", "800 Silks Run");
		waitTime(2000);
		selenium.select("name=state", "label=Florida");
		selenium.type("name=city", "Hallandale Beach");
		selenium.type("name=zip", "33009");
		selenium.click("//div[@id='layout-page-content']/div[3]/section/form/div[3]/fieldset[2]/div/input");
		selenium.click("css=label");
		selenium.click("//button[@type='submit']");
		waitTime(10000);	
		selenium.type("name=credit_card", "4111111111111111");
		selenium.select("name=expiration_month", "label=01");
		selenium.select("name=expiration_year", "label=18");
		selenium.type("name=cvv", "111");
		//waitTime(1000);
		String SubTotal = selenium.getText("//div[@id='layout-page-content']/div[3]/aside/section/div/div/div[2]");
		System.out.println(SubTotal);
		selenium.click("//input[@id='payment-create-account']");
		waitTime(10000);
		//selenium.click("/html/body/div[2]/div/div[2]/div[3]/section/form/fieldset[7]/label");

		String Total = selenium.getText("//div[@id='layout-page-content']/div[3]/aside/section/div/div[4]/div[2]/strong");
		System.out.println(Total);
		System.out.println("========================================");
		}
		
		
		@Test 
		public void CheckFooterSignIn() throws Exception {
		selenium.open("/en-US");
		waitTime(10000);
		selenium.click("link=Sign in as a ZIN™");
		selenium.waitForPageToLoad("6000");
		verifyTrue(selenium.isElementPresent("//div[@id='layout-page-content']/div[3]/div/header/h1"));
		String checkSignInPage = selenium.getText("//div[@id='layout-page-content']/div[3]/div/header/h1");
		System.out.println(checkSignInPage);
		assertTrue(selenium.getText("//div[@id='layout-page-content']/div[3]").matches("^Hello Gorgeous! Sign In or Sign Up\n Email or Username Email or username is required\\. \n Password Forgot password[\\s\\S] Required field \n Sign In OR\n Login with Facebook$"));
		String CheckSignInButton = selenium.getText("//div[@id='layout-page-content']/div[3]/div/form/button");
		System.out.println(CheckSignInButton);
		String CheckFaceBookLoginButton = selenium.getText("//div[@id='layout-page-content']/div[3]/div/div/a/span[2]");
		System.out.println(CheckFaceBookLoginButton);
		selenium.waitForPageToLoad("6000");
		selenium.click("link=Sign Up");
/*	selenium.waitForPageToLoad("6000");
		assertTrue(selenium.getText("//div[@id='layout-page-content']/div[3]").matches("^Join the Party! Sign Up or Sign In\n [\\s\\S]*Required fields\n First Name[\\s\\S]* First name is required\\. \n Last Name[\\s\\S]* Last name is required\\. \n Email[\\s\\S]* This field should be a valid email and is required \n Username[\\s\\S]* Username is required, and must have only letters \\(A-Z\\), dash \\(-\\), and dot \\(\\.\\), with no spaces\\. \n Choose a password[\\s\\S]* Password must be at least 8 characters long \n Confirm Password[\\s\\S]* Your passwords don't match \n I would like to receive occasional email updates from Zumba\\. \n I agree to the Zumba Terms of Use [\\s\\S]* Please agree to the Zumba Terms of Use \n Create Account We never sell your personal information\\.\n Read our privacy policy$"));
*/
		System.out.println("========================================");	
		
		}		
		
		@Test 
		public void US_Guest_Shop() throws Exception {
		selenium.open("/en-US");
		waitTime(10000);
		selenium.click("//a[3]");
		selenium.waitForPageToLoad("6000");
		assertTrue(selenium.getText("//div[@id='layout-page-content']/div[3]").matches("^Hello Gorgeous! Sign In or Sign Up\n Email or Username Email or username is required\\. \n Password Forgot password[\\s\\S] Required field \n Sign In OR\n Login with Facebook$"));
		selenium.click("link=Sign Up");
		//assertTrue(selenium.getText("//div[@id='layout-page-content']/div[3]").matches("^Join the Party! Sign Up or Sign In\n [\\s\\S]*Required fields\n First Name[\\s\\S]* First name is required\\. \n Last Name[\\s\\S]* Last name is required\\. \n Email[\\s\\S]* This field should be a valid email and is required \n Username[\\s\\S]* Username is required, and must have only letters \\(A-Z\\), dash \\(-\\), and dot \\(\\.\\), with no spaces\\. \n Choose a password[\\s\\S]* Password must be at least 8 characters long \n Confirm Password[\\s\\S]* Your passwords don't match \n I would like to receive occasional email updates from Zumba\\. \n I agree to the Zumba Terms of Use [\\s\\S]* Please agree to the Zumba Terms of Use \n Create Account We never sell your personal information\\.\n Read our privacy policy$"));

		System.out.println("========================================");
		
		/*selenium.click("//button[@type='submit']");
		waitTime(10000);
		selenium.click("//button");
		waitTime(60000);
		String OrderNumber = selenium.getText("css=h2.ch-number");
		System.out.println(OrderNumber);*/
		}
		
		@AfterTest
		public void endTest(){	
			//selenium.close();
		}
		
		public static void waitTime(int Time) throws Exception
		{
			Thread.sleep(Time);
		}
}
