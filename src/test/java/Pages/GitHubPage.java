package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class GitHubPage extends BaseTest {
    public GitHubPage(){
        PageFactory.initElements(driver,this);
    }

//    @FindBy(partialLinkText = "the-internet")
    @FindBy(css = "[href=\"/saucelabs/the-internet\"]")
    private WebElement theInternet;

    public boolean theInternetIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(theInternet));
        return theInternet.isDisplayed();
    }

    public String textTheInternet(){
        wdWait.until(ExpectedConditions.visibilityOf(theInternet));
        return theInternet.getText();
    }

}
