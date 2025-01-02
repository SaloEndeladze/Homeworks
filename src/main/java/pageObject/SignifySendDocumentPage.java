package pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.$;

public class SignifySendDocumentPage {
    public SelenideElement
        emailField = $(by("data-testid","login-username")),
        passwordField = $(by("data-testid", "login-password")),
        logInButton = $(by("data-testid", "login-btn")),
        newDocumentButton = $(byText("ახალი დოკუმენტი")),
        uploadDocumentButton = $(by("data-testid","upload-dragger")),
        recipientName = $(".ant-select-selection-search-input"),
        recipientEmail = $(byXpath("/html/body/div[1]/div/div/div[1]/div/div/div[2]/div/div/div/div/div/div[2]/form/div[1]/span/div/div/div[2]/div/div[1]/div/div/div/div[2]/div/span/div/div/div/div[1]/div/div/span/span/input")),
        nextButton = $(by("data-testid", "workflow-next-btn")),
        signatureField = $(byXpath("/html/body/div/div/div/div[1]/div/div/div[2]/div/div/div/div/div/div[3]/div/div[2]/div[2]/span/div[2]/div/div/button[1]")),
        document = $(byClassName("document-container")),
        sendNowButton = $(by("data-testid","workflow-sendnow-btn")),
        documentSentMessage = $(byTextCaseInsensitive("დოკუმენტი გაიგზავნა!"));
}
