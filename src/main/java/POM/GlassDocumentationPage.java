package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class GlassDocumentationPage extends Page {

    @FindBy(className = "aui-sidebar-settings-button")
    private WebElement projectSettingsButton;

    @FindBy(id = "aui-uid-1")
    private WebElement componentsTab;

    @FindBy(css = "#aui-uid-2")
    private WebElement versionsTab;

    @FindBy(id = "aui-uid-3")
    private WebElement schemesTab;

    @FindBy(id = "glass-general-nav")
    private WebElement generalTab;

    @FindBy(id = "glass-people-nav")
    private WebElement peopleTab;

    @FindBy(id = "glass-permissions-nav")
    private WebElement permissionsTab;

    @FindBy(id = "glass-notifications-nav")
    private WebElement notificationsTab;

    @FindBy(xpath = "//*[@id='glass-general-panel']/div[1]/div[1]/div/h2/a/span")
    private WebElement generalSettingsLink;

    @FindBy(xpath = "//*[@id=\"glass-people-panel\"]/div/h2/a/span")
    private WebElement peopleSettingsLink;

    @FindBy(xpath = "//*[@id=\"glass-permissions-panel\"]/div/h2/a/span")
    private WebElement permissionsSettingsLink;

    @FindBy(xpath = "//*[@id=\"glass-notifications-panel\"]/div/h2/a/span")
    private WebElement notificationsSettingsLink;

    @FindBy(xpath = "//*[@id=\"glass-general-components-panel\"]/div/h2/a/span")
    private WebElement componentsSettingLink;

    @FindBy(xpath = "//*[@id=\"glass-general-versions-panel\"]/div/h2/a/span")
    private WebElement versionsSettingsLink;

    @FindBy(xpath = "//*[@id=\"glass-general-schemes-panel\"]/div/h2/a/span")
    private WebElement schemesSettingsLink;

    public GlassDocumentationPage(WebDriver driver) {
        super(driver);
    }

    public void clickOnVersionsTab() {
        wait.until(ExpectedConditions.elementToBeClickable(versionsTab));
        clickOn(versionsTab);
    }

    public void clickOnTab(String tab) {
        switch (tab) {
            case "General":
                wait.until(ExpectedConditions.elementToBeClickable(generalTab)).click();
//                clickOn(generalTab);
                break;
            case "People":
                wait.until(ExpectedConditions.elementToBeClickable(peopleTab)).click();
//                clickOn(peopleTab);
                break;
            case "Permissions":
                wait.until(ExpectedConditions.elementToBeClickable(permissionsTab)).click();
//                clickOn(permissionsTab);
                break;
            case "Notifications":
                wait.until(ExpectedConditions.elementToBeClickable(notificationsTab)).click();
//                clickOn(notificationsTab);
                break;
        }
    }

    public void clickOnTabSettingsLink(String title) {
        switch (title) {
            case "Basic Summary":
                clickOn(generalSettingsLink);
                break;
            case "People":
                clickOn(peopleSettingsLink);
                break;
            case "Permission Matrix":
                clickOn(permissionsSettingsLink);
                break;
            case "Notification Matrix":
                clickOn(notificationsSettingsLink);
                break;
        }
    }

    public void clickOnInnerTab(String innerTab) {
        switch (innerTab) {
            case "Components":
                wait.until(ExpectedConditions.elementToBeClickable(componentsTab));
                clickOn(componentsTab);
                break;
            case "Versions":
                wait.until(ExpectedConditions.elementToBeClickable(versionsTab));
                clickOn(versionsTab);
                break;
            case "Scemes":
                wait.until(ExpectedConditions.elementToBeClickable(schemesTab));
                clickOn(schemesTab);
                break;
        }
    }

    public void clickOnInnerTabSettingsLink(String innerTab) {
        switch (innerTab) {
            case "Components":
                clickOn(componentsSettingLink);
                break;
            case "Versions":
                clickOn(versionsSettingsLink);
                break;
            case "Scemes":
                clickOn(schemesSettingsLink);
                break;
        }
    }


    public boolean isVersionAvailable(String versionName) {
        List<WebElement> versions = driver.findElements(By.cssSelector("#versions-table td.versions-table__name"));
        for (WebElement version : versions) {
            if (version.getText().equals(versionName))
                return true;
        } return false;
    }
}
