package stepObject;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pageObject.SignifyRegistrationPage;

import static com.codeborne.selenide.Condition.*;

public class SignifyRegistratioPageSteps extends SignifyRegistrationPage {

    @Step("Go to registration")
    public SignifyRegistratioPageSteps goToRegistration(){
        registrationButton.click();
        return this;
    }

    @Step("Choose personal account radio")
    public SignifyRegistratioPageSteps choosePersonalAccount(){
        personalAccountRadio.click();
        return this;
    }

    @Step("Fill name")
    public SignifyRegistratioPageSteps nameField (String name){
        nameInput.setValue(name);
        return this;
    }

    @Step("Fill email")
    public SignifyRegistratioPageSteps emailField (String email){
        emailInput.setValue(email);
        return this;
    }

    @Step("Click on country code")
    public SignifyRegistratioPageSteps countryCodeChange () {
        countryCodeChange.click();
        return this;
    }

    @Step("Input new country name")
    public SignifyRegistratioPageSteps countryCodeSearchInput (String country) {
        countryCodeSearch.setValue(country);
        return this;
    }

    @Step("Confirm country")
    public SignifyRegistratioPageSteps countryCodeConfirm () {
        countryCodeConfirm.click();
        return this;
    }

    @Step("Fill mobile number")
    public SignifyRegistratioPageSteps mobileField (String mobile){
        mobileNumberInput.setValue(mobile);
        return this;
    }

    @Step("Fill password")
    public SignifyRegistratioPageSteps passwordField (String password){
        passwordInput.setValue(password);
        return this;
    }

    @Step("Repeat password")
    public SignifyRegistratioPageSteps repeatPasswordField (String repeatPassword){
        repeatPasswordInput.setValue(repeatPassword);
        return this;
    }

    @Step("Deny marketing communication")
    public SignifyRegistratioPageSteps denyMarketingCommunication(){
        marketingRadio.click();
        return this;
    }

    @Step("Click on Sign up")
    public SignifyRegistratioPageSteps clickOnSignUp (){
        signUpConfirmButton.click();
        return this;
    }

    @Step("Show success message")
    public SignifyRegistratioPageSteps successMessage (){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(successMessage.shouldBe(visible).is(visible));
        softAssert.assertAll();
        return this;
    }
}
