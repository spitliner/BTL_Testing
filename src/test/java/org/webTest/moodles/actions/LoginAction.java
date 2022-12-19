package org.webTest.moodles.actions;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import org.webTest.moodles.pages.LoginPage;
import org.webTest.moodles.pages.MainPage;
import org.webTest.moodles.pages.Page;

public class LoginAction {
    private WebDriver driver;
    private Page currentPage;
    private String username;
    private String password;
    public LoginAction(WebDriver driver, Page currentPage, String username, String password) {
        this.driver = driver;
        this.currentPage = currentPage;
        this.username = username;
        this.password = password;
    }

    public MainPage run() {
        LoginPage loginPage = this.currentPage.toLoginPage();
        loginPage.login(this.username, this.password);
        return new MainPage(this.driver);
    }
}
