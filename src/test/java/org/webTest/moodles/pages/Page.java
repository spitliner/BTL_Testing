package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class Page {
    protected WebDriver driver;

    private static final String homeXpath = "//li[@data-key='home']//a";
    private static final String dashBroadXpath = "//li[@data-key='myhome']//a";
    private static final String courseXpath = "//li[@data-key='mycourse']//a";

    private static final String moreXpath = "//li[@data-key='morebutton']//a";
    private static final String logInXPath = "//span[@class='login pl-2']//a";

    private static final String isNotLoginXpath = "//span[@class='login pl-2']";

    @FindBy(xpath = homeXpath)
    @CacheLookup
    private WebElement homeButton;

    @FindBy(xpath = dashBroadXpath)
    @CacheLookup
    private WebElement dashBroadButton;

    @FindBy(xpath = courseXpath)
    @CacheLookup
    private WebElement courseButton;

    @FindBy(xpath = logInXPath)
    @CacheLookup
    private WebElement logInButton;

    @FindBy(xpath = isNotLoginXpath)
    @CacheLookup
    private List<WebElement> isNotLogin;

    public Page (WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public MainPage goHomePage() {
        this.homeButton.click();
        return new MainPage(this.driver);
    }

    public DashBroadPage goDashBroad() {
        this.dashBroadButton.click();
        return new DashBroadPage(driver);
    }

    public LoginPage toLoginPage() {
        logInButton.click();
        return new LoginPage(this.driver);
    }

    public Boolean isLogin() {
        return (0 != this.isNotLogin.size());
    }

}
