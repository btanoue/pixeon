package pixeon.pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import pixeon.utilities.GithubFileInformation;

import java.util.Iterator;
import java.util.List;

public class GithubPage extends BasePage {
    public GithubPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.CSS, using = ".header-search-input")
    private WebElement searchInput;

    @FindBy(how = How.LINK_TEXT, using = "SeleniumHQ/selenium")
    private WebElement seleniumHQRepositoryLink;

    @FindBy(how = How.CSS, using = ".files")
    private WebElement filesTable;

    public void search(String subject){
        WebElement jumpToSuggestionSearchGlobal;
        WebDriverWait wait;

        new Actions(driver).moveToElement(searchInput).click().perform();
        searchInput.sendKeys(subject);
        wait = new WebDriverWait(driver,10);
        jumpToSuggestionSearchGlobal = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("jump-to-suggestion-search-global")));
        jumpToSuggestionSearchGlobal.click();
    }

    public void clickOnSeleniumHQRepository(){
        seleniumHQRepositoryLink.click();
    }


    private GithubFileInformation getFileInformationFromLine(WebElement line){
        String contentString,messageString,dateTimeString;
        WebElement ageElement,ageTimeAgo;

        contentString = line.findElement(By.className("content")).getText();
        messageString = line.findElement(By.className("message")).getText();
        ageElement = line.findElement(By.className("age"));
        ageTimeAgo = ageElement.findElement(By.tagName("time-ago"));
        dateTimeString = ageTimeAgo.getAttribute("datetime");

        return new GithubFileInformation(contentString,messageString,dateTimeString);
    }

    public void verifyTheOldestCommit(){
        List<WebElement> filesList;
        Iterator<WebElement> filesListIterator;
        WebElement fileLine;
        GithubFileInformation oldestGithubFileInformation;

        filesList = filesTable.findElements(By.className("js-navigation-item"));
        filesListIterator = filesList.iterator();
        fileLine = filesListIterator.next();
        oldestGithubFileInformation = getFileInformationFromLine(fileLine);
        while (filesListIterator.hasNext()) {
            GithubFileInformation githubFileInformation;

            fileLine = filesListIterator.next();
            githubFileInformation = getFileInformationFromLine(fileLine);
            if (githubFileInformation.getDate().before(oldestGithubFileInformation.getDate())){
                oldestGithubFileInformation = githubFileInformation;
            }
        }
        System.out.println("The oldest commit information is:"+oldestGithubFileInformation.toString());
    }

}
