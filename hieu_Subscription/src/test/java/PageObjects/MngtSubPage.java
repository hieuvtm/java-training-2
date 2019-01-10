package PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MngtSubPage {
	
	@FindBy(xpath = "//a[@action=\"/subscription/subscriber\"]")
	public WebElement linkMngtSub;
	
	@FindBy(xpath = "//table[@class=\"table table-hover table-bordered\"]")
	public WebElement tableSub; 
	
	@FindBy(xpath = "//table[@class=\"table table-hover table-bordered\"]/tbody/tr")
	public List<WebElement> subRows; 
	
	@FindBy(xpath = "//i[@class=\"fa fa-check\"]")
	public WebElement activeStatus;
	
	@FindBy(xpath = "//i[@class=\"fa fa-remove\"]")
	public WebElement unActiveStatus;
	
	
	public MngtSubPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
}
