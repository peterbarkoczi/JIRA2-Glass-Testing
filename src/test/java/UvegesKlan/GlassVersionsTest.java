package UvegesKlan;

import POM.GlassDocumentationPage;
import POM.ProjectSettingsPage;
import POM.VersionsPage;
import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;
import org.junit.jupiter.api.Assertions;

public class GlassVersionsTest extends BaseTest {

    // GLASS DOCUMENTATION
    private GlassDocumentationPage glassPage;
    // PROJECT SETTINGS
    private ProjectSettingsPage projectSettingsPage;
    private VersionsPage versionsPage;

    @BeforeStep
    public void beforeStep() {
        setDriver();
    }

    private void setGlassPage() {
        if (this.glassPage == null)
            this.glassPage = new GlassDocumentationPage(driver);
    }

    private void setProjectSettingsPage() {
        if (this.projectSettingsPage == null)
            this.projectSettingsPage = new ProjectSettingsPage(driver);
    }

    private void setVersionsPage() {
        if (this.versionsPage == null)
            this.versionsPage = new VersionsPage(driver);
    }

    @Step("Select Versions submenu")
    public void selectVersionsSubmenuInProjectSettings() {
        System.out.println("---- BEFORE -- Select Versions submenu ----");
        setProjectSettingsPage();
        System.out.println("setProjectSettingsPage() ran");
        projectSettingsPage.clickOnVersions();
        System.out.println("---- AFTER  -- Select Versions submenu ----");
    }

    @Step("Fill Version name input field with <name>")
    public void fillVersionNameInputField(String name) {
        setVersionsPage();
        versionsPage.fillVersionNameInputField(name);
    }

    @Step("Click on Add button")
    public void clickOnAddButton() {
        setVersionsPage();
        versionsPage.clickOnAddButton();
    }

    @Step("Select Versions Tab")
    public void selectVersionsTabInGlass() {
        setGlassPage();
        glassPage.clickOnVersionsTab();
    }

    @Step("Version named <new version> is available in Glass")
    public void assertVersionIsAvailableInGlass(String version) {
        setGlassPage();
        Assertions.assertTrue(glassPage.isVersionAvailable(version));
    }

}
