package UvegesKlan;

import POM.DashboardPage;
import POM.LoginPage;
import POM.LogoutPage;
import POM.Page;
import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import driver.Driver;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = System.getenv("JIRA2_BASEURL");
    protected String username = System.getenv("JIRA2_USERNAME");
    protected String password = System.getenv("JIRA2_PASSWORD");

    LoginPage loginPage;
    LogoutPage logoutPage;
    DashboardPage dashboardPage;

    // CI build trigger test 01

    public void setDriver() {
        if (this.driver == null)
            this.driver = Driver.webDriver;
    }

    protected void setLoginPage() {
        if (this.loginPage == null)
            this.loginPage = new LoginPage(driver);
    }

    protected void setDashboardPage() {
        if (this.dashboardPage == null)
            this.dashboardPage = new DashboardPage(driver);
    }

    protected void setLogoutPage() {
        if (this.logoutPage == null)
            this.logoutPage = new LogoutPage(driver);
    }

    @BeforeStep
    public void beforeStep() {
        setDriver();
    }

    @Step("Go to main page")
    public void goToMainPage() {
        driver.get(baseUrl);
    }

    @Step("Go to Glass page")
    public void goToGlassPage() {
        driver.get(baseUrl + Page.getGlassURL());

    }

    @Step("Go to Project Settings page")
    public void goToProjectSettingsPage() {
        driver.get(baseUrl + Page.getProjectSettingsURL());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
