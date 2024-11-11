package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class BusinessHour {
    public SelenideElement inputName = $("#name");

    public SelenideElement inputDesc = $("#desc");

    public SelenideElement Tuefromtime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[2]/input");

    public SelenideElement TuesdayToTime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[3]/div/div[4]/div/div[2]/input");

    public SelenideElement WedFromTime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[4]/div/div[2]/div/div[2]/input");

    public SelenideElement WebToTime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[4]/div/div[4]/div/div[2]/input");

    public SelenideElement ThurFromTime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[5]/div/div[2]/div/div[2]/input");

    public SelenideElement ThurToTime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[5]/div/div[4]/div/div[2]/input");
    
    public SelenideElement FridayFromTime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[6]/div/div[2]/div/div[2]/input");

    public SelenideElement FridayToTime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[6]/div/div[4]/div/div[2]/input");

    public SelenideElement btnSave = $x("//button[@class='gap-x-2 inline-flex items-center justify-center whitespace-nowrap font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring active:translate-y-[1px] focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 text-white bg-primary-500 hover:bg-primary-700 active:bg-primary-900 disabled:bg-gray-400 disabled:text-gray-100 py-2 px-4 rounded-md text-sm']");
    public SelenideElement btnCancel = $("button[class='gap-x-2 inline-flex items-center justify-center whitespace-nowrap font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring active:translate-y-[1px] focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 text-primary-700 hover:bg-primary-25 active:bg-primary-50 disabled:text-primary-200 py-2 px-4 rounded-md border border-gray-300 text-sm']");

    //Delete confirmation dialog
    public SelenideElement deleteButton = $$(".gap-x-2.inline-flex.items-center.justify-center")
            .findBy(Condition.text("Delete"));

    // backup web element -- Start

    public SelenideElement Monfromtime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[2]/div/div[2]/div/div[2]/input");
    public SelenideElement montotime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[2]/div/div[4]/div/div[2]/input");

    public SelenideElement tuefromtime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[3]/div/div[2]/div/div[2]/input");
    public SelenideElement Tuetotime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[3]/div/div[4]/div/div[2]/input");

    public SelenideElement Thurfromtime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[5]/div/div[2]/div/div[2]/input");
    public SelenideElement thurtotime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[5]/div/div[4]/div/div[2]/input");

    public SelenideElement Fridayfromtime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[6]/div/div[2]/div/div[2]/input");
    public SelenideElement FriTotime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[6]/div/div[4]/div/div[2]/input");

    public SelenideElement buttonSaveChange2 = $("button[class='gap-x-2 inline-flex items-center justify-center whitespace-nowrap font-medium ring-offset-background transition-colors focus-visible:outline-none focus-visible:ring-2 focus-visible:ring-ring active:translate-y-[1px] focus-visible:ring-offset-2 disabled:pointer-events-none disabled:opacity-50 text-white bg-primary-500 hover:bg-primary-700 active:bg-primary-900 disabled:bg-gray-400 disabled:text-gray-100 py-2 px-4 rounded-md text-sm']");

    public SelenideElement wedfromtime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[4]/div/div[2]/div/div[2]/input");
    public SelenideElement wedtotime = $x("/html/body/div[1]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div/div/form/div[4]/div[2]/div/div[2]/div/div[4]/div/div[4]/div/div[2]/input");


    // backup web element -- End

    //Inside/Outside business hour  -- Start
    public void clickThreeDots(String businessHourName) {
        $(By.xpath("//p[contains(text(), '" + businessHourName + "')]/ancestor::div[contains(@class, 'w-4/6')]/following-sibling::div//button"))
                .shouldBe(visible)
                .click();
    }

    public void clickEditOption() {
        $(By.xpath("//span[text()='Edit']"))
                .shouldBe(visible)
                .click();
    }

    public void clickDeleteOption() {
        $(By.xpath("//span[text()='Delete']"))
                .shouldBe(visible)
                .click();
    }
    //Inside/Outside business hour -- End
    
    //Holiday datetime picker -- Start
    public SelenideElement datetimepicker = $("html > body > div:nth-of-type(3) > div > div > div > div > table > tbody > tr:nth-of-type(3) > td:nth-of-type(5)");
    //Holiday datetime picker -- End
}