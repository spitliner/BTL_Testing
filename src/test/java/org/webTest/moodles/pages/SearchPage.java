package org.webTest.moodles.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    private WebDriver driver;

    private static final String search_bar_class = ".gLFyf.gsfi";

    @FindBy(className = search_bar_class)
    @CacheLookup
    WebElement search_bar;

    public SearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public SearchPage searchTerm(String term) {
        search_bar.sendKeys(term);
        search_bar.sendKeys(Keys.ENTER);
        return new SearchPage(driver);
    }
}
