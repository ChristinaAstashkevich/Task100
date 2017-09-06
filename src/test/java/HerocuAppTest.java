import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Description;
import ru.yandex.qatools.allure.annotations.Stories;
import ru.yandex.qatools.allure.annotations.TestCaseId;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

@Listeners(Listener.class)
public class HerocuAppTest extends TestBase {

    @TestCaseId("HAT-1")
    @Description("Switch between frames")
    @Stories("iFrame")
    @Test
    public void iFrameTest() {
        open("https://the-internet.herokuapp.com/iframe");
        switchTo().innerFrame("mce_0_ifr");
        $("#tinymce").click();
        $("#tinymce").clear();
        switchTo().innerFrame("mce_0_ifr");
        $("#tinymce").setValue("Hello ");
        switchTo().defaultContent();
        $("#mceu_3>button").click();
        switchTo().innerFrame("mce_0_ifr");
        $("#tinymce").setValue("world!");
        $("#tinymce").shouldHave(text("Hello \uFEFFworld!"));
    }

    @TestCaseId("HAT-2")
    @Description("Alert dismiss")
    @Stories("Alert")
    @Test
    public void AlertDismissTest() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        $(byXpath("//*[contains(text(),'Click for JS Confirm')]")).click();
        dismiss();
        $("#result").shouldHave(text("You clicked: Cancel"));
    }

    @TestCaseId("HAT-3")
    @Description("Alert prompt text into input field on alert")
    @Stories("Alert")
    @Test
    public void AlertClickPromptTest() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        $(byXpath("//*[contains(text(),'Click for JS Prompt')]")).click();
        actions().sendKeys("test");
        confirm();
        $("#result").shouldHave(text("You entered: test"));
    }
}
