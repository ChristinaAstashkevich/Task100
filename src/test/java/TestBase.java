import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.Selenide.close;

public class TestBase {

    static WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void browserOpen() {
        System.setProperty("webdriver.chrome.driver", ".\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        WebDriverRunner.setWebDriver(driver);
        //WebDriverRunner.getWebDriver(driver);
    }

    @AfterMethod
    public void browserClose() {
        close();
    }
}
