package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public abstract class Page {
    protected WebDriver driver;

    private static final String homeXpath = "//li[@data-key='home']//a";
    private static final String dashBroadXpath = "//li[@data-key='myhome']//a";
    private static final String courseXpath = "//li[@data-key='mycourse']//a";

    private static final String moreXpath = "//li[@data-key='morebutton']//a";

    @FindBy(xpath = homeXpath)
    @CacheLookup
    private WebElement homeButton;

    @FindBy(xpath = dashBroadXpath)
    @CacheLookup
    private WebElement dashBroadButton;

    @FindBy(xpath = courseXpath)
    @CacheLookup
    private WebElement courseButton;

    public Page (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public MainPage goHomePage() {
        this.homeButton.click();
        return new MainPage(this.driver);
    }

    public void goDashBroad() {
        this.dashBroadButton.click();

    }

    //public

}
