
package pages;

import com.codeborne.selenide.SelenideElement;
import static com.codeborne.selenide.Selenide.$x;
public class LoginPage {
    public SelenideElement buttonLog = $x("//button[@type='button']");
    public SelenideElement inputUsername = $x("//*[@id='username']");
    public SelenideElement inputPassword = $x("//*[@id='password']");
    public SelenideElement settingsMenu = $x("//a[@href='/9ba7ce21-d284-4973-8402-08a4829e37e5/settings']");
    public SelenideElement businessHourMenu = $x("//div[@class = 'bg-indigo-200 text-indigo-600']");
    public SelenideElement btnContinue = $x("//button[contains(@class, 'c12f661b1 c567de7a4 c09c9561d c8b873213 _button-login-id')]");
    public SelenideElement btnContinueLogin = $x("//button[@type='submit']");
    public SelenideElement buttonQALaunch = $x("//button[span[text()='Launch']]"); // Uses XPath to select the button by its text.
}


