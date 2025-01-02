package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class SignifyBrowserRunner {
    @BeforeTest (description = "Configuration browser before test")
    public void SetUp(){
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        open("https://portal.signifyapp.com/");
    }

    @AfterTest (description = "Clear cookies and close WebDriver")
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

}