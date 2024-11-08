package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class LoginPage {

    public SelenideElement buttonLog = $x("//button[@type='button']");

    public SelenideElement inputUsername = $x("//*[@id='username']");

    public SelenideElement inputPassword = $x("//*[@id='password']");

    public SelenideElement buttonAction = $x("//button[contains(@class, 'cf09f87bc')]");

    public SelenideElement spanLaunch = $x("/html/body/div[1]/main/article[1]/div[2]/div/article/div[1]/button/span");

    public SelenideElement settingsMenu = $x("//a[@href='/9ba7ce21-d284-4973-8402-08a4829e37e5/settings']");

    public SelenideElement businessHourMenu = $x("//div[@class = 'bg-indigo-200 text-indigo-600']");

    public SelenideElement btnContinue = $x("//button[contains(@class, 'c0a486a03')]");

    public SelenideElement btnContinueLogin = $x("//button[@type='submit']");

    public SelenideElement buttonQALaunch = $x("//button[span[text()='Launch']]"); // Uses XPath to select the button by its text.
}


