package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class SiteAdministration extends Page {
    private static final String categoryXpath = "//div[@id='category-listing']//ul//a[contains(@class,'categoryname')]";
    public SiteAdministration(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }


}
