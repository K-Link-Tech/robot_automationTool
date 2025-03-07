package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class OldFlowTelephony {
    public SelenideElement showMenu = $x("/html/body/div[3]/div[2]/div[2]/div[1]/div[1]/button");
    public SelenideElement mainMenuContact = $x("/html/body/div[3]/div[2]/div[1]/div[2]/nav/div[6]/div[1]");
    public SelenideElement subMenuContact = $x("//a//span[text()='Contacts']");
    public SelenideElement dashboard = $x("/html/body/div[3]/div[2]/div[1]/div[2]/nav/div[1]/a");
    public SelenideElement phoneIcon = $x("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/button[1]");
    public SelenideElement OpenCallTab = $x("//button[text()='Open call tab']");
    public SelenideElement PhoneNumber = $x("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/input");
    public SelenideElement btnCall = $x("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div/div[1]/div[2]/div/button[4]");
    public SelenideElement btnPhoneBar = $("button div.flex.cursor-pointer.items-center");
    //public SelenideElement editContactButton = $x("/html/body/div[8]/div/div/button[2]");
    public SelenideElement editContactButton = $x("/html/body/div[8]/div/div/button[2]");
    public SelenideElement inputField = $x("/html/body/div[8]/div/div/form/div[1]/div/div[1]/input");
    public SelenideElement selectElement = $x("/html/body/div[8]/div/div/form/div[2]/div/div/select");
    public SelenideElement save = $x("/html/body/div[8]/div/div/form/div[3]/button[2]");
    public SelenideElement select = $x("/html/body/div[9]/form/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div/select");
    public SelenideElement scrollDiv = $x("/html/body/div[9]/form/div/div[2]/div[1]/div/div[2]");
    public SelenideElement select2 = $x("/html/body/div[9]/form/div/div[2]/div[1]/div/div[2]/div[26]/div[2]/div/div/select");
    public SelenideElement complete = $("button.bg-primary-500.text-white");
    public SelenideElement btnAnswer = $x("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]");
    public SelenideElement iconSearch = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]");
    public SelenideElement inputPhoneNumber = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div[2]/div[1]/div/div[1]/input");
}