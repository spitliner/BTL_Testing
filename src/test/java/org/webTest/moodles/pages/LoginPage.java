package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LoginPage {
    private WebDriver driver;
    private static final String usernameInputBoxXpath = "//input[@id='username']";
    private static final String passwordInputBoxXpath = "//input[@id='password']";
    private static final String loginButtonXpath = "//button[@id='loginbtn']";
    private static final String loginAsGuestButtonXpath = "//button[@id='loginguestbtn']";
    private static final String invalidLoginWarningXpath = "//div[contains(@class,'alert')]";

    @FindBy(xpath = usernameInputBoxXpath)
    @CacheLookup
    WebElement usernameBox;

    @FindBy(xpath = passwordInputBoxXpath)
    @CacheLookup
    WebElement passwordBox;

    @FindBy(xpath = loginButtonXpath)
    @CacheLookup
    WebElement loginButton;

    @FindBy(xpath = loginAsGuestButtonXpath)
    @CacheLookup
    WebElement loginAsGuestButton;
    @FindBy(xpath = invalidLoginWarningXpath)
    List<WebElement> invalidLoginWarning;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public MainPage login(String username, String password) {
        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
        return new MainPage(this.driver);
    }

    public void loginAsGuest() {
        loginAsGuestButton.click();
    }

    public Boolean checkValidLogin() {
        return 0 == invalidLoginWarning.size();
    }
}
