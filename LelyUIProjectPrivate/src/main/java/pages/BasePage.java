package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void navigateToUrl(String url) {
        driver.get(url);
        maximizeWindow();
        System.out.println("Navigated to: " + url);
    }

    public void maximizeWindow() {
        driver.manage().window().maximize();
        System.out.println("Browser window maximized.");
    }

    public void verifyTitle(String expectedTitle) {
        String actualTitle = driver.getTitle().replaceAll("\\s+", "");
        expectedTitle = expectedTitle.replaceAll("\\s+", "");
        if (!actualTitle.equals(expectedTitle)) {
            throw new AssertionError(
                    "Page title does not match! Expected: '" + expectedTitle + "', but was: '" + actualTitle + "'"
            );
        }
        System.out.println("Title verified: " + actualTitle);
    }

    public boolean isElementVisible(By locator) {
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element is visible: " + locator);
            return true;
        } catch (Exception e) {
            System.out.println("Element is not visible: " + locator);
            return false;
        }
    }

    public void enterText(By locator, String text) {
        WebElement inputField = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        inputField.clear();
        inputField.sendKeys(text);
        System.out.println("Entered text: '" + text + "' into element located by: " + locator);
    }

    public void clickElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        element.click();
        System.out.println("Clicked on element located by: " + locator);
    }

    public List<WebElement> getElements(By locator) {
        List<WebElement> elements = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
        System.out.println("Retrieved " + elements.size() + " elements located by: " + locator);
        return elements;
    }

    public void acceptCookies(By cookieButtonLocator) {
        try {
            WebElement cookieButton = wait.until(ExpectedConditions.elementToBeClickable(cookieButtonLocator));
            cookieButton.click();
            System.out.println("Cookies accepted.");
        } catch (Exception e) {
            System.out.println("No cookies banner found.");
        }
    }

    public void scrollWithinDropdown(String dropdownXpath, String itemXpath) {

        WebElement dropdown = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[@role='combobox']")));
        WebElement item = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//li[normalize-space(text()) = 'Luna (all documents)']")));

        ((org.openqa.selenium.JavascriptExecutor) driver).executeScript(
                "arguments[0].scrollTop = arguments[1].offsetTop;", dropdown, item
        );
        System.out.println("Scrolled to item within dropdown.");
    }












}
