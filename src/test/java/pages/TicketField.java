
package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TicketField {

    public SelenideElement settingsMenu = $x("//a[@href='/9ba7ce21-d284-4973-8402-08a4829e37e5/settings']");
    public SelenideElement buttonTicketFields = $x("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div/div[1]/div/a[1]");
    public SelenideElement buttonAddNewCustomField = $x("//button[text()='Add new custom field']");
    public SelenideElement inputName = $("input[name='name']");
    public SelenideElement selectElement = $x("//select");
    public SelenideElement addPropertyButton = $("button[type='submit']");
    public SelenideElement inputElement = $("input[placeholder='Enter item']");
    public SelenideElement checkbox = $("input[type='checkbox'][name='isRequired']");
    public SelenideElement TicketLink = $x("//*[@id=\"root\"]/div[2]/div[1]/div[2]/nav/div[4]/a");
    public SelenideElement NewTicket = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div[2]/a");
    // Uses XPath to select the button by its text.

}

