package utils;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import org.testng.annotations.*;

import static com.codeborne.selenide.Selenide.*;

public class RyanairBrowserRunner {
    @BeforeTest
    public void SetUp(){
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";
        open("https://www.ryanair.com/");
    }

    @AfterTest
    public void tearDown(){
        Selenide.clearBrowserCookies();
        Selenide.clearBrowserLocalStorage();
        Selenide.closeWindow();
        Selenide.closeWebDriver();
    }

}