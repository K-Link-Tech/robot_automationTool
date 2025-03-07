package testcases;

import base.TestBase;
import com.codeborne.selenide.Selenide;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.TicketField;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.open;

public class TicketFieldTest extends TestBase {
    private TicketField TicketField;

    @BeforeSuite
    public void setUp() {
        // Set up ChromeOptions for each test method to run in isolation
        open(url);
        TicketField = new TicketField();
    }

    @AfterSuite
    public void tearDown() {
        // Close the browser after each test to avoid conflicts
        Selenide.closeWebDriver();
    }

    @Test
    public void AddTicketFields() throws InterruptedException {
        TicketField.settingsMenu.click();
        TicketField.buttonTicketFields.click();
        TicketField.buttonAddNewCustomField.click();
        Thread.sleep(3000);

        // For Text SelectBox
        TicketField.inputName.setValue("Test1");
        Select TextSelectBox = new Select(TicketField.selectElement);
        TextSelectBox.selectByVisibleText("Text");
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);

        // For Testarea SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test2");
        Select TextareaSelectBox = new Select(TicketField.selectElement);
        TextareaSelectBox.selectByVisibleText("Textarea");
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);

        // For Date SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test3");
        Select DateSelectBox = new Select(TicketField.selectElement);
        DateSelectBox.selectByVisibleText("Date");
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);

        // For Select SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test4");
        Select SelectSelectBox = new Select(TicketField.selectElement);
        SelectSelectBox.selectByVisibleText("Select");
        TicketField.inputElement.setValue("Item");
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);

        // For link SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test5");
        Select LinkSelectBox = new Select(TicketField.selectElement);
        LinkSelectBox.selectByVisibleText("Link");
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);

        // For Attachment SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test6");
        Select AttachmentSelectBox = new Select(TicketField.selectElement);
        AttachmentSelectBox.selectByVisibleText("Attachment");
        TicketField.addPropertyButton.click();
        Thread.sleep(10000);

        // check Required when you submit the form
        // For Text SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test7");
        Select TextSelectBox2 = new Select(TicketField.selectElement);
        TextSelectBox2.selectByVisibleText("Text");
        // Click the checkbox to ensure it is checked
        if (!TicketField.checkbox.isSelected()) {
            TicketField.checkbox.click();   // Click the checkbox to check it
        }
        TicketField.addPropertyButton.click();
        Thread.sleep(10000);

        // For Testarea SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test8");
        Select TextareaSelectBox2 = new Select(TicketField.selectElement);
        TextareaSelectBox2.selectByVisibleText("Textarea");
        // Click the checkbox to ensure it is checked
        if (!TicketField.checkbox.isSelected()) {
            TicketField.checkbox.click();   // Click the checkbox to check it
        }
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);

        // For Date SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test9");
        Select DateSelectBox2 = new Select(TicketField.selectElement);
        DateSelectBox2.selectByVisibleText("Date");
        // Click the checkbox to ensure it is checked
        if (!TicketField.checkbox.isSelected()) {
            TicketField.checkbox.click();   // Click the checkbox to check it
        }
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);

        // For Select SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test10");
        Select SelectSelectBox2 = new Select(TicketField.selectElement);
        SelectSelectBox2.selectByVisibleText("Select");
        TicketField.inputElement.setValue("Item");
        // Click the checkbox to ensure it is checked
        if (!TicketField.checkbox.isSelected()) {
            TicketField.checkbox.click();   // Click the checkbox to check it
        }
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);

        // For link SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test11");
        Select LinkSelectBox2 = new Select(TicketField.selectElement);
        LinkSelectBox2.selectByVisibleText("Link");
        // Click the checkbox to ensure it is checked
        if (!TicketField.checkbox.isSelected()) {
            TicketField.checkbox.click();   // Click the checkbox to check it
        }
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);

        // For Attachment SelectBox
        TicketField.buttonAddNewCustomField.click();
        TicketField.inputName.setValue("Test12");
        Select AttachmentSelectBox2 = new Select(TicketField.selectElement);
        AttachmentSelectBox2.selectByVisibleText("Attachment");
        // Click the checkbox to ensure it is checked
        if (!TicketField.checkbox.isSelected()) {
            TicketField.checkbox.click();   // Click the checkbox to check it
        }
        TicketField.addPropertyButton.click();
        Thread.sleep(3000);
    }


    @Test(dependsOnMethods = "AddTicketFields")
    public void DisplayTicketFields() throws InterruptedException {
        TicketField.TicketLink.click();
        Thread.sleep(5000);
        TicketField.NewTicket.shouldBe(visible).click();
        Thread.sleep(6000);
        //executeJavaScript("window.scrollBy(0,1000)");
        // Locate the scrollable div
        // Locate the scrollable div using its data attribute

    }

}