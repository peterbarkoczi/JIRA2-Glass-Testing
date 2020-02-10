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

    @FindBy(id = "components-table")
    private WebElement componentsList;

    @FindBy(id = "release-page")
    private WebElement versionsList;

    @FindBy(id = "project-config-panel-role-results")
    private WebElement userList;

    @FindBy(id = "project-config-panel-permissions")
    private WebElement permissionList;

    @FindBy(id = "project-config-panel-notifications")
    private WebElement notificationList;

    @FindBy(id = "project-config-panel-workflows")
    private WebElement workflowList;

    @FindBy(id = "project-config-panel-screens")
    private WebElement screenList;

    public ProjectSettingsPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnVersions() {
        clickOn(versionsSubmenu);
    }

    public boolean isTabDetailsFormAppear(String tab) {
        switch (tab) {
            case "General":
                wait.until(ExpectedConditions.visibilityOf(generalDetailsForm));
                return generalDetailsForm.isDisplayed();
            case "People":
                wait.until(ExpectedConditions.visibilityOf(userList));
                return userList.isDisplayed();
            case "Permissions":
                wait.until(ExpectedConditions.visibilityOf(permissionList));
                return permissionList.isDisplayed();
            case "Notifications":
                wait.until(ExpectedConditions.visibilityOf(notificationList));
                return notificationList.isDisplayed();
        }
        return false;
    }

    public boolean isSettingsPageAppear(String settingsPage) {
        switch (settingsPage) {
            case "Components":
                wait.until(ExpectedConditions.visibilityOf(componentsList));
                return componentsList.isDisplayed();
            case "Versions":
                wait.until(ExpectedConditions.visibilityOf(versionsList));
                return versionsList.isDisplayed();
            case "Workflow":
                wait.until(ExpectedConditions.visibilityOf(workflowList));
                return workflowList.isDisplayed();
            case "Screens":
                wait.until(ExpectedConditions.visibilityOf(screenList));
                return screenList.isDisplayed();
        }
        return false;
    }

}
