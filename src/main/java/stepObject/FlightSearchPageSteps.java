package stepObject;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pageObject.FlightSearchPage;

import static com.codeborne.selenide.Condition.enabled;

public class FlightSearchPageSteps extends FlightSearchPage {

    @Step("Agree to cookies")
    public FlightSearchPageSteps agreeToCookies(){
        cookieAgree.click();
        return this;
    }

    @Step("Pick one way trip")
    public FlightSearchPageSteps oneWayPick(){
        oneway.click();
        return this;
    }

    @Step("Fill departure")
    public FlightSearchPageSteps departureFill(String departure){
        departureInput.setValue(departure);
        return this;
    }

    @Step("Fill destination")
    public FlightSearchPageSteps destinationFill (String destination){
        destinationInput.setValue(destination);
        return this;
    }

    @Step("Confirm destination")
    public FlightSearchPageSteps destinationConfirm (){
        airportPick.click();
        return this;
    }

    @Step("Check is calendar picker is visible")
    public FlightSearchPageSteps calendarPicker (){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(calendar.is(enabled));
        softAssert.assertAll();
        return this;
    }

    @Step("Choose date from")
    public FlightSearchPageSteps dateFrom (){
        dateFrom.click();
        return this;
    }

    @Step("Choose date to")
    public FlightSearchPageSteps dateTo (){
        dateTo.click();
        return this;
    }

    @Step("Check is people counter is visible")
    public FlightSearchPageSteps peopleCounter (){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(peopleCounter.is(enabled));
        softAssert.assertAll();
        return this;
    }

    @Step("Add travelers count")
    public FlightSearchPageSteps incrementPeople(){
        increment.click();
        return this;
    }

    @Step("Check if decrement travelers button is enabled")
    public FlightSearchPageSteps decrementPeople (){
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(decrement.is(enabled));
        softAssert.assertAll();
        return this;
    }

    @Step("Click on done button")
    public FlightSearchPageSteps clickOnDone (){
        doneButton.click();
        return this;
    }

    @Step("Click on search button")
    public FlightSearchPageSteps clickOnSearch (){
        searchButton.click();
        return this;
    }
}
