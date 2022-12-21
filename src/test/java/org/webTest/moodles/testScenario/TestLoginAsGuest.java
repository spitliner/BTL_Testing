package org.webTest.moodles.testScenario;

import org.openqa.selenium.WebDriver;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.webTest.moodles.pages.LoginPage;
import org.webTest.moodles.pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class TestLoginAsGuest {
    @Factory
    public Object[] runTest() {
        List<Object> testList = new ArrayList<>();
        testList.add((new SingleTestLoginAsGuest("test1", Boolean.TRUE)));
        testList.add((new SingleTestLogin("test2","guest","guest",Boolean.TRUE)));
        testList.add((new SingleTestLogin("test3","","guest",Boolean.FALSE)));
        testList.add((new SingleTestLogin("test4","guest","",Boolean.FALSE)));
        testList.add((new SingleTestLogin("test5","sdfsdfs","guest",Boolean.FALSE)));
        testList.add((new SingleTestLogin("test6","guest","sdfsdfs",Boolean.FALSE)));
        return testList.toArray();
    }
}

class SingleTestLoginAsGuest extends TestAuxiliary {
    private String testCaseName;
    private Boolean expectResult;

    public SingleTestLoginAsGuest(String testCaseName, Boolean expectResult) {
        this.testCaseName = testCaseName;
        this.expectResult = expectResult;
    }

    @Test
    public void runTest(ITestContext context) {
        List<WebDriver> webDriverList = (List<WebDriver>) context.getAttribute("WebDriversList");
        for (WebDriver driver: webDriverList) {
            driver.get("https://sandbox.moodledemo.net/");
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = mainPage.toLoginPage();
            loginPage.loginAsGuest();
            //System.out.println(this.expectResult);
            assert(loginPage.checkValidLogin() == expectResult);
        }
    }

    @Override
    public String getTestName() {
        return this.testCaseName;
    }
}
