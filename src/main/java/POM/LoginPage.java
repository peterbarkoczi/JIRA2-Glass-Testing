package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page {

    @FindBy(id = "login-form-username")
    private WebElement usernameInput;

    @FindBy(id = "login-form-password")
    private WebElement passwordInput;

    @FindBy(id = "login")
    private WebElement loginButton;

    @FindBy(className = "login-link")
    private WebElement loginLink;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnLoginButton() {
        clickOn(loginButton);
        DashboardPage page = new DashboardPage(driver);
        wait.until(ExpectedConditions.visibilityOf(page.getAvatar()));
    }

    public void fillCredentials(String username, String password) {
        fillInputField(usernameInput, username);
        passwordInput.click();
        fillInputField(passwordInput, password);
    }
}
