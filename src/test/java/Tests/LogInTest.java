package Tests;

import Base.BaseTest;
import Pages.ElementalPage;
import Pages.GitHubPage;
import Pages.LogInPage;
import Pages.SecureAreaPage;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class LogInTest extends BaseTest {
    private LogInPage logInPage;
    private SecureAreaPage secureAreaPage;
    private ElementalPage elementalPage;
    private GitHubPage gitHubPage;


    @Before
    public void setUpTest() {
        logInPage = new LogInPage();
        secureAreaPage = new SecureAreaPage();
        elementalPage = new ElementalPage();
        gitHubPage = new GitHubPage();
    }

    @Test
    public void secureAreaLoginTest(){
        logInPage.popuniUserName("tomsmith")
                .popuniPassword("SuperSecretPassword!")
                .clickOnLoginButton();
        Assert.assertTrue(secureAreaPage.messageIsDisplayed());
        Assert.assertEquals("You logged into a secure area!\n×", secureAreaPage.messageText());
        secureAreaPage.clickOnLogoutButton();
        Assert.assertTrue(logInPage.messageIsDisplayed());
        Assert.assertEquals("You logged out of the secure area!\n×", logInPage.messageText());
    }

    @Test
    public void shorterUsernameLoginTest(){
        logInPage.popuniUserName("tomsmit")
                .popuniPassword("SuperSecretPassword!")
                .clickOnLoginButton();
        Assert.assertTrue(logInPage.messageIsDisplayed());
        Assert.assertEquals("Your username is invalid!\n×", logInPage.messageText());
    }

    @Test
    public void longerUsernameLoginTest(){
        logInPage.popuniUserName("tomsmith1")
                .popuniPassword("SuperSecretPassword!")
                .clickOnLoginButton();
        Assert.assertTrue(logInPage.messageIsDisplayed());
        Assert.assertEquals("Your username is invalid!\n×", logInPage.messageText());
    }

    @Test
    public void emptyUsernameLoginTest(){
        logInPage.popuniUserName("")
                .popuniPassword("SuperSecretPassword!")
                .clickOnLoginButton();
        Assert.assertTrue(logInPage.messageIsDisplayed());
        Assert.assertEquals("Your username is invalid!\n×", logInPage.messageText());
    }

    @Test
    public void shorterPasswordLoginTest(){
        logInPage.popuniUserName("tomsmith")
                .popuniPassword("SuperSecretPassword")
                .clickOnLoginButton();
        Assert.assertTrue(logInPage.messageIsDisplayed());
        Assert.assertEquals("Your password is invalid!\n×", logInPage.messageText());
    }

    @Test
    public void longerPasswordLoginTest(){
        logInPage.popuniUserName("tomsmith")
                .popuniPassword("SuperSecretPassword!1")
                .clickOnLoginButton();
        Assert.assertTrue(logInPage.messageIsDisplayed());
        Assert.assertEquals("Your password is invalid!\n×", logInPage.messageText());
    }

    @Test
    public void emptyPasswordLoginTest(){
        logInPage.popuniUserName("tomsmith")
                .popuniPassword("")
                .clickOnLoginButton();
        Assert.assertTrue(logInPage.messageIsDisplayed());
        Assert.assertEquals("Your password is invalid!\n×", logInPage.messageText());
    }

    @Test
    public void emptyFieldsLoginTest(){
        logInPage.clickOnLoginButton();
        Assert.assertTrue(logInPage.messageIsDisplayed());
        Assert.assertEquals("Your username is invalid!\n×", logInPage.messageText());
    }

    @Test
    public void proveriLinkElemental(){
        logInPage.clickOnLinkElementalSelenium();
        elementalPage.moveToNewTab();
        Assert.assertTrue(elementalPage.textOnElementalIsDisplayed());
        Assert.assertEquals("Elemental Selenium", elementalPage.checkTextOnElemental());

    }

    @Test
    public void proveriLinkGitHub(){
        logInPage.clickOnLinkGitHub();
        Assert.assertTrue(gitHubPage.theInternetIsDisplayed());
        Assert.assertEquals("the-internet", gitHubPage.textTheInternet());
    }

}
