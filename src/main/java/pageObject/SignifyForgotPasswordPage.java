package pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SignifyForgotPasswordPage {
    public SelenideElement
        forgotButton = $(byLinkText("დაგავიწყდა?")),
        errorMessage = $(by("role","alert")),
        sendLinkButton = $(byXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/form/div[3]/div/div/div/div/button")),
        emailInput = $(byXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/form/div[1]/div[1]/div/div[1]/div/div/input")),
        successMessage = $(byText("შეამოწმეთ ელ.ფოსტა"));
}