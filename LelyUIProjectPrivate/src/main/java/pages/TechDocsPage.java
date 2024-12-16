package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import java.util.List;

public class TechDocsPage extends BasePage {


    private static  By DROPDOWN_COMBOBOX = By.xpath("//span[@role='combobox']");
    private static  By DOCUMENT_PATH = By.xpath("(//h3[@class='result-item-title'][contains(text(),'LUNA')])[5]");
    private static  String EXPECTED_H3_TEXT = "LUNA  (en)";

    public TechDocsPage(WebDriver driver) {
        super(driver);
    }

    public void clickDropdown() {
        clickElement(DROPDOWN_COMBOBOX);
        System.out.println("Clicked on the dropdown combobox.");
    }

    public void scrollToAndClickDropdownOption(String dropdownXpath, String itemXpath) {
        scrollWithinDropdown(dropdownXpath, itemXpath);
        clickElement(By.xpath(itemXpath));
        System.out.println("Scrolled to and clicked option: " + itemXpath);
    }

    public void scrollToElementUsingActions(By locator) {
        WebElement element = driver.findElement(locator);
        Actions actions = new Actions(driver);
        actions.moveToElement(element).perform();
        System.out.println("Scrolled to element: " + locator);
    }


}
