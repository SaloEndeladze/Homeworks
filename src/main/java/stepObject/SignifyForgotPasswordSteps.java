package stepObject;

import io.qameta.allure.Step;
import org.testng.Assert;
import pageObject.SignifyForgotPasswordPage;

import static com.codeborne.selenide.Condition.visible;

public class SignifyForgotPasswordSteps extends SignifyForgotPasswordPage {

    @Step ("Click on forgot password")
    public SignifyForgotPasswordSteps clickOnForgot (){
        forgotButton.click();
        return this;
    }

    @Step ("Click on submit without filling email")
    public SignifyForgotPasswordSteps sendLinkwithoutEmail (){
        sendLinkButton.click();
        return this;
    }

    @Step ("Check if error message is visible")
    public SignifyForgotPasswordSteps checkError (){
        Assert.assertTrue(errorMessage.is(visible));
        return this;
    }

    @Step ("Fill email")
    public SignifyForgotPasswordSteps fillEmail (String email){
        emailInput.setValue(email);
        return this;
    }
    @Step ("Click on submit with filled email")
    public SignifyForgotPasswordSteps sendLink (){
        sendLinkButton.click();
        return this;
    }

    @Step ("Check if success message is shown")
    public SignifyForgotPasswordSteps successMessage (){
        Assert.assertTrue(successMessage.shouldBe(visible).is(visible));
        return this;
    }

}
