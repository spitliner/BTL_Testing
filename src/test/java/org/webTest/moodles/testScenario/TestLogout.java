package org.webTest.moodles.testScenario;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.webTest.moodles.pages.LoginPage;
import org.webTest.moodles.pages.Page;
import org.webTest.moodles.pages.MainPage;

import java.util.ArrayList;
import java.util.List;



public class TestLogout {
    @Factory
    public Object [] runTest() {
        List<Object> testList = new ArrayList<>();
//        testList.add(new SingleTestLogout("test1", "admin", "sandbox"));
//        testList.add(new SingleTestLogoutDeleteCache("test2", "admin", "sandbox"));
        testList.add(new SingleTestLogout2("test3", "admin", "sandbox"));
        return testList.toArray();
    }
}

class SingleTestLogout extends TestAuxiliary {
    private String testCaseName;
    private String username;
    private String password;

    public SingleTestLogout(String testCaseName, String username, String password) {
        this.testCaseName = testCaseName;
        this.username = username;
        this.password = password;
    }

    @Test
    public void runTest(ITestContext context) {
        List<WebDriver> webDriverList = (List<WebDriver>) context.getAttribute("WebDriversList");
        for (WebDriver driver: webDriverList) {
            driver.get("https://sandbox.moodledemo.net/");
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = mainPage.toLoginPage();
            mainPage = loginPage.login(this.username, this.password);
//            System.out.println(loginPage.checkValidLogin());
            assert(loginPage.checkValidLogin() == Boolean.TRUE);
            mainPage = (MainPage) mainPage.logOut();
//            System.out.println(mainPage.isLogin());
            assert(mainPage.isLogin() == Boolean.FALSE);
        }
    }
}

class SingleTestLogoutDeleteCache extends TestAuxiliary {
    private String testCaseName;
    private String username;
    private String password;

    public SingleTestLogoutDeleteCache(String testCaseName, String username, String password) {
        this.testCaseName = testCaseName;
        this.username = username;
        this.password = password;
    }

    @Test
    public void runTest(ITestContext context) {
        List<WebDriver> webDriverList = (List<WebDriver>) context.getAttribute("WebDriversList");
        for (WebDriver driver: webDriverList) {
            driver.get("https://sandbox.moodledemo.net/");
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = mainPage.toLoginPage();
            loginPage.login(this.username, this.password);
//            System.out.println(loginPage.checkValidLogin());
            assert(loginPage.checkValidLogin() == Boolean.TRUE);

            driver.manage().deleteAllCookies();
            driver.navigate().refresh();
            Page currentPage = new Page(driver);
            System.out.println(currentPage.isLogin());
            assert(currentPage.isLogin() == Boolean.FALSE);
        }
    }
}

class SingleTestLogout2 extends TestAuxiliary {
    private String testCaseName;
    private String username;
    private String password;

    public SingleTestLogout2(String testCaseName, String username, String password) {
        this.testCaseName = testCaseName;
        this.username = username;
        this.password = password;
    }

    @Test
    public void runTest(ITestContext context) {
        List<WebDriver> webDriverList = (List<WebDriver>) context.getAttribute("WebDriversList");
        for (WebDriver driver: webDriverList) {
            driver.get("https://sandbox.moodledemo.net/");
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = mainPage.toLoginPage();
            mainPage = loginPage.login(this.username, this.password);
//            System.out.println(loginPage.checkValidLogin());
            assert(loginPage.checkValidLogin() == Boolean.TRUE);

            Page randomPage = mainPage.goDashBroad();
            driver.manage().deleteAllCookies();
            driver.navigate().refresh();

            var checkCond = ExpectedConditions.urlContains("/login");
            System.out.println(checkCond.apply(driver));
            assert(checkCond.apply(driver));
        }
    }
}
