package org.webTest.moodles.testScenario;

import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.webTest.moodles.pages.LoginPage;
import org.webTest.moodles.pages.MainPage;

import java.util.ArrayList;
import java.util.List;


public class TestLogin {
    @Factory
    public Object [] runTest() {
        List<Object> testList = new ArrayList<>();
        testList.add(new SingleTestLogin("test1", "admin", "sandbox", Boolean.TRUE));
        testList.add(new SingleTestLogin("test2", "teacher", "sandbox", Boolean.TRUE);
        testList.add(new SingleTestLogin("test3", "teacher", "aaa", Boolean.FALSE));
        return testList.toArray();
    }
}

class SingleTestLogin extends TestAuxiliary {
    private String testCaseName;
    private String username;
    private String password;
    private Boolean expectResult;

    public SingleTestLogin(String testCaseName, String username, String password, Boolean expectResult) {
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
            mainPage = loginPage.login(this.username, this.password);
            System.out.println(this.expectResult);
            mainPage.logOut();
            //assert(loginPage.checkValidLogin() == expectResult);
        }
    }
}
