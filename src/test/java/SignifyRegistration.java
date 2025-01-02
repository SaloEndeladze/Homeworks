import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.Assert;
import org.testng.annotations.Test;
import stepObject.SignifyRegistratioPageSteps;
import utils.SignifyBrowserRunner;

import static com.codeborne.selenide.Condition.*;
import static dataObject.SignifyRegistrationPageData.*;

public class SignifyRegistration extends SignifyBrowserRunner {
    SignifyRegistratioPageSteps signifyRegistratioPageSteps = new SignifyRegistratioPageSteps();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Personal account sign up test case on Signify(with hard assert)")
    public void successRegistration(){
        signifyRegistratioPageSteps
                .goToRegistration()
                .choosePersonalAccount()
                .nameField(name)
                .emailField(email)
                .countryCodeChange()
                .countryCodeSearchInput(country)
                .countryCodeConfirm()
                .mobileField(mobileNumber)
                .passwordField(password)
                .repeatPasswordField(repeatPassword)
                .denyMarketingCommunication()
                .clickOnSignUp();
        Assert.assertTrue(signifyRegistratioPageSteps.successMessage.shouldBe(visible).is(visible));
    }

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description("Personal account sign up test case on Signify(without hard assert)")
    public void successRegistrationSecondMethod(){
        signifyRegistratioPageSteps
                .goToRegistration()
                .choosePersonalAccount()
                .nameField(name)
                .emailField(email)
                .countryCodeChange()
                .countryCodeSearchInput(country)
                .countryCodeConfirm()
                .mobileField(mobileNumber)
                .passwordField(password)
                .repeatPasswordField(repeatPassword)
                .denyMarketingCommunication()
                .clickOnSignUp()
                .successMessage();
    }

}
