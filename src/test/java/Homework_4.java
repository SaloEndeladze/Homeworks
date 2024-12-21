import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.SelenideElement;
import org.testng.annotations.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class Homework_4 {
    @Test
    public void facebookSignUp(){
        Configuration.browser = "edge";
        Configuration.browserSize = "1920x1080";

        open("https://www.facebook.com/");
        $(byLinkText("Create new account")).click();

        $(byName("firstname")).setValue("Salo");
        $(byName("lastname")).setValue("Endeladze");
        $(byName("birthday_month")).selectOption("Oct");
        $(byName("birthday_day")).selectOption("7");
        $(byName("birthday_year")).selectOption("1997");

        SelenideElement GenderRadio = $(byName("sex"));
        SelenideElement GenderOptional = $("#preferred_pronoun");
        SelenideElement CustomGender = $(byName("custom_gender"));

        GenderRadio.selectRadio("-1");
        GenderOptional.shouldBe(visible);
        CustomGender.shouldBe(visible);
        GenderOptional.selectOptionContainingText("She: \"Wish her a happy birthday!\"");

        GenderRadio.selectRadio("1");
        GenderOptional.shouldBe(disappear);
        CustomGender.shouldBe(disappear);
        $(byName("reg_email__")).setValue("salo.endeladze@gmail.com");
        $(byName("reg_passwd__")).setValue("Password123");
    }
}
