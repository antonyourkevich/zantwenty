
package environment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.net.Urls;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ProjectPage extends Tests {

	protected WebDriver driver;

	@FindBy(xpath = "(//div[contains(@class,'checkbox__box') //:div[@id='b-letters']//(ancestor::div[contains(@style, 'display: none;')])])")
	public List<WebElement> checkboxList;

	@FindBy(id = "//*[@id=\"mailbox:login\"]")
	private WebElement loginField;

	@FindBy(id = "//*[@id=\"mailbox:password\"]")
	private WebElement passwordField;

	public ProjectPage(WebDriver driver) {
		super();
		PageFactory.initElements(driver, this);
	}

	public void open(String Url) {
		driver.get(Url);
	}

	public void LoginAndPassword(String email, String password) {

		WebElement login = driver.findElement(By.xpath("//*[@id=\"mailbox:password\"]"));
		login.sendKeys("antonyourkevich09");
		WebElement password2 = driver.findElement(By.xpath("//*[@id=\"mailbox:password\"]"));
		password2.sendKeys("antonigorevichanton");
		passwordField.submit();

	}

	public void loginMailRu(String Url, String login, String password) {
		open(Url);
		LoginAndPassword(login, password);
	}

}