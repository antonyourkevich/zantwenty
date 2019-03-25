package environment;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	@FindBy(xpath = ".//a[@data-name='link' and not(ancestor::div[contains(@style, 'display: none;')])]")
	private List<WebElement> lettersList;

	@FindBy(xpath = "//*[@id=\"b-toolbar__right\"]/div[2]/div/div[2]/div[1]/div/div[1]/div[1]/div[1]")
	public List<WebElement> listofCheckboxes;

	@FindBy(xpath = ".//span[contains(text(),' «Спам».')]")
	public WebElement spam;

	@FindBy(xpath = ".//span[contains(text(),' «Входящие»')]")
	public WebElement tovhodyachie;

	@FindBy(xpath = "(.//div[@class=\"b-checkbox__box\"])[1]")
	public WebElement checkbox;

	@FindBy(xpath = "(.//div[@data-name=\"flagged\"])[1]")
	public WebElement alllags;

	@FindBy(xpath = "(.//div[@data-name='send'])[1]")
	public WebElement send;

	@FindBy(xpath = "(.//div[contains(@class, 'b-checkbox__box')])[1]")
	public WebElement checkAll;

	@FindBy(xpath = "(.//div[@data-name='spam'])[1]")
	public WebElement spamButton;

	@FindBy(xpath = "(.//div[@data-name='noSpam'])[1]")
	public WebElement noSpamButton;

	@FindBy(xpath = ".//div[@id='b-nav_folders']//span[text()='Спам']")
	public WebElement spamFolder;

	@FindBy(xpath = ".// td/iframe")
	public WebElement frame;

	@FindBy(xpath = "(.//a[@data-name='compose'])[1]")
	private WebElement WriteButton;

	@FindBy(xpath = "(.//*[@data-original-name='To'])[1]")
	private WebElement Recipient;

	@FindBy(xpath = "//*[@name='Subject']")
	private WebElement topics;

	@FindBy(xpath = ".//div[@class='message-sent__title']")
	private WebElement messageSentTitle;

	@FindBy(xpath = ".//a[@data-name='link'and not(ancestor::div[contains(@style, 'display: none;')])]//div[contains(@class, 'b-flag_yes')]//b")
	public List<WebElement> listofflags;

	@FindBy(xpath = "(.//div[contains(@class, 'b-dropdown_more')])[1]")
	public WebElement moreButtons;

	@FindBy(xpath = "(.//a[@data-name='flag_no'])[1]")
	public WebElement removeFlags;

	String textMessageField = ".//body [@id='tinymce']";

	public void FromSpam(int index) {

		clickNoSpamButton();

	}

	public void clickSpamButton() {
		spamButton.click();
	}

	public void clickNoSpamButton() {
		noSpamButton.click();
	}

	public void GoToSpam(int index) {

		clickSpamButton();

	}

	public String getMessage() {
		return messageSentTitle.getText();
	}

	public List<WebElement> getLettersList() {
		return lettersList;
	}

	public void sendLetter(List<String> sendToEmails, String topic, String message) {
		WriteButton.click();
		sendToEmails.forEach(email -> Recipient.sendKeys(email));
		topics.sendKeys(topic);
		send.click();

	}

	public LoginPage(WebDriver driver) {

		PageFactory.initElements(driver, this);
	}

	public void removeAllFlag() {
		checkbox.click();
		checkAll.click();
		moreButtons.click();
		removeFlags.click();
	}

	public boolean isAddedToSpam() {
		return spam.isDisplayed();
	}

	public boolean MoveFromSpam() {
		return tovhodyachie.isDisplayed();
	}

	public void goToSpam() {
		spamFolder.click();

	}

	public List<WebElement> getCheckBox() {
		return listofCheckboxes;
	}

	public List<WebElement> getMarkTheFlag() {
		return listofflags;
	}

}