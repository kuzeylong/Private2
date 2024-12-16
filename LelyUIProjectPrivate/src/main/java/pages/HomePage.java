package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    // Element selectors for the home page
    public static final By SEARCH_TRIGGER = By.cssSelector("div[data-do='trigger-search']");
    public static final By ACCEPT_COOKIES = By.cssSelector("#cookienotice-button-accept");

    public HomePage(WebDriver driver) {
        super(driver);
    }
}



