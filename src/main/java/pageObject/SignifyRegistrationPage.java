package pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SignifyRegistrationPage {
    public SelenideElement
        registrationButton = $(byLinkText("დარეგისტრირდი უფასოდ")),
        personalAccountRadio = $(byXpath("(//div[@class='radioButton'])[1]")),
        nameInput = $(byXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[2]/div[1]/div/div[1]/div/div/input")),
        emailInput = $(byXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[3]/div[1]/div/div[1]/div/div/input")),
        countryCodeChange = $(byXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[4]/div[1]/div/div[1]/div/div/span/span/div/div/div/div/div/div/div")),
        countryCodeSearch = $(by("data-testid", "country-code-search-input")),
        countryCodeConfirm = $(byXpath("/html/body/div[3]/div/div/div/div[2]/div/div/div/div")),
        mobileNumberInput = $(byXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[4]/div[1]/div/div[1]/div/div/span/input")),
        passwordInput = $(byXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[5]/div[1]/div/div/div/div/div/div/span/input")),
        repeatPasswordInput = $(byXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[5]/div[2]/div/div/div/div/div/div/span/input")),
        marketingRadio = $("#allowMarketingCommunication"),
        signUpConfirmButton = $(byXpath("/html/body/div[1]/div/div/div[1]/div[1]/div[3]/div/div/div/form/div[8]/div/div/div/div/button")),
        successMessage = $(".success-message");
}
