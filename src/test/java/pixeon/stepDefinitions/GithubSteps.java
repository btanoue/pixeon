package pixeon.stepDefinitions;

import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import pixeon.pageObjects.GithubPage;

public class GithubSteps {
    GithubPage githubPage;
    FirefoxOptions options = new FirefoxOptions();
    private final WebDriver driver = new FirefoxDriver(options.setHeadless(true));
    private static final String GITHUB_URL = "https://github.com";

    @Given("^I am on the github website$")
    public void i_am_on_the_github_website() {
        githubPage = new GithubPage(driver);
        githubPage.visit(GITHUB_URL);
    }

    @When("^I search for (.*)$")
    public void i_search_for_selenium(String word) {
        githubPage.search(word);
    }

    @When("^I access the SeleniumHQ/selenium repository$")
    public void i_access_the_SeleniumHQ_selenium_repository() {
        githubPage.clickOnSeleniumHQRepository();
    }

    @Then("^I should see the file or folder with the oldest commit$")
    public void i_should_see_the_file_or_folder_with_the_oldest_commit(){
        githubPage.verifyTheOldestCommit();
    }

    @After
    public void tearDown(){
        driver.quit();
    }
}
