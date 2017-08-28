import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.*;

@Listeners(Listener.class)
public class HerocuAppTest extends TestBase {
    
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

    @Test
    public void AlertAcceptTest() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        $(byXpath("//*[contains(text(),'Click for JS Confirm')]")).click();
        dismiss();
        $("#result").shouldHave(text("You clicked: Cancel"));
    }

    @Test
    public void AlertClickPromptTest() {
        open("https://the-internet.herokuapp.com/javascript_alerts");
        $(byXpath("//*[contains(text(),'Click for JS Prompt')]")).click();
        actions().sendKeys("test");
        confirm();
        $("#result").shouldHave(text("You entered: test"));
    }
}
