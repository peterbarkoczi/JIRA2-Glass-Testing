package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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
        url = "secure/Dashboard.jspa";
    }

    public String getTitle() {
        return driver.getTitle();
    }

    public void clickOnLoginButton() {
        clickOn(loginButton);
    }

    public void fillCredentials(String username, String password) {
        fillInputField(usernameInput, username);
        passwordInput.click();
        fillInputField(passwordInput, password);
    }
}