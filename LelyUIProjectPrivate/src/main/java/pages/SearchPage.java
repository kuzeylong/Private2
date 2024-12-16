package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class SearchPage extends BasePage {


    public static  By SEARCH_TRIGGER = By.cssSelector("div[data-do='trigger-search']");
    public static  By SEARCH_TITLE = By.cssSelector(".global-search-container__title");
    public static  By SEARCH_BOX = By.cssSelector("#global-search");
    public static  By SEARCH_SUBMIT = By.cssSelector("button[type='submit']");
    public static  By SEARCH_RESULTS = By.xpath("//span[contains(@class,'highlighted')]");

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    public void clickSearchButton() {
        clickElement(SEARCH_TRIGGER);
        System.out.println("Clicked on the search button.");
    }

    public void verifySearchAreaDisplayed() {
        if (!isElementVisible(SEARCH_TITLE)) {
            throw new AssertionError("Search area is not displayed!");
        }
        System.out.println("Search area is displayed.");
    }

    public void enterSearchKeyword(String keyword) {
        enterText(SEARCH_BOX, keyword);
        System.out.println("Entered keyword: " + keyword);
    }

    public void clickSearchSubmitButton() {
        clickElement(SEARCH_SUBMIT);
        System.out.println("Clicked the search submit button.");
    }

    public void verifySearchResultsContainKeyword(String keyword) {
        List<WebElement> results = getElements(SEARCH_RESULTS);
        if (results.isEmpty()) {
            throw new AssertionError("No search results found.");
        }

        for (WebElement result : results) {
            String resultText = result.getText().toLowerCase();
            if (!resultText.contains(keyword.toLowerCase())) {
                throw new AssertionError("Search result does not contain the keyword: " + keyword);
            }
            System.out.println("Verified result contains keyword: " + resultText);
        }
        System.out.println("All search results contain the keyword: " + keyword);
    }
}
