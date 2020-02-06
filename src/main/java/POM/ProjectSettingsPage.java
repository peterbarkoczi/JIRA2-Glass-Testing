package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProjectSettingsPage extends Page {

    @FindBy(css = "#project-config-webpanel-summary-issuetypes ul")
    private WebElement issueTypesPanel;

    @FindBy(id = "administer_project_versions")
    private WebElement versionsSubmenu;

    @FindBy(id = "view_project_issuetypes")
    private WebElement issueTypesSubmenu;

    public ProjectSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnVersions() {
        clickOn(versionsSubmenu);
    }
}
