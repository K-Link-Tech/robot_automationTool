package testcases;

import base.TestBase;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.testng.annotations.*;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Selenide.open;
import static pages.BusinessHour.*;

public class BusinessHourTest extends TestBase {
    public static SelenideElement buttonEditSave = $x("//*[@id='edit_save_btn']");
    public static SelenideElement workingdaySave = $x("//*[@id='edit_save_btn']");
    public static SelenideElement btnOutsidebusinessHr = $x("//*[@id='edit_save_btn']");

    @BeforeSuite
    public void setUp() {
        open(url);
    }

    @AfterSuite
    public void tearDown() {
        closeWebDriver();
    }

    public static void DefaultBusinessHour(String starttime, String endtime) throws InterruptedException
    {
        setBusinessHours(starttime,endtime);
        ClickSaveButton();
    }

    public static void clickCreateNewButton(String BusinessHrName, String Desc) throws InterruptedException {
        Thread.sleep(10000);
        $(By.xpath("//button[@class='gap-x-2 inline-flex items-center justify-center whitespace-nowrap font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring active:translate-y-[1px] focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 text-white bg-primary-500 hover:bg-primary-700 active:bg-primary-900 disabled:bg-gray-400 disabled:text-gray-100 py-2 px-4 text-sm rounded-md']")).click();
        inputName.shouldBe(visible).setValue(BusinessHrName);
        inputDesc.shouldBe(visible).setValue(Desc);
        DefaultBusinessHour("09:00","17:00");
    }

    public static void ClickSaveButton() throws InterruptedException
    {
        Thread.sleep(10000);
        $(By.xpath("//button[@class='gap-x-2 inline-flex items-center justify-center whitespace-nowrap font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring active:translate-y-[1px] focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 text-white bg-primary-500 hover:bg-primary-700 active:bg-primary-900 disabled:bg-gray-400 disabled:text-gray-100 py-2 px-4 rounded-md text-sm']")).should(enabled).click();
    }

   @Test
    public static void AddBusinessHr() throws  InterruptedException{
        clickCreateNewButton("QA Test", "QA Desc");
        sleep(2000);
    }

    //Delete existing business hour (Optional) not required to execute this test suite every time.
    @Test(dependsOnMethods = "AddBusinessHr")
    public static void DeleteBusinessHr() throws InterruptedException
    {
        clickCreateNewButton("Deleted Testing", "Deleted Testing purpose");
        clickThreeDots("Deleted Testing");
        clickDeleteOption();
        sleep(2000);
        deleteButton.click();
        Thread.sleep(2000);
        switchTo().defaultContent();
    }
    //Update Default Business Hour
   @Test(dependsOnMethods = "DeleteBusinessHr")
    public static void GeneralBusinesshr() throws  InterruptedException{
        Thread.sleep(10000);
        clickThreeDots("General Business Hour");
        clickEditOption();
        DefaultBusinessHour("09:00","18:00");
    }

    //Select non-working days
    @Test(dependsOnMethods = "GeneralBusinesshr")
    public static void NonWorkingDays() throws InterruptedException {
        // Perform the required actions within the frame
        clickThreeDots("Working Hour In Myanmar");
        clickEditOption();

        // Check and unselect "Mon" if it is already selected
        if ($(".cursor-pointer", 1).has(cssClass("border-primary-500"))) {
            $(".cursor-pointer", 1).click();
            Thread.sleep(2000);
            System.out.println("Mon was selected and is now unselected.");
        }

        // Check and unselect "Tue" if it is already selected
        if ($(".cursor-pointer", 2).has(cssClass("border-primary-500"))) {
            $(".cursor-pointer", 2).click();
            Thread.sleep(2000);
            System.out.println("Tue was selected and is now unselected.");
        }
        //Add your nonworking test data as above code

        Thread.sleep(10000);
        switchTo().defaultContent();
        $(By.xpath("//button[@class='gap-x-2 inline-flex items-center justify-center whitespace-nowrap font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring active:translate-y-[1px] focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 text-white bg-primary-500 hover:bg-primary-700 active:bg-primary-900 disabled:bg-gray-400 disabled:text-gray-100 py-2 px-4 text-sm rounded-md']")).click();
    }

    //Select working days
    @Test(dependsOnMethods =  "NonWorkingDays")
    public static void WorkingDays() throws InterruptedException
    {
        clickThreeDots("NangHmu: Myanmar Thingyun");
        clickEditOption();
        // Check and unselect "Wed" if it is already selected
        if ($(".cursor-pointer", 3).has(cssClass("border-primary-500"))) {
            Thread.sleep(2000);
            $(".cursor-pointer", 3).click();
            System.out.println("Wed was selected and is now unselected.");
        }

        // Check and unselect "Thu" if it is already selected
        if ($(".cursor-pointer", 4).has(cssClass("border-primary-500"))) {
            Thread.sleep(2000);
            $(".cursor-pointer", 4).click();
            System.out.println("Thur was selected and is now unselected.");
        }
        //Add your nonworking test data as above code
        Thread.sleep(10000);
        workingdaySave.shouldBe(visible).click();
        switchTo().defaultContent();
    }

    //Add holidays --- Start
    @Test(dependsOnMethods = "WorkingDays")
    public static void AddHoliday() throws InterruptedException {
        // Navigate to the holiday suite and edit
        clickThreeDots("Holiday Suite");
        clickEditOption();
        //If need, add Thread.Sleep(5000) when not element found "Holidays
        Thread.sleep(7000);
        switchTo().defaultContent();
        $$(".inline-flex.items-center.justify-center.whitespace-nowrap")
                .findBy(text("Holidays"))
                        .shouldBe(visible, Duration.ofSeconds(100))
                                .click();

        // Wait for and click the "+ Add holiday" button
        SelenideElement addHolidayButton = $$(".gap-x-2.inline-flex.items-center.justify-center.whitespace-nowrap.font-medium")
                .findBy(text("+ Add holiday"));
        addHolidayButton.shouldBe(visible, Duration.ofSeconds(1000))  // Wait for visibility
                .shouldBe(enabled, Duration.ofSeconds(10)) // Ensure it is enabled
                .scrollIntoView(true)  // Ensure it's in the viewport
                .click();

        Thread.sleep(3000);
        SelenideElement chooseDateButton = $$("button[type='button'][aria-haspopup='dialog']")
                .findBy(text("Choose date"));
        chooseDateButton.shouldBe(visible, Duration.ofSeconds(10))  // Wait for the button to be visible
                .shouldBe(enabled, Duration.ofSeconds(10)) // Ensure it's clickable
                .click();

        // Wait for the button with data-state='open' to be visible
        $("button[type='button'][data-state='open']")
                .shouldBe(visible, Duration.ofSeconds(20))
                .click(); // Wait up to 10 seconds for visibility

        selectCalendarDays("24", "Nov Holiday");
        selectCalendarDays("25", "Nov 25");
        // Add holidays here for your test data
        ClickSaveButton();
        switchTo().defaultContent();
    }

    // Select calendar days dynamically
    public static void selectCalendarDays(String day, String HolidayName)  {
        // Wait for and click the "+ Add holiday" button
        SelenideElement addHolidayButton = $$(".gap-x-2.inline-flex.items-center.justify-center.whitespace-nowrap.font-medium")
                .findBy(text("+ Add holiday"));
        addHolidayButton.shouldBe(visible, Duration.ofSeconds(60))  // Wait for visibility
                .shouldBe(enabled, Duration.ofSeconds(60)) // Ensure it is enabled
                .scrollIntoView(true)  // Ensure it's in the viewport
                .click();

        // Wait for the dialog box to appear and click the "Choose date" button
        SelenideElement chooseDateButton = $$("button[type='button'][aria-haspopup='dialog']")
                .findBy(text("Choose date"));
        chooseDateButton.shouldBe(visible, Duration.ofSeconds(10))  // Wait for the button to be visible
                .shouldBe(enabled, Duration.ofSeconds(10)) // Ensure it's clickable
                .click();

        // Wait for the button with data-state='open' to be visible
        $("button[type='button'][data-state='open']")
                .shouldBe(visible, Duration.ofSeconds(10)); // Wait up to 10 seconds for visibility

        // Input calendar day and holiday name dynamically
        $(By.xpath("//button[@name='day' and contains(@class, 'rdp-button_reset') and text()='"+day+"']")).click();
        $(By.xpath("//input[@type='text' and contains(@class, 'focus:outline-none')]"))
                .setValue(HolidayName)
                .pressEnter();
    }
    //Add holidays --- End

    //Configure Inside business Hour
  @Test(dependsOnMethods = "AddHoliday")
  public static void Arya() throws  InterruptedException {
        clickThreeDots("Arya Stark Business Hour");
        clickEditOption();
      CustomizedBusinessHr("09:00","17:00","09:00","17:00","09:00","17:00","09:00","17:00","09:00","17:00");
        switchTo().defaultContent();
        buttonEditSave.shouldBe(visible, Duration.ofSeconds(20));
        Thread.sleep(2000);
  }
    //Configure Outside business hour
   @Test(dependsOnMethods =  "Arya")
    public static void NangHmu() throws InterruptedException
    {
        clickThreeDots("NangHmu: Business Hour");
        clickEditOption();
        CustomizedBusinessHr("10:00","11:00","10:00","11:00","10:00","11:00","10:00","11:00","10:00","11:00");
        switchTo().defaultContent();
        btnOutsidebusinessHr.shouldBe(visible,Duration.ofSeconds(20));
        Thread.sleep(2000);
    }

    //Customize add test data for outside and inside business hour
    // Method to customize business hours
    public static void CustomizedBusinessHr (
            String monFrom, String monTo,
            String tueFrom, String tueTo,
            String wedFrom, String wedTo,
            String thurFrom, String thurTo,
            String friFrom, String friTo) throws InterruptedException {
        Thread.sleep(5000);
        // Switch to the default frame if necessary
        switchTo().defaultContent();

        // Set Monday's hours
        monFromTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(monFrom);
        monToTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(monTo);

        // Set Tuesday's hours
        tueFromTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(tueFrom);
        tueToTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(tueTo);

        // Set Wednesday's hours
        wedFromTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(wedFrom);
        wedToTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(wedTo);

        // Set Thursday's hours
        thurFromTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(thurFrom);
        thurToTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(thurTo);

        // Set Friday's hours
        friFromTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(friFrom);
        friToTime.shouldBe(visible, Duration.ofSeconds(10)).setValue(friTo);
    }

}