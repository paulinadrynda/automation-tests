package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.Home;

public class SearchTest extends TestConfig {

    @Test
    public void productsAreCorrectlySearchedRightWord() {
        new Home()
                .searchProduct("dress")
                .doShownProductsContainSearchedWordInName("dress");
    }

    @Test
    public void productsAreCorrectlySearchedIncompleteWord() {
        new Home()
                .searchProduct("dre")
                .doShownProductsContainSearchedWordInName("dre");
    }

    @Test
    public void searchingWithInvalidWordShouldFail() {
        new Home()
                .searchProduct("dresx")
                .userShouldSeeNoResultsSearchingAlert("dresx");
    }
}
