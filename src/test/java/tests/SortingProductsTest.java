package tests;

import config.TestConfig;
import org.junit.jupiter.api.Test;
import pages.Home;

public class SortingProductsTest extends TestConfig {

    @Test
    public void searchProductsAreCorrectlySortedByPriceLowestFirst() {
        new Home()
                .searchProduct("dress")
                .sortByPriceLowestFirst()
                .productsAreCorrectlySortedLowestFirst();
    }

    @Test
    public void searchProductsAreCorrectlySortedByPriceHighestFirst() {
        new Home()
                .searchProduct("dress")
                .sortByPriceHighestFirst()
                .productsAreCorrectlySortedHighestFirst();
    }

    @Test
    public void searchProductsAreCorrectlySortedAtoZ() {
        new Home()
                .searchProduct("dress")
                .sortByNameAtoZ()
                .productsAreCorrectlySortedByNameAtoZ();
    }

    @Test
    public void searchProductsAreCorrectlySortedZtoA() {
        new Home()
                .searchProduct("dress")
                .sortByNameZtoA()
                .productsAreCorrectlySortedByNameZtoA();
    }
}
