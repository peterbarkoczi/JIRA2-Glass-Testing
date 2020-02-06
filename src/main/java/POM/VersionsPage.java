package POM;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

public class VersionsPage extends Page {

    @FindBy(css = ".releases-add__name > input")
    private WebElement versionNameInput;

    @FindBy(css = ".releases-add__confirm > button")
    private WebElement addButton;

    public VersionsPage(WebDriver driver) {
        super(driver);
    }

    public void fillVersionNameInputField(String inputText) {
        versionNameInput.click();
        fillInputField(versionNameInput, inputText);
    }

    public void clickOnAddButton() {
        clickOn(addButton);
    }

    public void deleteVersion(String versionName) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("versions-table")));
        List<WebElement> versions = driver.findElements(By.cssSelector("#versions-table tr.item-state-ready"));
        for (WebElement version : versions) {
            String name = version.findElement(By.className("versions-table__name")).getText();
            if (name.equals(versionName)) {
                version.findElement(By.className("aui-iconfont-more")).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".project-config-operations-delete[tabindex='-1']"))).click();
                wait.until(ExpectedConditions.elementToBeClickable(By.id("submit"))).click();
            }
        }
    }
}
