package UvegesKlan;

import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;

public class LogoutTest extends BaseTest {

    @BeforeStep
    public void beforeStep() {
        setDriver();
    }

    @Step("Log out")
    public void testLogOut() {
        setDashboardPage();
        dashboardPage.clickOnAvatar();
        dashboardPage.clickOnLogoutButton();
    }

    @Step("Login button is present")
    public void assertLoginButtonIsPresent() {
        setLogoutPage();
        Assertions.assertTrue(logoutPage.isLoginButtonPresent());
    }
}
