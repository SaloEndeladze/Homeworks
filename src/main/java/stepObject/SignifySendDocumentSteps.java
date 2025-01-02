package stepObject;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pageObject.SignifySendDocumentPage;

import java.io.File;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;

public class SignifySendDocumentSteps extends SignifySendDocumentPage {

    @Step("Fill email")
    public SignifySendDocumentSteps emailInput (String email){
        emailField.setValue(email);
        return this;
    }

    @Step("Fill password")
    public SignifySendDocumentSteps passwordInput (String password){
        passwordField.setValue(password);
        return this;
    }

    @Step("Click on Log in")
    public SignifySendDocumentSteps clickOnLogIn (){
        logInButton.click();
        return this;
    }

    @Step("Click on New Document Button")
    public SignifySendDocumentSteps clickOnNewDocumentButton () {
        newDocumentButton.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return this;
    }

    @Step("Upload file")
    public SignifySendDocumentSteps uploadFile (String file){
        uploadDocumentButton.uploadFile(new File(file));
        return this;
    }

    @Step("Fill recipient name")
    public SignifySendDocumentSteps recipientName (String name){
        recipientName.setValue(name);
        return this;
    }

    @Step("Fill recipient email")
    public SignifySendDocumentSteps recipientEmail (String email){
        recipientEmail.setValue(email);
        return this;
    }

    @Step("Click on next")
    public SignifySendDocumentSteps clickOnNext (){
        nextButton.click();
        return this;
    }

    @Step("Place signature field on document")
    public SignifySendDocumentSteps placeSignatureField (){
        signatureField.click();
        actions()
                .moveToLocation(630,760)
                .dragAndDrop(signatureField,document)
                .clickAndHold()
                .release()
                .perform();
        return this;
    }

    @Step("Click on send")
    public SignifySendDocumentSteps clickOnSend(){
        sendNowButton.click();
        return this;
    }

    @Step("See success message")
    public SignifySendDocumentSteps successMessage () {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(documentSentMessage.shouldBe(visible).is(visible));
        softAssert.assertAll();
        return this;
    }

}
