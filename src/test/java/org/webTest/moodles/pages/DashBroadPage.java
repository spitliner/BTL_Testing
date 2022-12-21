package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webTest.moodles.supporters.MiscellaneousFunctions;

import java.util.List;

public class DashBroadPage extends Page{
    private static final String menuXpath = "//ul[@role='tablist' and contains(@id,'moremenu')]//a";
    private static final String subMenuXpath = "//div[@id='linkroot']//div[@class='row']//h4//a";
    private static final String subSubMenuXpath = "//div[@id='linkroot']//div[@class='row']//li//a";

    @FindBy(xpath = menuXpath)
    @CacheLookup
    List<WebElement> menuItems;

    @FindBy(xpath = subMenuXpath)
    List<WebElement> subMenuItem;

    @FindBy(xpath = subSubMenuXpath)
    List<WebElement> subSubMenuItems;
    public DashBroadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    private Boolean clickItemInList(final String listName, final String itemText) {
        
    }

    public Boolean getMenu(final String menuName) {
        WebElement element = MiscellaneousFunctions.findElementWithString(this.menuItems, menuName);
        if (null != element) {
            element.click();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    @Override
    public DashBroadPage currentPage() {
        return this;
    }
}
