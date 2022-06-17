package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class LogInPage extends BaseTest {
    public LogInPage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = ".fa.fa-2x.fa-sign-in")
    private WebElement buttonLogin;

    @FindBy(id = "flash")
    private WebElement poruka;

    @FindBy(partialLinkText = "Elemental Selenium")
    private WebElement linkElemental;

    @FindBy(css = "[href=\"http://elementalselenium.com/\"]")
    private WebElement linkElemental2;

    @FindBy(css = ".row a img")
    private WebElement linkGitHub;


    public LogInPage popuniUserName(String prosledjenUserName){
        wdWait.until(ExpectedConditions.elementToBeClickable(userName));
        userName.clear();
        userName.sendKeys(prosledjenUserName);
        return this;
    }

    public LogInPage popuniPassword(String prosledjenPassword){
        wdWait.until(ExpectedConditions.elementToBeClickable(password));
        password.clear();
        password.sendKeys(prosledjenPassword);
        return this;
    }

    public void clickOnLoginButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(buttonLogin));
        buttonLogin.click();
    }

    public boolean messageIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(poruka));
        return poruka.isDisplayed();
    }

    public String messageText(){
        wdWait.until(ExpectedConditions.visibilityOf(poruka));
        return poruka.getText();
    }

    public void clickOnLinkElementalSelenium(){
        wdWait.until(ExpectedConditions.elementToBeClickable(linkElemental2));
        linkElemental2.click();
    }

    public void clickOnLinkGitHub(){
        wdWait.until(ExpectedConditions.elementToBeClickable(linkGitHub));
        linkGitHub.click();
    }
}
