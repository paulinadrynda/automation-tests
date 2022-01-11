package tests;

import config.TestConfig;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import pages.Home;

public class RegistrationTest extends TestConfig {

    @Test
    public void userShouldSuccessfullyRegister() {
        new Home()
                .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitFormWithValidData()
                .userShouldBeSuccessfullyRegistered();
    }

    @Test
    @Disabled
    public void registrationWithInvalidDataShouldFail() {
        new Home()
                .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitFormWithInvalidData()
                .userShouldSeeRegistrationFormAlert();
    }
}