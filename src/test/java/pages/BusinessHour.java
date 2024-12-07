package pages;

import base.Logger;
import com.codeborne.selenide.*;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import java.time.Duration;
import java.util.NoSuchElementException;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class BusinessHour {
    public static SelenideElement inputName = $("#name");

    public static SelenideElement inputDesc = $("#desc");
    // backup web element -- Start
    // Declare Selenide elements (initialize them with correct locators)
    public static final SelenideElement monFromTime =$("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)");
    public static final SelenideElement monToTime = $("body > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > form:nth-child(2) > div:nth-child(4) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(4) > div:nth-child(1) > div:nth-child(2) > input:nth-child(2)");
    public static final SelenideElement tueFromTime =  $("input[name='tue-from-time']");
    public static final SelenideElement tueToTime = $("input#tue-to-time");
    public static final SelenideElement wedFromTime = $("input#wed-from-time");
    public static final SelenideElement wedToTime = $("input#wed-to-time");
    public static final SelenideElement thurFromTime = $("input#thur-from-time");
    public static final SelenideElement thurToTime = $("input#thur-to-time");
    public static final SelenideElement friFromTime = $("input#fri-from-time");
    public static final SelenideElement friToTime = $("input#fri-to-time");
    // backup web element -- End

    //Delete confirmation dialog
    public static SelenideElement deleteButton = $$(".gap-x-2.inline-flex.items-center.justify-center")
            .findBy(text("Delete"));

    // Find start time & end time by div day names -- Start
    public static void setBusinessHours(String starttime, String endtime)  {
        String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
        Configuration.timeout = 20000; // Increase default timeout

        // Wait for grid to load with retries
        boolean gridLoaded = false;
        int retries = 3;
       while (retries > 0 && !gridLoaded) {
            try {
                Wait().until(webDriver -> $$("div.mt-4.grid").size() > 0);
                gridLoaded = true;
            } catch (TimeoutException e) {
                Logger.logError("Grid not loaded, retrying...");
                Selenide.sleep(3000); // Retry delay
                retries--;
            }
        }

       if (!gridLoaded) {
            throw new IllegalStateException("Failed to load grid after retries.");
        }

        for (String day : days) {
            Logger.log("Processing row for: " + day);

            try {
                boolean success = retryInteraction(() -> {
                    // Locate the day row dynamically
                    SelenideElement dayRow = $$("div.mt-4.grid").filterBy(Condition.text(day)).first();
                    if (dayRow == null || !dayRow.exists()) {
                        throw new NoSuchElementException("Day row not found for: " + day);
                    }

                    Logger.log("Found row for " + day);

                    // Locate and interact with time inputs
                    ElementsCollection timeInputs = dayRow.$$("input[type='time']");
                    Logger.log("Number of time inputs found for " + day + ": " + timeInputs.size());

                    if (timeInputs.size() < 2) {
                        throw new IndexOutOfBoundsException("Expected at least 2 time inputs, found: " + timeInputs.size());
                    }
                    timeInputs.get(0).shouldBe(Condition.visible, Duration.ofSeconds(30)).setValue(starttime);
                    timeInputs.get(1).shouldBe(Condition.visible, Duration.ofSeconds(30)).setValue(endtime);
                });

                if (!success) {
                    Logger.logError("Failed to process row for: " + day);
                }
            } catch (IndexOutOfBoundsException e) {
                Logger.logError("IndexOutOfBoundsException for " + day + ": " + e.getMessage());
                // Continue to the next day
            } catch (NoSuchElementException e) {
                Logger.logError("NoSuchElementException for " + day + ": " + e.getMessage());
                // Continue to the next day
            } catch (Exception e) {
                Logger.logError("Unexpected error while processing " + day + ": " + e.getMessage());
                // Continue to the next day
            }
        }
    }

    private static boolean retryInteraction(Runnable interaction) {
        int retries = 3;
        while (retries > 0) {
            try {
                interaction.run();
                return true; // Success, exit loop
            } catch (StaleElementReferenceException e) {
                Logger.logError("Stale element detected. Retrying...");
                Selenide.sleep(2000); // Wait before retrying
                retries--;
            } catch (NoSuchElementException e) {
                Logger.logError("Element not found during interaction: " + e.getMessage());
                return false; // Abort retries for missing element
            }
        }
        return false; // All retries failed
    }

    // Find start time & end time by div day names -- End

    //Inside/Outside business hour  -- Start
    public static void clickThreeDots(String businessHourName) {
        $(By.xpath("//p[contains(text(), '" + businessHourName + "')]/ancestor::div[contains(@class, 'w-4/6')]/following-sibling::div//button"))
                .shouldBe(visible, Duration.ofSeconds(60))
                .click();
    }

    public static void clickEditOption() {
        $(By.xpath("//span[text()='Edit']"))
                .shouldBe(visible)
                .click();
    }

    public static void clickDeleteOption() {
        $(By.xpath("//span[text()='Delete']"))
                .shouldBe(visible)
                .click();
    }
    //Inside/Outside business hour -- End
}