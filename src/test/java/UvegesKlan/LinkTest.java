package UvegesKlan;

import POM.GlassDocumentationPage;
import POM.ProjectSettingsPage;
import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;

public class LinkTest extends BaseTest {

    private GlassDocumentationPage glassPage;
    private ProjectSettingsPage projectSettingsPage;

    private void setGlassPage() {
        if (this.glassPage == null)
            this.glassPage = new GlassDocumentationPage(driver);
    }

    private void setProjectSettingsPage() {
        if (this.projectSettingsPage == null)
            this.projectSettingsPage = new ProjectSettingsPage(driver);
    }

    @BeforeStep
    public void beforeStep() {
        setDriver();
        setGlassPage();
        setProjectSettingsPage();
    }

    @Step("Go to glass documentation page")
    public void goToGlassPage() {
        driver.get("https://jira2.codecool.codecanvas.hu/projects/UVG?selectedItem=com.codecanvas.glass:glass");
    }

    @Step("Click on <tab> above the project details")
    public void goToGeneralTab(String tab) {
        glassPage.clickOnTab(tab);
    }

    @Step("Click on quick link icon belongs to <title>")
    public void testClickOnGeneralLink(String title) {
        glassPage.clickOnTabSettingsLink(title);
    }

    @Step("<tab> settings page open in new window")
    public void testVerifySettingsPage(String tab) {
        projectSettingsPage.changeTab(2);
        Assertions.assertTrue(projectSettingsPage.isTabDetailsFormAppear(tab));
        driver.close();
        projectSettingsPage.changeTab(1);
    }

    @Step("Click on <innerTab> below project details")
    public void testGoToTab(String innerTab) {
        glassPage.clickOnInnerTab(innerTab);
    }

    @Step("Click on link icon belongs to <innerTab>")
    public void testClickOnTabLink(String innerTab) {
        glassPage.clickOnInnerTabSettingsLink(innerTab);
    }

    @Step("General <innerTab> settings page open in new window")
    public void testVerifyInnerTabSettingsPage(String innerTab) {
        projectSettingsPage.changeTab(2);
        Assertions.assertTrue(projectSettingsPage.isSettingsPageAppear(innerTab));
        driver.close();
        projectSettingsPage.changeTab(1);
    }


    @Step("Select first issue type")
    public void selectIssueType() {
        glassPage.selectFirstIssueType();
    }

    @Step("Issue Type <issueType_link> settings page open in new window")
    public void testVerifyIssueTypeSettingsPage(String issueType_link) {
        projectSettingsPage.changeTab(2);
        Assertions.assertTrue(projectSettingsPage.isSettingsPageAppear(issueType_link));
        driver.close();
        projectSettingsPage.changeTab(1);
    }
}
