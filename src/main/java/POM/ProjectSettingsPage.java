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

    public boolean isInnerTabDetailsFormAppear(String innerTab) {
        switch (innerTab) {
            case "Components":
                wait.until(ExpectedConditions.visibilityOf(componentsList));
                return componentsList.isDisplayed();
            case "Versions":
                wait.until(ExpectedConditions.visibilityOf(versionsList));
                return versionsList.isDisplayed();
        }
        wait.until(ExpectedConditions.visibilityOf(generalDetailsForm));
        return generalDetailsForm.isDisplayed();
    }

}
