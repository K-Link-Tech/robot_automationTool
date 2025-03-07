package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MemberStatus {
    // xpath for insertMemberStatus()
    public SelenideElement showMenu = $x("/html/body/div[3]/div[2]/div[2]/div[1]/div[1]/button");
    public SelenideElement settingMenu = $x("/html/body/div[3]/div[2]/div[1]/div[2]/nav/div[12]/a");
    public SelenideElement memberStatusMenu = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[4]/div/a[4]");
    public SelenideElement addNewBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[1]/button");
    public SelenideElement statusNameInputBox = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[1]/div/div[1]/input");
    public SelenideElement descriptionInputBox = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[2]/div[1]/input");
    public SelenideElement doneBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[4]/button[1]");
    public SelenideElement scrollBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]");
    public SelenideElement receivePhoneCall = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[2]/div[1]/button");
    public SelenideElement receiveChatMessage = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[3]/div[1]/button");

    // xpath for searchAddedMemberStatus()
    public SelenideElement searchInputBox = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[1]/div/div[1]/input");

    // xpath for editMemberStatus()
    public SelenideElement editStatusNameInputBox = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[1]/div[1]/div/div[1]/input");
    public SelenideElement editDescriptionInputBox = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[1]/div[2]/div[1]/input");
    public SelenideElement editReceivePhoneCall = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[2]/div[1]/button");
    public SelenideElement editReceiveChatMessage = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[3]/div[1]/button");
    public SelenideElement updateBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[4]/button[1]");


    //  xpath for agentStatusCheck()
    public SelenideElement agentStatusMenu = $x("/html/body/div[3]/div[2]/div[1]/div[2]/nav/div[10]/a");
    public SelenideElement changePageBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div[1]/div[2]/div[2]/div[2]/button[2]");
    public SelenideElement agentStatusBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div[1]/div[1]/div/div/div/div/table/tbody/tr[15]/td[5]/button");
    public SelenideElement onVacationTest = $$("div.text-sm.capitalize.text-gray-900").findBy(text("On Vacation Test"));
    public SelenideElement userIcon = $x("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/button[2]");
    public SelenideElement profileStatusBtn = $("button:has(svg.fill-current.text-gray-600)");
    public SelenideElement reportingMenu = $x("/html/body/div[3]/div[2]/div[1]/div[2]/nav/div[11]/div[1]");
    public SelenideElement agentStatusLogMenu = $x("/html/body/div[3]/div[2]/div[1]/div[2]/nav/div[11]/div[2]/div[4]/a");

    // xpath for analyticsDashboardCheck()
    public SelenideElement analyticsDashboardMenu = $x("/html/body/div[3]/div[2]/div[1]/div[2]/nav/div[2]/a");
    public SelenideElement inboxBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[1]/div/div[2]");
    public SelenideElement viewDetailNonQueueBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[2]/div/div[2]/div[1]/div/div[1]/button");
    public SelenideElement searchIcon = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div/div[2]/div[6]/div/div[1]/div/div");
    public SelenideElement searchInput = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div/div[2]/div[6]/div/div[1]/div/div/div/div[1]/input");
    public SelenideElement viewDetailBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div/div/div[2]/div[6]/div/div[2]/div[1]/div[1]/div/div/div/div/table/tbody/tr[2]/td[6]/button");

    // xpath for deleteMemberStatus()
    public SelenideElement reasonBox = $("[placeholder='Write a reason']");
    public SelenideElement saveBtn = $$x("//button[text()='Save']").first();
    public SelenideElement deleteIcon = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div/div[2]/button[2]");
    public SelenideElement deleteBtn = $(".hover\\:bg-error-700");
    public SelenideElement cancelBtn = $("button.text-gray-700.border-gray-400");

    // xpath for checkMemberStatusPhoneCall()
    public SelenideElement editBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div/div[2]/button[1]");
    public SelenideElement statusCancelBtn = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[4]/button[2]");
    public SelenideElement memberStatusUserIcon = $x("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/button[2]");
    public SelenideElement answerBtn = $x("/html/body/div[3]/div[2]/div[2]/div[1]/div[2]/div[1]/div[2]/button[1]");
    public SelenideElement selectBox = $x("/html/body/div[8]/form/div/div[2]/div[1]/div/div[2]/div[2]/div[2]/div/div/select");
    public SelenideElement completeBtn = $x("/html/body/div[8]/form/div/div[3]/button[2]");

    // xpath for emoji
    public SelenideElement emojiBox = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div/div[1]/div[1]/button");
    public SelenideElement editEmojiBox = $x("/html/body/div[3]/div[2]/div[2]/div[2]/div/div[3]/div/div[2]/div[2]/div/div[1]/div[1]/button");
    public SelenideElement emojiInputBox = $x("/html/body/div[8]/div/aside/div[1]/div[1]/div[1]/input");
    //public SelenideElement emojiIcon = $x("/html/body/div[8]/div/aside/div[2]/ul/li[3]/div/button[2]");
    //public SelenideElement smile = $$("[data-full-name='grinning,grinning face']").first();
}
