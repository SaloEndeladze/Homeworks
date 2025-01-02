import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import stepObject.SignifyForgotPasswordSteps;
import utils.SignifyBrowserRunner;

import static dataObject.SignifyForgotPasswordData.email;

public class SignifyForgotPassword extends SignifyBrowserRunner {
    SignifyForgotPasswordSteps signifyForgotPasswordSteps = new SignifyForgotPasswordSteps();

    @Test
    @Severity(SeverityLevel.CRITICAL)
    @Description("Send password reset link to email")
    public void forgotPassword(){
        signifyForgotPasswordSteps
                .clickOnForgot()
                .sendLinkwithoutEmail()
                .checkError()
                .fillEmail(email)
                .sendLink()
                .successMessage();
    }
}
