package pixeon.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract class BasePage {
    protected WebDriver driver;

    @FindBy(how = How.TAG_NAME, using = "body")
    private WebElement body;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void visit(String url){
       driver.get(url);
    }

    public void hasText(String text){
        String bodyText = body.getText();
        Assert.assertTrue(bodyText.contains(text));
    }

    public void putMousePointerOn(WebElement element){
        Actions mouseHover;
        Wait wait;

        mouseHover = new Actions(driver);
        wait = new WebDriverWait(driver,10);
        wait.until(ExpectedConditions.visibilityOf(element));
        mouseHover.moveToElement(element).perform();
    }
}
