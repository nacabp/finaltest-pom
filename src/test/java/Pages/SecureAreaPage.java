package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class SecureAreaPage extends BaseTest {
    public SecureAreaPage(){
        PageFactory.initElements(driver,this);
    }


    @FindBy(id = "flash")
    private WebElement poruka;

    @FindBy(css = ".button.secondary.radius")
    private WebElement buttonLogout;


    public boolean messageIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(poruka));
        return poruka.isDisplayed();
    }

    public String messageText(){
        wdWait.until(ExpectedConditions.visibilityOf(poruka));
        return poruka.getText();
    }

    public SecureAreaPage clickOnLogoutButton(){
        wdWait.until(ExpectedConditions.elementToBeClickable(buttonLogout));
        buttonLogout.click();
        return this;
    }
}
