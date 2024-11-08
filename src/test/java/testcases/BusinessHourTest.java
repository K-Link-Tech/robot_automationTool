package testcases;

import base.TestBase;
import com.codeborne.selenide.*;
import com.codeborne.selenide.conditions.Visible;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.*;
import pages.BusinessHour;
import pages.LoginPage;
import java.time.Duration;
import java.util.List;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byAttribute;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.files.DownloadActions.click;
import com.codeborne.selenide.Selectors;

public class BusinessHourTest {
    private SelenideElement buttonCreateNew;
    private BusinessHour businesshr;
    private ChromeOptions options = new ChromeOptions();

    @BeforeSuite
    public void setUp() {
        options.addArguments("--disable-save-password-bubble");
        options.addArguments("--remote-allow-origins=*");

        Configuration.browserCapabilities = options;
        Configuration.browserSize = "1280x900";
        Configuration.holdBrowserOpen = false; // Ensure browser closes after each test

        open(TestBase.url);
        buttonCreateNew = $x("//button[contains(@class, 'text-white')]");
        businesshr = new BusinessHour();
    }

    @AfterSuite
    public void tearDown() {
        Selenide.closeWebDriver();
    }

    public void clickCreateNewButton(String BusinessHrName, String Desc) throws InterruptedException {
        Thread.sleep(3000);
        buttonCreateNew.shouldBe(visible).click();
        businesshr.inputName.setValue(BusinessHrName);
        businesshr.inputDesc.setValue(Desc);
        businesshr.monfromtime.setValue("09:00");
        businesshr.montotime.setValue("16:30");
        businesshr.tuefromtime.setValue("09:00");
        businesshr.Tuetotime.setValue("16:30");
        businesshr.wedfromtime.setValue("09:00");
        businesshr.WebToTime.setValue("16:30");
        businesshr.thurfromtime.setValue("09:00");
        businesshr.ThurToTime.setValue("16:30");
        businesshr.Fridayfromtime.setValue("09:00");
        businesshr.FridayToTime.setValue("16:30");
        Thread.sleep(3000);
        businesshr.btnSave.shouldBe(visible).click();
        businesshr.btnCancel.shouldBe(visible).click();
    }

    @Test
    public void AddBusinessHr() throws InterruptedException {
        clickCreateNewButton("QA Test", "QA Desc");
    }

    //Delete existing business hour (Optional) not required to execute this test suite every time.
    @Test(dependsOnMethods = "AddBusinessHr")
    public void DeleteBusinessHr() throws InterruptedException
    {
        clickCreateNewButton("Deleted Testing", "Deleted Testing purpose");
        Thread.sleep(6000);
        businesshr.clickThreeDots("Deleted Testing");
        businesshr.clickDeleteOption();
        Thread.sleep(10000);
        businesshr.deleteButton.click();
        Thread.sleep(5000);
    }

    //Default business hour
    public void DefaultBusinessHour() throws InterruptedException
    {
        Thread.sleep(5000);
        businesshr.monfromtime.setValue("09:00");
        businesshr.montotime.setValue("17:00");
        businesshr.tuefromtime.setValue("09:00");
        businesshr.Tuetotime.setValue("17:00");
        businesshr.wedfromtime.setValue("09:00");
        businesshr.wedtotime.setValue("17:00");
        businesshr.thurfromtime.setValue("09:00");
        businesshr.ThurToTime.setValue("17:00");
        businesshr.Fridayfromtime.setValue("09:00");
        businesshr.FridayToTime.setValue("17:00");
        Thread.sleep(3000);
        businesshr.btnSave.shouldBe(visible).click();
        businesshr.btnCancel.shouldBe(visible).click();
    }

    // Select working day or non-working day (Optional) this test suite is not required to execute every time
    public void select_unselectDays() throws InterruptedException {
        if ($x("//div[contains(text(),'mon')]").has(cssClass("bg-primary-50"))) {
            $x("//div[contains(text(),'mon')]").click();
        }

        if ($x("//div[contains(text(),'tue')]").has(cssClass("bg-primary-50"))) {
            $x("//div[contains(text(),'tue')]").click();
        }

        if ($x("//div[contains(text(),'wed')]").has(cssClass("bg-primary-50"))) {
            $x("//div[contains(text(),'wed')]").click();
        }

        if ($x("//div[contains(text(),'thu')]").has(cssClass("bg-primary-50"))) {
            $x("//div[contains(text(),'thu')]").click();
        }

        if ($x("//div[contains(text(),'fri')]").has(cssClass("bg-primary-50"))) {
            $x("//div[contains(text(),'fri')]").click();
        }
    }

    //Update Default Business Hour
    @Test(dependsOnMethods = "DeleteBusinessHr")
    public void GeneralBusinesshr() throws  InterruptedException{
        Thread.sleep(10000);
        businesshr.clickThreeDots("General Business Hour");
        businesshr.clickEditOption();
        DefaultBusinessHour();
    }
    //Configure Inside business Hour
    @Test(dependsOnMethods = "GeneralBusinesshr")
    public void Arya() throws  InterruptedException{
        businesshr.clickThreeDots("Arya Stark Business Hour");
        businesshr.clickEditOption();
        businesshr.monfromtime.setValue("09:00");
        businesshr.montotime.setValue("17:00");
        businesshr.Tuefromtime.setValue("09:00");
        businesshr.Tuetotime.setValue("17:00");
        businesshr.wedfromtime.setValue("09:00");
        businesshr.wedtotime.setValue("17:00");
        businesshr.thurfromtime.setValue("09:00");
        businesshr.thurtotime.setValue("17:00");
        businesshr.Fridayfromtime.setValue("09:00");
        businesshr.FriTotime.setValue("17:00");
        Thread.sleep(3000);
        businesshr.btnSave.shouldBe(visible).click();
        businesshr.btnCancel.shouldBe(visible).click();
    }

    //Configure Outside business hour
    @Test(dependsOnMethods =  "Arya")
    public void NangHmu() throws InterruptedException
    {
        businesshr.clickThreeDots("NangHmu: Business Hour Setting");
        businesshr.clickEditOption();
        businesshr.monfromtime.setValue("09:00");
        businesshr.montotime.setValue("16:30");
        businesshr.tuefromtime.setValue("09:00");
        businesshr.Tuetotime.setValue("10:00");
        businesshr.wedfromtime.setValue("09:00");
        businesshr.wedtotime.setValue("10:00");
        businesshr.thurfromtime.setValue("09:00");
        businesshr.thurtotime.setValue("10:00");
        businesshr.Fridayfromtime.setValue("09:00");
        businesshr.FridayToTime.setValue("10:00");
        Thread.sleep(3000);
        businesshr.btnSave.shouldBe(visible).click();
        businesshr.btnCancel.shouldBe(visible).click();
    }

    //Select non-working days
    @Test(dependsOnMethods =  "NangHmu")
    public void NonWorkingDays() throws InterruptedException
    {
        businesshr.clickThreeDots("Working Hour In Myanmar");
        businesshr.clickEditOption();
        if ($x("//div[contains(text(),'mon')]").has(cssClass("bg-primary-50"))) {
            $x("//div[contains(text(),'mon')]").click();
            Thread.sleep(2000);
        }

        if ($x("//div[contains(text(),'tue')]").has(cssClass("bg-primary-50"))) {
            $x("//div[contains(text(),'tue')]").click();
            Thread.sleep(2000);
        }
        businesshr.wedfromtime.setValue("09:00");
        businesshr.wedtotime.setValue("17:00");
        businesshr.thurfromtime.setValue("09:00");
        businesshr.ThurToTime.setValue("17:00");
        businesshr.Fridayfromtime.setValue("09:00");
        businesshr.FridayToTime.setValue("17:00");
        Thread.sleep(3000);
        businesshr.btnSave.shouldBe(visible).click();
        businesshr.btnCancel.shouldBe(visible).click();
    }

    //Select working days
    @Test(dependsOnMethods =  "NonWorkingDays")
    public void WorkingDays() throws InterruptedException
    {
        businesshr.clickThreeDots("NangHmu: Myanmar Thingyun");
        businesshr.clickEditOption();
        if ($x("//div[contains(text(),'mon')]").has(cssClass("bg-primary-50"))) {
            $x("//div[contains(text(),'mon')]").click();
            Thread.sleep(2000);
        }

        if ($x("//div[contains(text(),'tue')]").has(cssClass("bg-primary-50"))) {
            $x("//div[contains(text(),'tue')]").click();
            Thread.sleep(2000);
        }
        businesshr.monfromtime.setValue("09:00");
        businesshr.montotime.setValue("16:30");
        businesshr.Tuefromtime.setValue("09:00");
        businesshr.Tuetotime.setValue("17:00");
        Thread.sleep(3000);
        businesshr.btnSave.shouldBe(visible).click();
        businesshr.btnCancel.shouldBe(visible).click();
    }

    @Test(dependsOnMethods = "WorkingDays")
    public void AddHoliday() throws InterruptedException
    {
        businesshr.clickThreeDots("Holiday Suite");
        businesshr.clickEditOption();

       $$(".inline-flex.items-center.justify-center.whitespace-nowrap")
              .findBy(text("Holidays"))
              .click();

        $$(".gap-x-2.inline-flex.items-center.justify-center.whitespace-nowrap.font-medium")
                .findBy(text("+ Add holiday"))
                .click();

        $$("button[type='button'][aria-haspopup='dialog']")
                .findBy(text("Choose date"))
                 .shouldBe(visible).click();

        $("button[type='button'][data-state='open']").shouldBe(visible);  // Wait for date picker to fully open

        // Select Nov 14
        $$("div.calendar-day").findBy(text("14")).shouldBe(visible).click();

        // Open the date picker again for Nov 15
        $("button[type='button'][aria-haspopup='dialog']")
                .shouldBe(visible)
                .click();

        $("button[type='button'][data-state='open']").shouldBe(visible);  // Wait for date picker to fully open

        // Select Nov 15
        $$("div.calendar-day").findBy(text("15")).shouldBe(visible).click();

        // Click "Nov 15"

        Thread.sleep(3000);
        businesshr.btnSave.shouldBe(visible).click();
        businesshr.btnCancel.shouldBe(visible).click();

    }
}