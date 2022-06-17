package Pages;

import Base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;

public class ElementalPage extends BaseTest {
    public ElementalPage(){
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = ".large-12.columns.text-center h1")
    private WebElement textOnElemental;

    public void moveToNewTab(){
        wdWait.until(ExpectedConditions.numberOfWindowsToBe(2));
        ArrayList<String> tabs =  new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
    }

    public boolean textOnElementalIsDisplayed(){
        wdWait.until(ExpectedConditions.visibilityOf(textOnElemental));
        return textOnElemental.isDisplayed();
    }

    public String checkTextOnElemental(){
        wdWait.until(ExpectedConditions.visibilityOf(textOnElemental));
        return textOnElemental.getText();
    }
}
