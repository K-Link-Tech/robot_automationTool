
package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class PhoneCall {
    public SelenideElement btnPhone = $x("//*[@id=\"root\"]/div[2]/div[2]/div[1]/div[2]/button[1]/button");
    public SelenideElement button = $("button.bg-primary-500");
    public SelenideElement inputName = $x("//*[@id=\"call-nav-bar\"]/div/div[1]/input");
    public SelenideElement btnCall = $x("//*[@id=\"call-nav-bar\"]/div/div[1]/div[2]/div/button[4]");
    public SelenideElement btnContact = $x("//*[@id=\"root\"]/div[2]/div[1]/div[2]/nav/div[5]/div[1]/div[2]");
    public SelenideElement contacts = $x("//a//span[text()='Contacts']");
    public SelenideElement btnDelete = $x("//*[@id=\"root\"]/div[2]/div[2]/div[2]/div[1]/div[2]/div/div/div/div/table/tbody/tr[1]/td[23]/div/button[2]");
    public SelenideElement buttonDeleteConfirm = $x("//button[text()='Delete']");

    // Uses XPath to select the button by its text.
}