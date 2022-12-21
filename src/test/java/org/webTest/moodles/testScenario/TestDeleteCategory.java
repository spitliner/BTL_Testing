package org.webTest.moodles.testScenario;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.webTest.moodles.pages.AddCategoryPage;
import org.webTest.moodles.pages.DeleteCategoryPage;
import org.webTest.moodles.pages.LoginPage;
import org.webTest.moodles.pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class TestDeleteCategory {
    @Factory
    public Object [] runTest() {
        List<Object> testList = new ArrayList<>();
        testList.add(new SingleDelete("test1", Boolean.TRUE));
        return testList.toArray();
    }
}

class SingleDelete extends TestAuxiliary {
    private String testCaseName;
    private Boolean expectResult;

    public SingleDelete(String testCaseName, Boolean expectResult) {
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
            mainPage = loginPage.login("admin", "sandbox");

            driver.get("https://sandbox.moodledemo.net/course/management.php");
            DeleteCategoryPage deleteCategoryPage = new DeleteCategoryPage(driver);
            deleteCategoryPage.delete();

            mainPage.logOut();
            //assert(loginPage.checkValidLogin() == expectResult);
        }
    }
}
