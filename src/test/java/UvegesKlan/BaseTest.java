package UvegesKlan;

import POM.DashboardPage;
import POM.LoginPage;
import org.openqa.selenium.WebDriver;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = System.getenv("JIRA2_BASEURL");
    protected String username = System.getenv("JIRA2_USERNAME");
    protected String password = System.getenv("JIRA2_PASSWORD");
    protected String mainPage = baseUrl + "";

    // PAGES
    LoginPage loginPage;
    DashboardPage dashboardPage;
}
