import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.testng.annotations.Test;
import stepObject.FlightSearchPageSteps;
import utils.RyanairBrowserRunner;

import static dataObject.FlightSearchPageData.*;

public class FlightSearchPageTest extends RyanairBrowserRunner {
    FlightSearchPageSteps flightSearchPageSteps = new FlightSearchPageSteps();

    @Test
    @Description("Round trip search")
    @Severity(SeverityLevel.BLOCKER)
    public void roundSuccess(){
        flightSearchPageSteps
                .agreeToCookies()
                .departureFill(departure)
                .destinationFill(destination)
                .destinationConfirm()
                .calendarPicker()
                .dateFrom()
                .dateTo()
                .peopleCounter()
                .incrementPeople()
                .decrementPeople()
                .clickOnDone()
                .clickOnSearch();
    }

    @Test
    @Description("One way trip search")
    @Severity(SeverityLevel.BLOCKER)
    public void oneWaySuccess(){
        flightSearchPageSteps
                .agreeToCookies()
                .oneWayPick()
                .departureFill(departure)
                .destinationFill(destination)
                .destinationConfirm()
                .calendarPicker()
                .dateFrom()
                .peopleCounter()
                .incrementPeople()
                .decrementPeople()
                .clickOnDone()
                .clickOnSearch();
    }
}
