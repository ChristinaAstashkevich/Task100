
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import ru.yandex.qatools.allure.annotations.Attachment;

//import static TestBase.driver;

public class Listener implements ITestListener {

    static WebDriver driver;

    @Attachment(value = "Attach screenshot ", type = "image/png")
    public static byte[] makeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    @Override
    public void onTestStart(ITestResult result) {
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        makeScreenshot();
    }

    @Override
    public void onTestFailure(ITestResult result) {

        makeScreenshot();
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        makeScreenshot();

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        makeScreenshot();
    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
    }
}
