package UvegesKlan;

import POM.DashboardPage;
import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;

public class LoginTest extends BaseTest {

    @BeforeStep
    public void beforeStep() {
        setDriver();
    }

    @Step("Fill credentials with valid user data")
    public void testFillCredentials() {
        setLoginPage();
        loginPage.fillCredentials(username, password);
   }

    @Step("Click on login button")
    public void testClickOnLoginButton() {
        setLoginPage();
        loginPage.clickOnLoginButton();
    }

    @Step("Logout button is present")
    public void testLogoutButtonIsPresent() {
        setDashboardPage();
        Assertions.assertTrue(dashboardPage.isLogoutButtonPresent());
    }

}
