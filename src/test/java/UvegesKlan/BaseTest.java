package UvegesKlan;

import POM.DashboardPage;
import POM.LoginPage;
import POM.LogoutPage;
import driver.Driver;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = System.getenv("JIRA2_BASEURL");
    protected String username = System.getenv("JIRA2_USERNAME");
    protected String password = System.getenv("JIRA2_PASSWORD");
    protected String mainPage = baseUrl + "";

    LoginPage loginPage;
    LogoutPage logoutPage;
    DashboardPage dashboardPage;

    public void setDriver() {
        System.out.println("BEFORE STEP!");
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

}
