package base;

import config.Configuration;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;
import java.util.Properties;

public class TestBase {
    public static Properties prop;
    public static WebDriver driver;

    //    public TestBase() throws FileNotFoundException {
//    prop=new Properties();
//
//    FileInputStream ip=new FileInputStream("/Users/macbookpro/Downloads/klinkcloud_July09/src/test/java/com/klinkcloud/config/config.properties");
//        try {
//        prop.load(ip);
//    } catch (
//    IOException e) {
//        // TODO Auto-generated catch block
//        e.printStackTrace();
//    }
//}
    public static String url ="https://app-uat.klink.cloud/";;
    public static String username ="saw@klink.cloud";
    public static String password = "password";
    Configuration config = new Configuration(url, username, password);

    public void Initialization() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10000));
       // driver.manage().deleteAllCookies();
        driver.get(url);

    }
}
