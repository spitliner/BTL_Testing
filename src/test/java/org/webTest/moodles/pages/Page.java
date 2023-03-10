package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.lang.model.type.NullType;
import java.util.List;

public class Page {
    protected WebDriver driver;

    private static final String homeXpath = "//li[@data-key='home']//a";
    private static final String dashBroadXpath = "//li[@data-key='myhome']//a";
    private static final String courseXpath = "//li[@data-key='mycourse']//a";
    private static final String siteAdminXpath = "//li[@data-key='siteadminnode']//a";

    private static final String moreXpath = "//li[@data-key='morebutton']//a";
    private static final String logInXPath = "//span[@class='login pl-2']//a";

    private static final String userDropDownMenuXpath = "//a[@id='user-menu-toggle']";

    private static final String isNotLoginXpath = "//span[@class='login pl-2']";

    private static final String logOutButtonXpath = "//div[@id='usermenu-carousel']//a[contains(.,'Log out')]";

    @FindBy(xpath = homeXpath)
    @CacheLookup
    private WebElement homeButton;

    @FindBy(xpath = dashBroadXpath)
    @CacheLookup
    private WebElement dashBroadButton;

    @FindBy(xpath = courseXpath)
    @CacheLookup
    private WebElement courseButton;

    @FindBy(xpath = siteAdminXpath)
    @CacheLookup
    private WebElement siteAdminButton;

    @FindBy(xpath = siteAdminXpath)
    private List<WebElement> siteAdminList;

    @FindBy(xpath = logInXPath)
    @CacheLookup
    private WebElement logInButton;

    @FindBy(xpath = userDropDownMenuXpath)
    @CacheLookup
    private WebElement userDropDownMenu;

    @FindBy(xpath = logOutButtonXpath)
    private WebElement logOutButton;

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

    public Select getUserDropdownMenu(){
        return new Select(userDropDownMenu);
    }

    public DashBroadPage goDashBroad() {
        this.dashBroadButton.click();
        return new DashBroadPage(driver);
    }

    public SiteAdministration goSiteAdmin() {
        if (0 != this.siteAdminList.size()) {
            this.siteAdminButton.click();
            return new SiteAdministration(this.driver);
        }
        return null;
    }

    public LoginPage toLoginPage() {
        logInButton.click();
        return new LoginPage(this.driver);
    }

    public Page logOut() {
        if (this.isLogin()) {
            this.userDropDownMenu.click();
            this.logOutButton.click();
            return new MainPage(this.driver);
        }
        return this.currentPage();
    }

    public Boolean isLogin() {
        return (0 == this.isNotLogin.size());
    }

    public Page currentPage() {
        return this;
    }

}
