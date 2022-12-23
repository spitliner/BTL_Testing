package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.webTest.moodles.supporters.MiscellaneousFunctions;
import org.webTest.moodles.testScenario.TestAuxiliary;

import java.util.List;

public class SiteAdministration extends Page {
    private static final String menuXpath = "//ul[@role='tablist' and contains(@id,'moremenu')]//a";
    private static final String subMenuXpath = "//div[@id='linkcourses']//div[@class='row']//h4//a";
    private static final String subSubMenuXpath = "//div[@id='linkcourses']//div[@class='row']//li//a";

    @FindBy(xpath = menuXpath)
    @CacheLookup
    List<WebElement> menuItems;

    @FindBy(xpath = subMenuXpath)
    List<WebElement> subMenuItem;

    @FindBy(xpath = subSubMenuXpath)
    List<WebElement> subSubMenuItems;

    public SiteAdministration(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public Boolean gotoMenu(final String menuName) {
        WebElement element = MiscellaneousFunctions.findElementWithString(this.menuItems, menuName);
        if (null != element) {
            element.click();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean gotoSubMenu(final String subMenuName) {
        WebElement element = MiscellaneousFunctions.findElementWithString(this.subMenuItem, subMenuName);
        if (null != element) {
            element.click();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }

    public Boolean gotoSubSubMenu(final String subSubMenuName) {
        WebElement element = MiscellaneousFunctions.findElementWithString(this.subSubMenuItems, subSubMenuName);
        if (null != element) {
            element.click();
            return Boolean.TRUE;
        }
        return Boolean.FALSE;
    }
}
