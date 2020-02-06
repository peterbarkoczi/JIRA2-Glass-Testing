package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class ProjectSettingsPage extends Page {

    @FindBy(css = "#project-config-webpanel-summary-issuetypes ul")
    private WebElement issueTypesPanel;

    @FindBy(id = "administer_project_versions")
    private WebElement versionsSubmenu;

    @FindBy(id = "view_project_issuetypes")
    private WebElement issueTypesSubmenu;

    @FindBy(id = "project-edit")
    private WebElement generalDetailsForm;

    public ProjectSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnVersions() {
        clickOn(versionsSubmenu);
    }

    public boolean isGeneralDetailsFormAppear() {
        wait.until(ExpectedConditions.visibilityOf(generalDetailsForm));
        return generalDetailsForm.isDisplayed();
    }
}
