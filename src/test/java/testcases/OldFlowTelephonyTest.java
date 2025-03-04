package testcases;

import base.TestBase;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.OldFlowTelephony;

import java.time.Duration;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class OldFlowTelephonyTest extends TestBase {
    private OldFlowTelephony OldFlowTelephony;

    @BeforeSuite
    public void setUp() {
        OldFlowTelephony = new OldFlowTelephony();
    }

    @AfterSuite
    public void tearDown() {
        // Close the browser after each test to avoid conflicts
        Selenide.closeWebDriver();
    }

    @Test
    public void OutgoingCallWithoutContactEdit() throws InterruptedException {
        // Maximize the window
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();
        OldFlowTelephony.showMenu.click();

        // calling phone
        setOutgoingTelephonyWithoutEdit("66939168513");
        // show contracts page
        OldFlowTelephony.mainMenuContact.click();
        showContact();
        // search called phone number
        searchPhoneNumber("66939168513");
    }

    @Test(dependsOnMethods = "OutgoingCallWithoutContactEdit")
    public void OutgoingCallWithContactEdit() throws InterruptedException {
        // calling phone
        setOutgoingTelephonyWithEdit("66939168513","In Jing Khet");
        // show contracts page
        OldFlowTelephony.dashboard.click();
        showContact();
        // search called phone number
        searchPhoneNumber("66939168513");
    }

    @Test(dependsOnMethods = "OutgoingCallWithContactEdit")
    public void InboundCallWithoutContactEdit() throws InterruptedException {
        // calling phone
        setInboundTelephonyWithoutEdit();
        // go to contracts page
        OldFlowTelephony.dashboard.click();
        showContact();
    }

    @Test(dependsOnMethods = "InboundCallWithoutContactEdit")
    public void InboundCallWithContactEdit() throws InterruptedException {
        // calling phone
        setInboundTelephonyWithEdit("In Jing Khet");
        // go to contracts page
        OldFlowTelephony.dashboard.click();
        showContact();
    }

    // input phone number and edit contact name during the outgoing call
    public void setOutgoingTelephonyWithEdit(String phone, String name) throws InterruptedException {
        Thread.sleep(3000);
        OldFlowTelephony.PhoneNumber.shouldBe(visible,Duration.ofSeconds(20)).setValue(phone);
        OldFlowTelephony.btnCall.click();
        withContactEdit(name);
    }

    // without edit contact name during the outgoing call
    public void setOutgoingTelephonyWithoutEdit(String phone) throws InterruptedException {
        Thread.sleep(3000);
        OldFlowTelephony.PhoneNumber.shouldBe(visible).setValue(phone);
        OldFlowTelephony.btnCall.click();
        Thread.sleep(20000);
        withoutContactEdit();
    }

    // edit contact name during the incoming call
    public void setInboundTelephonyWithEdit(String name) throws InterruptedException {
        Thread.sleep(20000);
        OldFlowTelephony.btnAnswer.shouldBe(visible, Duration.ofSeconds(50)).click();
        withContactEdit(name);
    }

    // without edit contact name during the incoming call
    public void setInboundTelephonyWithoutEdit() throws InterruptedException {
        Thread.sleep(10000);
        OldFlowTelephony.btnAnswer.shouldBe(visible, Duration.ofSeconds(50)).click();
        Thread.sleep(20000);
        withoutContactEdit();
    }

    // without edit contract
    public void withoutContactEdit() throws InterruptedException {
        OldFlowTelephony.select.shouldBe(visible, Duration.ofSeconds(30)).selectOption("Other");
        // Scrolling to view added member status
        OldFlowTelephony.scrollDiv.scrollIntoView(true);
        executeJavaScript("arguments[0].scrollTop = arguments[0].scrollHeight", OldFlowTelephony.scrollDiv);
        Thread.sleep(1000);
        OldFlowTelephony.select2.shouldBe(visible, Duration.ofSeconds(30)).selectOption("click save button in closed room");
        OldFlowTelephony.complete.click();
    }

    // edit contract
    public void withContactEdit(String name) throws InterruptedException {
        OldFlowTelephony.btnPhoneBar.shouldBe(visible, Duration.ofSeconds(20)).click();
        OldFlowTelephony.editContactButton.shouldBe(visible, Duration.ofSeconds(50)).click();
        OldFlowTelephony.inputField.shouldBe(visible, Duration.ofSeconds(20)).clear();
        Thread.sleep(1000);
        OldFlowTelephony.inputField.setValue(name);
        OldFlowTelephony.selectElement.shouldBe(visible).selectOption("hi hello");
        OldFlowTelephony.save.click();
        OldFlowTelephony.select.shouldBe(visible, Duration.ofSeconds(30)).selectOption("Other");
        // Scrolling to view added member status
        OldFlowTelephony.scrollDiv.scrollIntoView(true);
        executeJavaScript("arguments[0].scrollTop = arguments[0].scrollHeight", OldFlowTelephony.scrollDiv);
        Thread.sleep(1000);
        OldFlowTelephony.select2.shouldBe(visible, Duration.ofSeconds(30)).selectOption("click save button in closed room");
        OldFlowTelephony.complete.click();
    }

    // Show Contact
    public void showContact () throws InterruptedException {
        OldFlowTelephony.subMenuContact.click();
        Thread.sleep(5000);

    }

    // search called phone number
    public void searchPhoneNumber(String phone) throws InterruptedException {
        OldFlowTelephony.iconSearch.click();
        OldFlowTelephony.inputPhoneNumber.clear();
        OldFlowTelephony.inputPhoneNumber.setValue(phone);
        Thread.sleep(5000);
    }
}