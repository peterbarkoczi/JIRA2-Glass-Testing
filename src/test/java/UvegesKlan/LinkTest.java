package UvegesKlan;

import POM.GlassDocumentationPage;
import POM.ProjectSettingsPage;
import com.thoughtworks.gauge.AfterScenario;
import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import driver.Driver;
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

    @Step("Click on General above the project details")
    public void goToGeneralTab() {
        glassPage.clickOnGeneralTab();
    }

    @Step("Click on link icon belongs to Basic Summary")
    public void testClickOnGeneralLink() {
        glassPage.clickOnGeneralSettingsLink();
    }

    @Step("Details settings page open in new window")
    public void testVerifySettingsPage() {
        projectSettingsPage.changeTab(2);
        Assertions.assertTrue(projectSettingsPage.isGeneralDetailsFormAppear());
    }

    @Step("Click on <innerTab> below project details")
    public void testGoToTab(String innerTab) {
        glassPage.clickOnInnerTab(innerTab);
    }

    @Step("Click on link icon belongs to <innerTab>")
    public void testClickOnTabLink(String innerTab) {
        glassPage.clickOnInnerTabSettingsLink(innerTab);
    }

    @Step("<innerTab> settings page open in new window")
    public void testVerifyInnerTabSettingsPage(String innerTab) {
        projectSettingsPage.changeTab(2);
        Assertions.assertTrue(projectSettingsPage.isInnerTabDetailsFormAppear(innerTab));
        projectSettingsPage.closeTab();
        projectSettingsPage.changeTab(1);
    }

}
