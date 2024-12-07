/*
package base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

public class TestBase {
    public static String url = "https://app-uat.klink.cloud/";
    public static String username = "saw@klink.cloud";
    public static String password = "password";

    public void Initialization() {
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("excludeSwitches", new String[]{"enable-automation"});
        options.addArguments("--disable-notifications"); // Use ChromeOptions to disable notifications

        try {
            System.out.println("Initializing WebDriver with Selenide...");
            Configuration.browser = "chrome"; // Use Chrome browser
            Configuration.browserCapabilities = options; // Set ChromeOptions as browser capabilities
            Configuration.timeout = 10000; // Set timeout for Selenide commands
            com.codeborne.selenide.Selenide.open(url); // Open the URL using Selenide
            System.out.println("WebDriver initialized successfully with Selenide.");
        } catch (Exception e) {
            System.err.println("Error during WebDriver initialization: " + e.getMessage());
            throw e;
        }
    }
}
*/

package base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBase {
    public static WebDriver driver;
    public static String url = "https://app-uat.klink.cloud/";
    public static String username = "saw@klink.cloud";
    public static String password = "password";

    public void Initialization() {
        if (driver == null) { // Check to avoid multiple initializations
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--disable-notifications");
            driver = new ChromeDriver(options);
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            driver.manage().window().maximize();
            driver.get(url);
        }
    }
}


