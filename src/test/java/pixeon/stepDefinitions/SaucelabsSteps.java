package pixeon.stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pixeon.pageObjects.SauceLabsPage;

public class SaucelabsSteps {
    SauceLabsPage sauceLabsPage;
    FirefoxOptions options = new FirefoxOptions();
    private final WebDriver driver = new FirefoxDriver(options.setHeadless(true));
    private static final String SAUCE_LABS_URL = "https://saucelabs.com";

    @Given("^I am on the saucelabs site$")
    public void i_am_on_the_saucelabs_site(){
        sauceLabsPage = new SauceLabsPage(driver);
        sauceLabsPage.visit(SAUCE_LABS_URL);
    }

    @When("^I access the cross browser testing menu$")
    public void i_access_the_cross_browser_testing_menu(){
        sauceLabsPage.clickOnCrossBrowserTestingSubMenu();
    }

    @When("^I want to learn more about selenium tests$")
    public void i_want_to_learn_more_about_selenium_tests() {
        sauceLabsPage.clickOnLearnMoreLink();
    }

    @Then("^I should see how saucelabs run selenium tests$")
    public void i_should_see_how_saucelabs_run_selenium_tests() {
        sauceLabsPage.hasText("Run Selenium tests securely in the cloud");
    }


    @After
    public void tearDown(){
        driver.quit();
    }

}
