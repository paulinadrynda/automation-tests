package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.Home;

public class RegistrationTest extends TestConfig {

    @Test
    public void userShouldSuccessfullyRegister() {
        new Home()
                .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitRegistrationFormWithValidData()
                .userShouldBeSuccessfullyRegistered();
    }

    @Test
    public void registrationWithoutPasswordShouldFail() {
        new Home()
                .openSignInPage()
                .submitCreateAccountFormWithValidEmail()
                .submitRegistrationFormWithoutPassword()
                .userShouldSeeRegistrationFormAlert("passwd is required.");
    }
}