package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import pages.BasePage;
import pages.HomePage;
import utils.DriverManager;
import utils.EnvironmentManager;

public class CommonSteps {

    WebDriver driver = DriverManager.getDriver();
    BasePage basePage = new BasePage(driver);

    @Given("I navigate to the {string} environment using the Chrome browser with expected title {string}")
    public void i_navigate_to_the_environment_with_title(String environment, String expectedTitle) {
        String url = EnvironmentManager.getUrlForEnvironment(environment);
        basePage.navigateToUrl(url);
        basePage.verifyTitle(expectedTitle);
    }

    @Given("I navigate to the {string} page using the Chrome browser")
    public void i_navigate_to_the_page_using_the_chrome_browser(String environment) {
        String url = EnvironmentManager.getUrlForEnvironment(environment);
        basePage.navigateToUrl(url);
    }

    @When("I maximize the browser window")
    public void i_maximize_the_browser_window() {
        basePage.maximizeWindow();
    }

    @And("I accept cookies")
    public void i_accept_cookies() {
        basePage.acceptCookies(HomePage.ACCEPT_COOKIES);
    }
}
