package stepDefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pages.TechDocsPage;
import utils.DriverManager;

public class TechDocsSteps {

    WebDriver driver = DriverManager.getDriver();
    TechDocsPage techDocsPage = new TechDocsPage(driver);

    @When("I click on the dropdown")
    public void i_click_on_the_dropdown() {
        techDocsPage.clickDropdown();
        System.out.println("Dropdown opened successfully.");
    }

    @When("I scroll within the dropdown and select luna item")
    public void i_scroll_within_the_dropdown_and_select_luna_item() {
        String dropdownXpath = "//span[@role='combobox']"; 
        String itemXpath = "//li[normalize-space(text()) = 'Luna (all documents)']"; 

        techDocsPage.scrollToAndClickDropdownOption(dropdownXpath, itemXpath);
    }
    @When("I scroll to the element with text 'LUNA (en)'")
    public void i_scroll_to_the_element() {
        By h3Locator = By.xpath("//h3[normalize-space(text()) = 'LUNA (en)']");
        techDocsPage.scrollToElementUsingActions(h3Locator);
    }
}

