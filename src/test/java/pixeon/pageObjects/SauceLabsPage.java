package pixeon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.List;

public class SauceLabsPage extends BasePage {
    public SauceLabsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".Feiy")
    private WebElement topMenu;

    @FindBy(how = How.CSS, using = ".y2tJ")
    private WebElement subMenu;

    @FindBy(how = How.CSS, using = ".site-content__body")
    private WebElement crossBrowserTestingBody;


    private void clickOnSolutionsMenu() {
        List<WebElement> menuElements;
        WebElement solutionOption;

        menuElements = topMenu.findElements(By.className("_2r81"));
        solutionOption = menuElements.get(0);
        solutionOption.click();
    }

    public void clickOnCrossBrowserTestingSubMenu(){
        WebElement crossBrowserTestingLink;

        clickOnSolutionsMenu();
        crossBrowserTestingLink = subMenu.findElement(By.linkText("Cross Browser Testing"));
        crossBrowserTestingLink.click();
    }

    public void clickOnLearnMoreLink(){
        List<WebElement> reactDivs;
        WebElement automateYourSeleniumTestsDiv, automateYourSeleniumTestsLearnMoreLink;

        reactDivs = crossBrowserTestingBody.findElements(By.cssSelector("[id^=react]"));
        automateYourSeleniumTestsDiv = reactDivs.get(1);
        automateYourSeleniumTestsLearnMoreLink = automateYourSeleniumTestsDiv.findElement(By.className("_2rVB"));
        automateYourSeleniumTestsLearnMoreLink.click();
    }

}
