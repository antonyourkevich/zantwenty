
package environment;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;

import java.util.Arrays;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;

public class Tests {

	private WebDriver driver;
	private LoginPage loginPage;
	private ProjectPage projectpage;
	private static final String Url = "https://mail.ru/";
	private static final String email = "antonyourkevich09";
	private static final String password = "antonigorevichanton";

	@BeforeClass
	public void beforeClass() {
		System.out.println("тест -класс стартанул.");
	}

	@BeforeMethod
	public void beforeMethod() {
		driver = new ChromeDriver();
		loginPage = new LoginPage(driver);
		projectpage = new ProjectPage(driver);

	}

	@Test
	public void sendingMessage() {
		projectpage.loginMailRu(Url, email, password);
		String[] sendToEmails = { "https://mail.ru/", "antonyourkevich009@mail.ru", "antonigorevich" };
		String text = "Test .";
		String topic = "Topic";
		loginPage.sendLetter(Arrays.asList(sendToEmails), topic, text);
		String expectedMessage = "Ваше письмо отправлено. Перейти во Входящие";
		Assert.assertEquals(expectedMessage, loginPage.getMessage());
	}

	@Test
	public void testFlags() {
		projectpage.loginMailRu(Url, email, password);
		Assert.assertTrue(loginPage.getCheckBox().size() > 0, "нет писем с флажком");
		int number = 0;
		Assert.assertEquals(loginPage.listofflags.size(), number);
	}

	@Test
	public void flagsdeselect() {
		projectpage.loginMailRu(Url, email, password);
		loginPage.removeAllFlag();
		Assert.assertFalse(loginPage.getMarkTheFlag().size() > 0);
	}

	@Test
	public void Nogotospam() {
		projectpage.LoginAndPassword(email, password);
		Assert.assertNotNull(loginPage.getLettersList(), "Писем нет");
		int indexOfLetter = 0;
		loginPage.GoToSpam(indexOfLetter);
		Assert.assertFalse(loginPage.goToSpam(), "  Письмо не перемещено в папку «Спам»");
	}

	@Test
	public void gofromspam() {
		projectpage.loginMailRu(Url, email, password);
		loginPage.goToSpam();
		Assert.assertNotNull(loginPage.getLettersList(), " писем нет");
		int indexOfLetter = 0;
		loginPage.FromSpam(indexOfLetter);
		Assert.assertEquals(loginPage.MoveFromSpam(), "Письмо перемещено в папку «Спам»");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}

	@AfterClass
	public void afterClass() {
		System.out.println("конец");

	}

}