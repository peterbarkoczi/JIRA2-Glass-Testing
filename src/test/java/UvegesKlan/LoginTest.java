package UvegesKlan;

import POM.DashboardPage;
import POM.LoginPage;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.junit.jupiter.api.Assertions;

public class LoginTest extends BaseTest {
    @Step("Go to main page")
    public void goToMainPage() {
        this.driver = Driver.webDriver;
        driver.get(mainPage);
        this.loginPage = new LoginPage(driver);
    }

    @Step("Fill credentials with valid user data")
    public void fillCredentials() {
        loginPage.fillCredentials(username, password);
   }

    @Step("Click on login button")
    public void clickOnLoginButton() {
        loginPage.clickOnLoginButton();
        this.dashboardPage = new DashboardPage(driver);
    }

    @Step("Logout button is present")
    public void logoutButtonIsPresent() {
        Assertions.assertTrue(dashboardPage.isLogoutButtonPresent());
    }
}
