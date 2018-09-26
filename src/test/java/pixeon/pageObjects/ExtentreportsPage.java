package pixeon.pageObjects;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ExtentreportsPage extends BasePage {
    public ExtentreportsPage(WebDriver driver){
        super(driver);
    }

    @FindBy(how = How.LINK_TEXT, using = "DOCUMENTATION")
    private WebElement documentationLink;

    @FindBy(how = How.LINK_TEXT, using = "Version 3")
    private WebElement versionThreeLink;

    @FindBy(how = How.ID, using = "menu-extent-header")
    private WebElement topMenu;

    @FindBy(how = How.ID, using = "rightCol")
    private WebElement rightCol;

    @FindBy(how = How.ID, using = "menu-item-1538")
    private WebElement javaLink;

    public void clickOnVersionThreeOfJavaMenuDocumentation() {
        putMousePointerOn(documentationLink);
        putMousePointerOn(versionThreeLink);
        putMousePointerOn(javaLink);
        javaLink.click();
    }

    private Map<String,Integer> mapTableHeaderIndex(WebElement table){
        WebElement tr;
        List<WebElement> tdList;
        Map<String,Integer> map;

        map = new HashMap<String,Integer>();
        tr = table.findElement(By.tagName("thead"));
        tdList = tr.findElements(By.tagName("td"));
        for ( int i = 0; i < tdList.size() ; i++ ){
            map.put(tdList.get(i).getText(),Integer.valueOf(i));
        }
        return map;
    }

    public void verifyOfflineReportInProVersion() {
        WebElement offlineReportLink, offlineReportLineTR, offlineReportInProVersionTD, communityVsProTable;
        WebElement offlineReportInProVersionI;
        List<WebElement> offLineReportList;
        Map<String,Integer> headMap;

        communityVsProTable = rightCol.findElement(By.className("table"));
        headMap = mapTableHeaderIndex(communityVsProTable);
        offlineReportLink = communityVsProTable.findElement(By.linkText("Offline report"));
        offlineReportLineTR = offlineReportLink.findElement(By.xpath("./..")).findElement(By.xpath("./.."));
        offLineReportList = offlineReportLineTR.findElements(By.tagName("td"));
        offlineReportInProVersionTD = offLineReportList.get(headMap.get("Pro"));
        offlineReportInProVersionI = offlineReportInProVersionTD.findElement(By.tagName("i"));
        Assert.assertEquals("fa fa-check text-success",offlineReportInProVersionI.getAttribute("class"));


    }
}
