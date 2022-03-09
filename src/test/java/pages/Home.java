package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static utility.Screenshot.captureScreenshot;

public class Home extends BasePage {

    public Home() {
        super();
    }

    @FindBy(css = "[title=\"Log in to your customer account\"]")
    private WebElement signInButton;

    @FindBy(id = "search_query_top")
    private WebElement searchInput;

    @FindBy(name = "submit_search")
    private WebElement submitSearchButton;

    @Step
    public SignIn openSignInPage() {
        signInButton.click();
        captureScreenshot();
        return new SignIn();
    }

    public void fillInSearchInput(String text) {
        searchInput.sendKeys(text);
    }

    @Step
    public SearchPage searchProduct(String searchedWord) {
        fillInSearchInput(searchedWord);
        captureScreenshot();
        submitSearchButton.click();
        return new SearchPage();
    }
}