package pages;

import io.qameta.allure.Step;
import org.hamcrest.core.IsEqual;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static org.hamcrest.MatcherAssert.assertThat;

public class Profile extends BasePage {

    @FindBy(css = "#center_column > h1")
    private WebElement profilePageHeader;

    public Profile() {
        super();
    }

    @Step
    public void userShouldBeSuccessfullyRegistered() {
        String profilePageHeaderText = profilePageHeader.getText();
        String expectedHeaderText = "MY ACCOUNT";

        assertThat(profilePageHeaderText, IsEqual.equalTo(expectedHeaderText));
    }
}