package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.apache.commons.codec.binary.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import PageObjects.BELoginPage;
import PageObjects.CreateNewsPage;
import PageObjects.MngtSubPage;
import cucumber.api.PendingException;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MngtSubSteps {

	WebDriver driver = Hook.driver;
	
	MngtSubPage mngtSubPage;
	
//	@Before
//	public void StartTest() {
//		mngtSubPage = new MngtSubPage(driver);
//	}
//
//	@After
//	public void EndTest(Scenario scenario) {
//		if (scenario.isFailed()) {
//			byte[] screenshot = ((RemoteWebDriver) this.driver).getScreenshotAs(OutputType.BYTES);
//			scenario.embed(screenshot, "image/png");
//		}
//	}
	@Given("^At the Backend page$")
	public void at_the_Backend_page() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		mngtSubPage = new MngtSubPage(driver);
	   
	}
	@When("^I click link Dang ky nhan tin$")
	public void i_click_link_Dang_ky_nhan_tin() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		mngtSubPage.linkMngtSub.click();
	}

	@Then("^I should see list of Subscriber$")
	public void i_should_see_list_of_Subscriber() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		driver.manage().timeouts().implicitlyWait(100, TimeUnit.MILLISECONDS);
		Assert.assertTrue(mngtSubPage.tableSub != null);
	}

	@Then("^Email sorted by alphabet$")
	public void email_sorted_by_alphabet() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		String prevEmail = "", email = "";
		WebElement statusActive, statusInactive;
		for(WebElement row : mngtSubPage.subRows) {
			email = row.findElements(By.xpath("td")).get(0).getText();
			statusActive = row.findElement(By.xpath("//i[@class=\"fa fa-check\"]"));
			statusInactive = row.findElement(By.xpath("//i[@class=\"fa fa-remove\"]"));
			Assert.assertFalse(statusActive == null && statusInactive == null);
			Assert.assertTrue(email.compareToIgnoreCase(prevEmail)>= 0);
			
			
		}
	}

	

	
}
