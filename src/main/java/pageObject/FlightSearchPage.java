package pageObject;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.*;
import static com.codeborne.selenide.Selenide.*;

public class FlightSearchPage {
    public SelenideElement
        cookieAgree = $(byText("Yes, I agree")),
        departureInput = $(by("placeholder", "Departure")),
        destinationInput = $(by("placeholder", "Destination")),
        oneway = $(by("data-ref","flight-search-trip-type__one-way-trip")),
        airportPick = $(by("data-id","BUD")),
        calendar = $(".ng-star-inserted"),
        dateFrom = $(by("data-id", "2025-02-02")),
        dateTo = $(by("data-id", "2025-02-09")),
        peopleCounter = $(".tooltip-inner"),
        increment =  $(by("data-ref","counter.counter__increment")),
        decrement = $(by("data-ref", "counter.counter__decrement")),
        doneButton = $(byText("Done")),
        searchButton = $(by("aria-label","Search"));
}
