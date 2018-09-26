package pixeon.stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pixeon.pageObjects.ExtentreportsPage;

public class ExtentreportsSteps {
    ExtentreportsPage extentreportsPage;
    FirefoxOptions options = new FirefoxOptions();
    private final WebDriver driver = new FirefoxDriver(options.setHeadless(true));
    //private final WebDriver driver = new FirefoxDriver();
    private static final String EXTENTREPORTS_URL = "http://extentreports.com";

    @Given("^I am on the extentreports website$")
    public void i_am_on_the_extentreports_website() {
        extentreportsPage = new ExtentreportsPage(driver);
        extentreportsPage.visit(EXTENTREPORTS_URL);
    }

    @When("^I access the java documentation of version three$")
    public void i_access_the_java_documentation_of_version_three() {
        extentreportsPage.clickOnVersionThreeOfJavaMenuDocumentation();
    }

    @Then("^I should see offline report enabled in pro version")
    public void i_should_see_offline_report_enabled_in_pro_version() {
        extentreportsPage.verifyOfflineReportInProVersion();
    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
