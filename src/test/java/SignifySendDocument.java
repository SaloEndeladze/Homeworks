import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import stepObject.SignifySendDocumentSteps;
import utils.SignifyBrowserRunner;

import static dataObject.SignifySendDocumentData.*;

public class SignifySendDocument extends SignifyBrowserRunner {
    SignifySendDocumentSteps signifySendDocumentSteps = new SignifySendDocumentSteps();

    @Test
    @Severity(SeverityLevel.BLOCKER)
    @Description ("Test case for sending document on Signify")
    public void sendDocument (){
        signifySendDocumentSteps
                .emailInput(username)
                .passwordInput(password)
                .clickOnLogIn()
                .clickOnNewDocumentButton()
                .uploadFile(file)
                .recipientName(recipientName)
                .recipientEmail(recipientEmail)
                .clickOnNext()
                .placeSignatureField()
                .clickOnSend()
                .successMessage();
    }
}
