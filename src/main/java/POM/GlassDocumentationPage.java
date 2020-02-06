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

    @FindBy(xpath = "//*[@id='glass-general-panel']/div[1]/div[1]/div/h2/a/span")
    private WebElement generalSettingsLink;

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

    public void clickOnGeneralTab() {
        wait.until(ExpectedConditions.elementToBeClickable(generalTab));
        clickOn(generalTab);
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

    public void clickOnGeneralSettingsLink() {
        clickOn(generalSettingsLink);
    }
}
