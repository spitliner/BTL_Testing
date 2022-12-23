package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webTest.moodles.supporters.MiscellaneousFunctions;

import java.util.List;

public class DashBroadPage extends Page{
    public DashBroadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    @Override
    public DashBroadPage currentPage() {
        return this;
    }
}
