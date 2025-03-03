package testcases;

import com.codeborne.selenide.Condition;
import static com.codeborne.selenide.Selenide.*;

import java.util.Map;

public class BusinessHoursInput {

    // Map to hold the start and end times for each day
    public final Map<String, String[]> insidebusinesshr = Map.of(
            "Monday", new String[]{"09:00", "11:00", "08:00", "09:00", "09:00", "10:00", "06:00", "07:00", "02:00", "03:00"});

    public final Map<String, String[]> outsidebusinesshr = Map.of(
            "Monday", new String[]{"10:00", "11:00", "10:00", "11:00", "10:00", "11:00", "08:00", "09:00", "04:00", "05:00"}
    );

    // Modified to accept a day and corresponding times for a particular case
    public void setWorkingHours(String day, Map<String, String[]> dayTimes) {
        // Get the times for the specific day (e.g., "Outside Business hour")
        String[] times = dayTimes.get(day);

        if (times != null) {
            setDayWorkingHours(day, times);
        } else {
            System.out.println("No times found for the day: " + day);
        }
    }

    //add comment here if you have something to add script
    private void setDayWorkingHours(String day, String[] times) {
        // Locate the div containing the day and update the corresponding time inputs
        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(2).setValue(times[2]);
        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(3).setValue(times[3]);

        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(4).setValue(times[4]);
        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(5).setValue(times[5]);

        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(6).setValue(times[6]);
        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(7).setValue(times[7]);

        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(8).setValue(times[8]);
        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(9).setValue(times[9]);

        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(11).setValue(times[11]);
        $$("div").findBy(Condition.text(day))
                .findAll("input[type='time']")
                .get(12).setValue(times[12]);
    }

    public static void main(String[] args) {
        BusinessHoursInput hr = new BusinessHoursInput();

        // Call the method with the specific "Outside Business hour" day and its times
        hr.setWorkingHours("days", hr.insidebusinesshr);
        hr.setWorkingHours("days",hr.outsidebusinesshr);
    }
}
