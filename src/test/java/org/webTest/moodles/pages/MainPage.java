package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {
    private WebDriver driver;

    private static final String logInXPath = "//a[text()='Log in']";

    @FindBy(xpath = logInXPath)
    @CacheLookup
    private WebElement logInButton;

    public MainPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    public LoginPage toLoginPage() {
        logInButton.click();
        return new LoginPage(this.driver);
    }
}
