package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.SearchPage;
import utils.DriverManager;

public class SearchSteps {

    WebDriver driver = DriverManager.getDriver();
    SearchPage searchPage = new SearchPage(driver);

    @When("I click the search button")
    public void i_click_the_search_button() {
        searchPage.clickSearchButton();
    }

    @Then("I verify the search area is displayed")
    public void i_verify_the_search_area_is_displayed() {
        searchPage.verifySearchAreaDisplayed();
    }

    @When("I enter {string} into the search area and click the search button")
    public void i_enter_into_the_search_area_and_click_the_search_button(String keyword) {
        searchPage.enterSearchKeyword(keyword);
        searchPage.clickSearchSubmitButton();
    }

    @Then("Verify that all search results contain the word {string}")
    public void verify_all_search_results_contain_the_word(String keyword) {
        searchPage.verifySearchResultsContainKeyword(keyword);
    }
}
