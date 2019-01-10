package StepDefinitions;

import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;

import PageObjects.BELoginPage;
import PageObjects.CreateNewsPage;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateNewsSteps {

	WebDriver driver = Hook.driver;
	
	CreateNewsPage createNewsPage;
	
//	@Before
//	public void StartTest() {
//		System.setProperty("webdriver.chrome.driver", "C:\\driver\\chromedriver.exe");
//		driver = new ChromeDriver();
//		Hook.driver = driver;
//		System.out.println("call createnew starttest");
//		createNewsPage = new CreateNewsPage(driver);
//	}
//
//	@After
//	public void EndTest(Scenario scenario) {
//		if (scenario.isFailed()) {
//			byte[] screenshot = ((RemoteWebDriver) this.driver).getScreenshotAs(OutputType.BYTES);
//			scenario.embed(screenshot, "image/png");
//		}
//	}

	
	@When("^I click link soan gui tin$")
	public void i_click_link() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    //throw new PendingException();
		createNewsPage = new CreateNewsPage(driver);
		Actions actions = new Actions(driver);
		actions.moveToElement(createNewsPage.linkCreateNews);
		Thread.sleep(2000);
		createNewsPage.linkCreateNews.click();
	}

	@When("^I click next button$")
	public void i_click_next_button() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		Actions actions = new Actions(driver);
		actions.moveToElement(createNewsPage.btnNext);
		Thread.sleep(2000);
		createNewsPage.btnNext.click();
	}

	@Then("^I should see the messages required fields$")
	public void i_should_see_the_messages_required_fields() throws Exception {
		int i = 0;
		for(WebElement error : createNewsPage.txtErrors){
			Assert.assertEquals(error.getText(), "This is required field");
			i ++;
		}
		Assert.assertEquals(i, 3);
		
		Assert.assertEquals(hasClass(createNewsPage.txtName, "error"),true);
		Assert.assertEquals(hasClass(createNewsPage.txtSubject, "error"),true);
		Assert.assertEquals(hasClass(createNewsPage.txtBodyError, "error"),true);
		
	}
	
	@When("^I type E character$")
	public void i_type_E_character() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		Actions actions = new Actions(driver);
		actions.moveToElement(createNewsPage.txtInBody);
		Thread.sleep(1000);
	    createNewsPage.txtInBody.sendKeys("E");
	    Thread.sleep(1000);
	}

	@Then("^I should see the Email in list$")
	public void i_should_see_the_Email_in_list() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(createNewsPage.txtMergeTagHint.getText(),"Email");
	}

	@When("^I select Email from list$")
	public void i_select_Email_from_list() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    createNewsPage.txtMergeTagHint.click();
	}

	@Then("^The content will be restored as plan text$")
	public void the_content_will_be_restored_as_plan_text() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
		Assert.assertEquals(createNewsPage.txtMergeTag.getText(),"Email");
	}


	
	public boolean hasClass(WebElement element, String cls) {
	    String classes = element.getAttribute("class");
	    for (String c : classes.split(" ")) {
	        if (c.equals(cls)) {
	            return true;
	        }
	    }

	    return false;
	}
}
