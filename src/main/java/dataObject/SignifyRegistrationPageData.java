package dataObject;

import com.github.javafaker.Faker;

public interface SignifyRegistrationPageData {
    Faker faker = new Faker();

    String
        name = faker.name().fullName(),
        email = faker.internet().emailAddress(),
        country = "Poland",
        mobileNumber = "555555555",
        password = "Password123",
        repeatPassword = "Password123";
}
