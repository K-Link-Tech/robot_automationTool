package testcases;

import base.TestBase;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.LoginPage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest {
    private LoginPage loginPage;

    @BeforeSuite
    public void setUp() {
        // Set up ChromeOptions for each test method to run in isolation
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--remote-allow-origins=*");

        Configuration.browserCapabilities = options;
        Configuration.browserSize = "1280x900";
        Configuration.holdBrowserOpen = false; // Ensure browser closes after each test
        open(TestBase.url);
        loginPage = new LoginPage();
    }

    @AfterSuite
    public void tearDown() {
        // Close the browser after each test to avoid conflicts
        Selenide.closeWebDriver();
    }

    @Test
    public void LoginQA() throws InterruptedException {
        Thread.sleep(3000);
        loginPage.buttonLog.shouldBe(visible).click();
        loginPage.inputUsername.setValue(TestBase.username);
        loginPage.btnContinue.click();
        loginPage.inputPassword.setValue(TestBase.password);
        loginPage.btnContinueLogin.shouldBe(visible).click();
        Thread.sleep(10000);
        loginPage.buttonQALaunch.shouldBe(visible).click();
    }

    @Test (dependsOnMethods = "LoginQA")
    public void DisplaySettingPage() throws InterruptedException {
        Thread.sleep(10000);
        loginPage.settingsMenu.shouldBe(visible).click();
    }

    @Test (dependsOnMethods = "DisplaySettingPage")
    public void DisplayBusinessHourMenu() throws InterruptedException {
        loginPage.businessHourMenu.shouldBe(visible).click();
        Thread.sleep(10000);
    }
}
