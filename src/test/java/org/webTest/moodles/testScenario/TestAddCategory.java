package org.webTest.moodles.testScenario;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.webTest.moodles.pages.AddCategoryPage;
import org.webTest.moodles.pages.LoginPage;
import org.webTest.moodles.pages.MainPage;

import java.util.ArrayList;
import java.util.List;

public class TestAddCategory {
    @Factory
    public Object [] runTest() {
        List<Object> testList = new ArrayList<>();
        testList.add(new SingleAdd("test1", "Fullstack", "1", Boolean.TRUE));
        testList.add(new SingleAdd("test2", "Fullstack", "2", Boolean.TRUE));
        testList.add(new SingleAdd("test3", "Database", "2", Boolean.FALSE));
        testList.add(new SingleAdd("test4", "Database", "", Boolean.TRUE));
        testList.add(new SingleAdd("test5", "", "3", Boolean.FALSE));
        return testList.toArray();
    }
}

class SingleAdd extends TestAuxiliary {
    private String testCaseName;
    private String category;
    private String id;
    private Boolean expectResult;

    public SingleAdd(String testCaseName, String category, String id, Boolean expectResult) {
        this.testCaseName = testCaseName;
        this.category = category;
        this.id = id;
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

            driver.get("https://sandbox.moodledemo.net/course/editcategory.php?parent=0");
            AddCategoryPage addCategoryPage = new AddCategoryPage(driver);
            addCategoryPage.add(this.category, this.id);

            mainPage.logOut();
            //assert(loginPage.checkValidLogin() == expectResult);
        }
    }
}
