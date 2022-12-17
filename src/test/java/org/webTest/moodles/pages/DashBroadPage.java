package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class DashBroadPage extends Page{
    public DashBroadPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
}
