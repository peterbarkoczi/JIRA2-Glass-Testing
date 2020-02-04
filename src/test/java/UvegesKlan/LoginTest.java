package UvegesKlan;

import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class LoginTest extends BaseTest {
    @Step("Go to main page")
    public void goToMainPage() {
        Driver.webDriver.get(mainPage);
    }

    @Step("Fill credentials with valid user data")
    public void fillCredentials() {
        Driver.webDriver.findElement(By.id("login-form-username")).sendKeys(username);
        Driver.webDriver.findElement(By.id("login-form-password")).sendKeys(password);
    }

    @Step("Click on login button")
    public void clickOnLoginButton() {
        Driver.webDriver.findElement(By.id("login")).click();
    }

    @Step("Logout button is present")
    public void logoutButtonIsPresent() {
        Assertions.assertTrue(Driver.webDriver.findElements(By.id("log_out")).size() > 0);
    }
}
