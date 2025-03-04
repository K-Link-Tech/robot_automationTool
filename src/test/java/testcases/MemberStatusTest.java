package testcases;

import base.TestBase;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.Keys;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.MemberStatus;

import java.time.Duration;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.executeJavaScript;

public class MemberStatusTest extends TestBase {
    private MemberStatus MemberStatus;

    @BeforeSuite
    public void setUp() {
        MemberStatus = new MemberStatus();
    }

    //command aftersuite
    @AfterSuite
    public void tearDown() {
        // Close the browser after each test to avoid conflicts
        Selenide.closeWebDriver();
    }

    @Test
    public void insertMemberStatus() throws InterruptedException {
        // Maximize the window
        Selenide.webdriver().driver().getWebDriver().manage().window().maximize();

        MemberStatus.showMenu.click();
        MemberStatus.settingMenu.click();
        MemberStatus.memberStatusMenu.click();
        Thread.sleep(2000);
        // add member status
        addMemberStatus("ramen", "Lunch Test","Take a break for meal",false,true);
        addMemberStatus("grin", "Off Work Test","Can receive Only Call notifications",true,true);
        addMemberStatus("mask","Sick Leave Test","I'm not able to receive any notifications.",false,false);
        addMemberStatus("melting face","Night shift Test","can do everything updated",true,true);
        addMemberStatus("no entry","Away Test","Can't receive all notifications",false,false);
        addMemberStatus("framed picture","Business Trip Test","Can receive only message notifications",false,true);
        addMemberStatus("mountain railway","On Vacation Test","Can't receive all notifications.",true,true);
        addMemberStatus("woman technologist","Meeting Test","In a Meeting - Able to Text Message",false,true);
        addMemberStatus("no entry sign","Do not distrub (DND) Test","Can't receive all notifications",false,false);
        addMemberStatus("star-struck","Annual Leave Test","30 days leave",true,false);
        addMemberStatus("sushi","Breakfast Test","can receive phone call",false,true);
        addMemberStatus("receipt","Embassy Test","Thai Embassy going",false,true);
        addMemberStatus("airplane","Flight Test","At air port",false,true);
        addMemberStatus("sun with face","Day shift Test","Ah shit here we go again",false,true);
        // Scrolling to view added member status
        MemberStatus.scrollBtn.scrollIntoView(true);
        executeJavaScript("arguments[0].scrollTop = arguments[0].scrollHeight", MemberStatus.scrollBtn);
        Thread.sleep(3000);
    }

    @Test(dependsOnMethods = "insertMemberStatus")
    public void searchAddedMemberStatus() throws InterruptedException {
        searchMemberStatus("Sick Leave Test");
    }

    @Test(dependsOnMethods = "searchAddedMemberStatus")
    public void editMemberStatusTest() throws InterruptedException {
        addMemberStatus("innocent","Edit Test","Ah shit here we go again",true,true);
        editMemberStatus("Edit Test","Update edit Test","Edit Ah shit here we go again",false,false);
        searchMemberStatus("Update edit Test");
    }

    @Test(dependsOnMethods = "editMemberStatusTest")
    public void cancelMemberStatus() throws InterruptedException {
        MemberStatus.addNewBtn.click();
        Thread.sleep(1000);
        MemberStatus.cancelBtn.click();
        Thread.sleep(1000);
    }

    @Test(dependsOnMethods = "cancelMemberStatus")
    public void updateMemberStatusNameAndCheckProfile() throws InterruptedException {
        clickUserIconAndSelectStatus("Lunch Test");
        Thread.sleep(2000);
        updateMemberStatusName("Lunch Test","Work Lunch Test");
        MemberStatus.userIcon.click();
        Thread.sleep(5000);
        updateEmoji("Work Lunch Test","heart eyes");
        MemberStatus.userIcon.click();
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = "updateMemberStatusNameAndCheckProfile")
    public void agentStatusCheck() throws InterruptedException {
        MemberStatus.agentStatusMenu.click();
        Thread.sleep(1000);
        MemberStatus.changePageBtn.click();
        MemberStatus.agentStatusBtn.click();
        MemberStatus.onVacationTest.click();
        clickUserIconAndSelectStatus("Meeting");
        Thread.sleep(10000);
        // Check Status LogHistory
        MemberStatus.reportingMenu.click();
        MemberStatus.agentStatusLogMenu.click();
        Thread.sleep(5000);
    }

    @Test(dependsOnMethods = "agentStatusCheck")
    public void agentStatusLogCheck() throws InterruptedException {
        clickUserIconAndSelectStatus("Away");
        Thread.sleep(2000);
        clickUserIconAndSelectStatus("Breakfast");
        Thread.sleep(2000);
        clickUserIconAndSelectStatus("Business Trip");
        Thread.sleep(2000);
        clickUserIconAndSelectStatus("Sick");
        Thread.sleep(2000);
        clickUserIconAndSelectStatus("Flight");
        Thread.sleep(2000);
    }

    // Analytics Dashboard Check
    @Test(dependsOnMethods = "agentStatusLogCheck")
    public void analyticsDashboardCheck() throws InterruptedException {
        MemberStatus.settingMenu.click();
        MemberStatus.memberStatusMenu.click();
        Thread.sleep(2000);

        // add member status
        addMemberStatus("surfer","New Test","insert new status for testing",false,true);

        // check member status in Analytics Dashboard
        checkAnalyticsDashboard("misssaw thiri");

        // delete added status
        MemberStatus.settingMenu.click();
        MemberStatus.memberStatusMenu.click();
        Thread.sleep(2000);
        deleteMemberStatus("New Test");

        // check member status in Analytics Dashboard
        checkAnalyticsDashboard("misssaw thiri");
    }

    @Test(dependsOnMethods = "analyticsDashboardCheck")
    public void deleteAddedMemberStatus() throws InterruptedException {
        MemberStatus.settingMenu.click();
        MemberStatus.memberStatusMenu.click();
        Thread.sleep(3000);

        // choose Lunch Test Status in Profile and can't delete Lunch Test
        clickUserIconAndSelectStatus("Flight");
        Thread.sleep(5000);
        deleteMemberStatus("Flight");
        MemberStatus.cancelBtn.click();

        // choose another "Meeting" member status
        clickUserIconAndSelectStatus("Meeting");

        // delete all new added member status
        deleteMemberStatus("Work Lunch Test");
        deleteMemberStatus("Update edit Test");
        deleteMemberStatus("Business Trip Test");
        deleteMemberStatus("Sick Leave Test");
        deleteMemberStatus("Away Test");
        deleteMemberStatus("On Vacation Test");
        deleteMemberStatus("Meeting Test");
        deleteMemberStatus("Do not distrub (DND) Test");
        deleteMemberStatus("Annual Leave Test");
        deleteMemberStatus("Off Work Test");
        deleteMemberStatus("Breakfast Test");
        deleteMemberStatus("Embassy Test");
        deleteMemberStatus("Night shift Test");
        deleteMemberStatus("Flight Test");
        deleteMemberStatus("Day shift Test");
    }

    @Test(dependsOnMethods = "deleteAddedMemberStatus")
    public void checkMemberStatusPhoneCall() throws InterruptedException {
        MemberStatus.settingMenu.click();
        MemberStatus.memberStatusMenu.click();

        // check enable phone call
        memberStatusPhoneCallCheck("Sick");

        // check phone call on
        memberStatusPhoneCallCheck("Off Work");
        setInboundTelephonyWithoutEdit();
        Thread.sleep(10000);
    }

    // add new member status
    public void addMemberStatus(String emoji, String StatusName, String description, boolean phoneCall, boolean chatMessage) throws InterruptedException {
        MemberStatus.addNewBtn.click();
        MemberStatus.emojiBox.click();
        //Thread.sleep(1000);
        MemberStatus.emojiInputBox.shouldBe(visible, Duration.ofSeconds(20)).setValue(emoji);
        //Thread.sleep(1000);
        SelenideElement emojiName = $$("[aria-label='" + emoji + "']").first();
        emojiName.click();
        Thread.sleep(1000);
        MemberStatus.statusNameInputBox.setValue(StatusName);
        MemberStatus.descriptionInputBox.setValue(description);
        if (phoneCall)
            MemberStatus.receivePhoneCall.click();

        if (chatMessage)
            MemberStatus.receiveChatMessage.click();

        MemberStatus.doneBtn.click();
        Thread.sleep(3000);
    }

    // edit new member status
    public void editMemberStatus(String statusName, String newStatusName, String description, boolean phoneCall, boolean chatMessage) throws InterruptedException {
        MemberStatus.searchInputBox.shouldBe(visible).setValue(statusName);
        Thread.sleep(1000);
        MemberStatus.editBtn.click();
        MemberStatus.editStatusNameInputBox.setValue(newStatusName);
        MemberStatus.editDescriptionInputBox.setValue(description);
        if (phoneCall)
            MemberStatus.editReceivePhoneCall.click();

        if (chatMessage)
            MemberStatus.editReceiveChatMessage.click();

        MemberStatus.updateBtn.click();
        Thread.sleep(3000);
    }

    // update member status name
    public void updateMemberStatusName(String statusName, String newStatusName) throws InterruptedException {
        MemberStatus.searchInputBox.shouldBe(visible).setValue(statusName);
        Thread.sleep(1000);
        MemberStatus.editBtn.click();
        MemberStatus.editStatusNameInputBox.setValue(newStatusName);
        MemberStatus.updateBtn.click();
        Thread.sleep(3000);
    }

    // update emoji
    public void updateEmoji(String statusName, String emoji) throws InterruptedException {
        MemberStatus.searchInputBox.shouldBe(visible).setValue(statusName);
        Thread.sleep(1000);
        MemberStatus.editBtn.click();
        MemberStatus.editEmojiBox.click();
        Thread.sleep(2000);
        MemberStatus.emojiInputBox.setValue(emoji);
        Thread.sleep(2000);
        SelenideElement emojiName = $$("[aria-label='" + emoji + "']").first();
        emojiName.click();
        Thread.sleep(1000);
        MemberStatus.updateBtn.click();
        Thread.sleep(3000);
    }

    //
    public void checkAnalyticsDashboard(String userName) throws InterruptedException {
        MemberStatus.analyticsDashboardMenu.click();
        MemberStatus.inboxBtn.click();
        Thread.sleep(3000);
        MemberStatus.viewDetailNonQueueBtn.click();
        MemberStatus.searchIcon.click();
        MemberStatus.searchInput.setValue(userName);
        Thread.sleep(3000);
        MemberStatus.viewDetailBtn.click();
        Thread.sleep(3000);
    }

    // check user member status
    public void clickUserIconAndSelectStatus(String statusName) throws InterruptedException {
        Thread.sleep(5000);
        MemberStatus.userIcon.click();
        Thread.sleep(5000);
        MemberStatus.profileStatusBtn.click();
        SelenideElement profileStatus = $$("p.text-sm.font-medium.capitalize.text-gray-600").findBy(text(statusName));
        profileStatus.click();
        MemberStatus.reasonBox.setValue("testing");
        MemberStatus.saveBtn.click();
    }

    // search added member status
    public void searchMemberStatus(String statusName) throws InterruptedException {
        MemberStatus.searchInputBox.shouldBe(visible).setValue(statusName);
        Thread.sleep(2000);
        // Ensuring text is cleared properly
        MemberStatus.searchInputBox.shouldBe(visible).sendKeys(Keys.chord(Keys.COMMAND, "a"), Keys.BACK_SPACE);
        MemberStatus.searchInputBox.setValue("");
        MemberStatus.searchInputBox.clear();
        Thread.sleep(1000); // Consider replacing with a wait strategy
    }

    // delete added member status
    public void deleteMemberStatus(String statusName) throws InterruptedException {
        MemberStatus.searchInputBox.shouldBe(visible).setValue(statusName);
        Thread.sleep(1000);
        MemberStatus.deleteIcon.click();
        MemberStatus.deleteBtn.click();
        Thread.sleep(2000);
    }

    // without edit contact name during the incoming call
    public void setInboundTelephonyWithoutEdit() throws InterruptedException {
        Thread.sleep(5000);
        MemberStatus.answerBtn.shouldBe(visible, Duration.ofSeconds(50)).click();
        Thread.sleep(10000);
        MemberStatus.selectBox.shouldBe(visible, Duration.ofSeconds(30)).selectOption("Other");
        MemberStatus.completeBtn.click();
    }

    // search added member status
    public void memberStatusPhoneCallCheck(String statusName) throws InterruptedException {
        MemberStatus.searchInputBox.shouldBe(visible).setValue(statusName);
        Thread.sleep(1000);
        MemberStatus.editBtn.click();
        Thread.sleep(2000);
        MemberStatus.statusCancelBtn.click();
        MemberStatus.memberStatusUserIcon.click();
        MemberStatus.profileStatusBtn.click();
        SelenideElement profileStatus = $$("p.text-sm.font-medium.capitalize.text-gray-600").findBy(text(statusName));
        profileStatus.click();
        MemberStatus.reasonBox.setValue("testing");
        MemberStatus.saveBtn.click();
        Thread.sleep(20000);
    }
}