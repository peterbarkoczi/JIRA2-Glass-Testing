package UvegesKlan;

import com.thoughtworks.gauge.BeforeStep;
import com.thoughtworks.gauge.Step;

public class LinkTest extends BaseTest {

    @BeforeStep
    public void beforeStep() {
        setDriver();
    }

    @Step("Go to glass documentation page")
    public void goToGlassPage() {
        driver.get("https://jira2.codecool.codecanvas.hu/projects/UVG?selectedItem=com.codecanvas.glass:glass");
    }

    @Step("Click on General above the project details")
    public void goToGeneralTab() {

    }

    @Step("Click on link icon belongs to Basic Summary")
    public void testClickOnGeneralLink() {}

    @Step("Details settings page open in new window")
    public void testVerifySettingsPage() {

    }

    @Step("Click on <innerTab> below project details")
    public void testGoToTab(String innerTab) {

    }

    @Step("Click on link icon belongs to <innerTab>")
    public void testClickOnTabLink(String innerTab) {

    }



}
