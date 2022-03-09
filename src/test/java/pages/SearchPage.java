package pages;

import io.qameta.allure.Step;
import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static utility.Screenshot.captureScreenshot;

public class SearchPage extends BasePage {

    @FindBy(id = "selectProductSort")
    private WebElement selectProductSort;

    @FindBy(css = "#center_column > ul.product_list > li")
    private List<WebElement> listOfProductPrices;

    @FindBy(css = "#center_column > ul.product_list > li")
    private List<WebElement> listOfProductNames;

    @FindBy(css = "#center_column > p.alert")
    private WebElement searchingAlert;

    public SearchPage() {
        super();
    }

    private void selectProductsSortByPriceLowestFirst() {
        new Select(selectProductSort).selectByValue("price:asc");
    }

    private void selectProductsSortByPriceHighestFirst() {
        new Select(selectProductSort).selectByValue("price:desc");
    }

    private void selectProductsSortByNameAtoZ() {
        new Select(selectProductSort).selectByValue("name:asc");
    }

    private void selectProductsSortByNameZtoA() {
        new Select(selectProductSort).selectByValue("name:desc");
    }

    private List<BigDecimal> getPricesList() {
        return listOfProductPrices.stream()
                .map(product -> product.findElements(By.className("product-price"))
                        .stream()
                        .filter(span -> StringUtils.isNotEmpty(span.getText()))
                        .findFirst().get()
                        .getText()
                        .replace("$", "")
                )
                .map(BigDecimal::new)
                .collect(Collectors.toList());
    }

    private List<String> getNamesOfProductsList() {
        return listOfProductNames.stream()
                .map(product -> product.findElement(By.className("product-name")).getText())
                .collect(Collectors.toList());
    }

    @Step
    public SearchPage sortByPriceLowestFirst() {
        selectProductsSortByPriceLowestFirst();
        captureScreenshot();
        return new SearchPage();
    }

    @Step
    public SearchPage sortByPriceHighestFirst() {
        selectProductsSortByPriceHighestFirst();
        captureScreenshot();
        return new SearchPage();
    }

    @Step
    public SearchPage sortByNameAtoZ() {
        selectProductsSortByNameAtoZ();
        captureScreenshot();
        return new SearchPage();
    }

    @Step
    public SearchPage sortByNameZtoA() {
        selectProductsSortByNameZtoA();
        captureScreenshot();
        return new SearchPage();
    }


    @Step
    public void productsAreCorrectlySortedLowestFirst() {
        List<BigDecimal> correctListOfPrices = getPricesList();
        Collections.sort(correctListOfPrices);
        List<BigDecimal> actualListOfPrices = getPricesList();
        assertEquals(correctListOfPrices, actualListOfPrices);
    }

    @Step
    public void productsAreCorrectlySortedHighestFirst() {
        List<BigDecimal> correctListOfPrices = getPricesList();
        Collections.sort(correctListOfPrices);
        Collections.reverse(correctListOfPrices);
        List<BigDecimal> actualListOfPrices = getPricesList();
        assertEquals(correctListOfPrices, actualListOfPrices);
    }

    @Step
    public void productsAreCorrectlySortedByNameAtoZ() {
        List<String> correctListOfNames = getNamesOfProductsList();
        Collections.sort(correctListOfNames);
        List<String> actualListOfNames = getNamesOfProductsList();
        assertEquals(correctListOfNames, actualListOfNames);
    }

    @Step
    public void productsAreCorrectlySortedByNameZtoA() {
        List<String> correctListOfNames = getNamesOfProductsList();
        Collections.sort(correctListOfNames);
        Collections.reverse(correctListOfNames);
        List<String> actualListOfNames = getNamesOfProductsList();
        assertEquals(correctListOfNames, actualListOfNames);
    }

    @Step
    public void doShownProductsContainSearchedWordInName(String searchedWord) {
        List<String> listOfNames = getNamesOfProductsList();
        listOfNames.forEach(name -> assertTrue(name.contains(searchedWord)));
    }

    private String getSearchingAlertContent() {
        return searchingAlert.getText();
    }

    @Step
    public void userShouldSeeNoResultsSearchingAlert(String searchedWord) {
        String EXPECTED_MESSAGE = "No results were found for your search \"" + searchedWord + "\"";
        assertEquals(getSearchingAlertContent(), EXPECTED_MESSAGE);

    }


}
