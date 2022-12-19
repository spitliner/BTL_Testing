package org.webTest.moodles.testScenario;

import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.webTest.moodles.pages.LoginPage;
import org.webTest.moodles.pages.MainPage;

import java.util.ArrayList;
import java.util.List;


public class TestLogout {
    @Factory
    public Object [] runTest() {
        List<Object> testList = new ArrayList<>();
        testList.add(new SingleTestLogout("test1", "admin", "sandbox", Boolean.TRUE));
        return testList.toArray();
    }
}

class SingleTestLogout implements ITest {
    private String testCaseName;
    private String username;
    private String password;
    private Boolean expectResult;

    public SingleTestLogout(String testCaseName, String username, String password, Boolean expectResult) {
        this.testCaseName = testCaseName;
        this.username = username;
        this.password = password;
        this.expectResult = expectResult;
    }

    @Test
    public void runTest(ITestContext context) {
        List<WebDriver> webDriverList = (List<WebDriver>) context.getAttribute("WebDriversList");
        for (WebDriver driver: webDriverList) {
            driver.get("https://sandbox.moodledemo.net/");
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = mainPage.toLoginPage();
            loginPage.login(this.username, this.password);
            //System.out.println(this.expectResult);
            assert(loginPage.checkValidLogin() == expectResult);
        }
    }

    @Override
    public String getTestName() {
        return this.testCaseName;
    }
}
