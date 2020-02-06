package POM;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOfElementLocated;

public abstract class Page {
    WebDriver driver;
    WebDriverWait wait;

    @FindBy(css = "#user-options > a")
    WebElement userOptionsLink;
    @FindBy(id = "log_out")
    List<WebElement> logoutButtons;
    @FindBy(id = "create_link")
    WebElement createButton;

    static String projectKey = "UVG";
    static String glassURL = "projects/" + projectKey + "?selectedItem=com.codecanvas.glass:glass";
    static String projectSettingsURL = "plugins/servlet/project-config/" + projectKey + "/summary";

    public Page(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
        AjaxElementLocatorFactory factory = new AjaxElementLocatorFactory(this.driver, 20);
        PageFactory.initElements(factory, this);
    }

    void fillInputField(WebElement inputField, String inputText) {
        inputField.sendKeys(inputText);
    }

    void clearInputField(WebElement inputField) {
        inputField.sendKeys(Keys.chord(Keys.CONTROL, "a"), Keys.DELETE);
    }

    void clickOn(WebElement webElement) {
        wait.until(ExpectedConditions.elementToBeClickable(webElement));
        webElement.click();
    }

    public String catchPopup() {
        WebElement popup = wait.until(visibilityOfElementLocated(By.className("aui-message")));
        String popupMessage = popup.getText();
        try {
            WebElement popupLink = popup.findElement(By.cssSelector("a"));
            wait.until(elementToBeClickable(popupLink)).click();
        } catch (NoSuchElementException e) {
            System.err.println("Seems like there's no link to click on...");
            e.printStackTrace();
        }
        return popupMessage;
    }
  
    public void clickOnLogoutButton() {
        clickOn(logoutButtons.get(0));
    }

    public void openNewTab(String url) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.open('" + url + "')");
    }

    public void changeTab(int numberOfTab) {
        List<String> tabs = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(numberOfTab - 1));
    }

    public Boolean isTestUserLoggedIn(String username) {
        return wait.until(ExpectedConditions.attributeToBe(userOptionsLink, "data-username", username));
    }

    public static String getGlassURL() {
        return glassURL;
    }

    public static String getProjectSettingsURL() {
        return projectSettingsURL;
    }
}
