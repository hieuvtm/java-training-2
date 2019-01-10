package StepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

import PageObjects.BELoginPage;
import PageObjects.RegisterPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Hook {
	public static WebDriver driver;
	BELoginPage beloginPage;
	@Before
	public void StartTest()
	{
		System.out.println("call hook start test");
		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
		driver = new ChromeDriver();
		beloginPage = new BELoginPage(Hook.driver);	
	}
	
	@After
	public void EndTest(Scenario scenario)
	{
		System.out.println("call hook endtest");
		if (scenario.isFailed()) {
	        byte[] screenshot = 
	        		((RemoteWebDriver) this.driver).getScreenshotAs(OutputType.BYTES);
	        scenario.embed(screenshot, "image/png");
	    }
	}
	
	
	@Given("^I navigate to the login page$")
	public void i_navigate_to_the_login_page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
//		if(driver == null) {
//			driver = Hook.driver;
//			beloginPage = new BELoginPage(driver);	
//			createNewsPage = new CreateNewsPage(Hook.driver);	
//		}
		driver.get("http://testmaster.vn/Admin");
		driver.manage().window().maximize();
		
	}

	@When("^I submit username and password$")
	public void i_submit_username_and_password() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		beloginPage.txtUsername.sendKeys("khanh.tx@live.com");
		beloginPage.txtPassword.sendKeys("abc123");
		beloginPage.btnLogin.click();
	    
	}

	@Then("^I should be logged in$")
	public void i_should_be_logged_in() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		Thread.sleep(2000);
		String text= beloginPage.logo.getText();

	    Assert.assertEquals(text, "Testmaster.vn - Admin");
	}
	
}
