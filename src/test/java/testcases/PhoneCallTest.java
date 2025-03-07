package testcases;

import base.TestBase;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.PhoneCall;
public class PhoneCallTest extends TestBase {
    private PhoneCall PhoneCall;
    @BeforeSuite
    public void setUp() {
        // Set up ChromeOptions for each test method to run in isolation
        //open(url);
        PhoneCall = new PhoneCall();
    }

    @AfterSuite
    public void tearDown() {
        // Close the browser after each test to avoid conflicts
        Selenide.closeWebDriver();
    }

    @Test
    public void DisplayTicketFields() throws InterruptedException {
        PhoneCall.btnPhone.click();
        Thread.sleep(10000);
        PhoneCall.button.click();
        Thread.sleep(30000);

        // Store the current window handle
        String originalWindow = WebDriverRunner.getWebDriver().getWindowHandle();
        WebDriverRunner.getWebDriver().switchTo().window(originalWindow);

        // Set the number of iterations
        int iterations = 2;
        for (int i = 0; i < iterations; i++) {
            PhoneCall.inputName.setValue("09974580583");
            PhoneCall.btnCall.click();
            Thread.sleep(70000);
            if(i==0) {
                PhoneCall.btnContact.click();
                Thread.sleep(10000);
            }
            PhoneCall.contacts.click();
            Thread.sleep(10000);
            PhoneCall.btnDelete.click();
            Thread.sleep(10000);
            PhoneCall.buttonDeleteConfirm.click();
            Thread.sleep(10000);
        }

    }
}
