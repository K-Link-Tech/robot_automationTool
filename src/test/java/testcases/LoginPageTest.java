package testcases;

import base.TestBase;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import pages.LoginPage;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class LoginPageTest extends TestBase {
    private LoginPage loginPage;

    @BeforeSuite
    public void setUp() {
        // Set up ChromeOptions for each test method to run in isolation
        //Initialization();
        open(url);
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
        loginPage.btnContinue.shouldBe(visible).click();
        loginPage.inputPassword.setValue(TestBase.password);
        loginPage.btnContinueLogin.shouldBe(visible).click();
        Thread.sleep(10000);
        loginPage.buttonQALaunch.shouldBe(visible).click();
    }

    @Test (dependsOnMethods = "LoginQA")
    public void DisplaySettingPage() throws InterruptedException {
        Thread.sleep(10000);
       // loginPage.settingsMenu.shouldBe(visible).click();
        loginPage.settingsMenu.click();
    }

    @Test (dependsOnMethods = "DisplaySettingPage")
    public void DisplayBusinessHourMenu() throws InterruptedException {
       // loginPage.businessHourMenu.shouldBe(visible).click();
        loginPage.businessHourMenu.click();
        Thread.sleep(10000);
    }
}
