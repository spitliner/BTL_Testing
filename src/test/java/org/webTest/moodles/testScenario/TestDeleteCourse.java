package org.webTest.moodles.testScenario;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.webTest.moodles.pages.CourseAndCategoryManager;
import org.webTest.moodles.pages.LoginPage;
import org.webTest.moodles.pages.MainPage;
import org.webTest.moodles.pages.SiteAdministration;

import java.util.ArrayList;
import java.util.List;

public class TestDeleteCourse {
    @Factory
    public Object [] runTest() {
        List<Object> testList = new ArrayList<>();
        testList.add(new SingleTestDeleteCourse("test1", "admin", "sandbox","My first course", "Miscellaneous", Boolean.TRUE));
        //testList.add(new SingleTestDeleteCourse("test1", "admin", "sandbox","My second course", "Miscellaneous", Boolean.FALSE));
        return testList.toArray();
    }
}

class SingleTestDeleteCourse extends TestAuxiliary {
    private String username;
    private String password;
    private String courseName;
    private String courseCatagory;
    private Boolean isSearch;
    public SingleTestDeleteCourse(final String testName,
                                  final String username,
                                  final String password,
                                  final String courseName,
                                  final String courseCategory,
                                  final Boolean isSearch) {
        this.testCaseName = testName;
        this.username = username;
        this.password = password;
        this.courseName = courseName;
        this.courseCatagory = courseCategory;
        this.isSearch = isSearch;
    }

    @Test
    public void run(ITestContext context) {
        List<WebDriver> webDriverList = (List<WebDriver>) context.getAttribute("WebDriversList");
        for (WebDriver driver: webDriverList) {
            Boolean resultFlag;
            driver.get("https://sandbox.moodledemo.net/");
            MainPage mainPage = new MainPage(driver);
            LoginPage loginPage = mainPage.toLoginPage();
            mainPage = loginPage.login(this.username, this.password);
            SiteAdministration siteAdministration = mainPage.goSiteAdmin();
            siteAdministration.gotoMenu("Courses");
            resultFlag = siteAdministration.gotoSubSubMenu("Manage courses and categories");
            CourseAndCategoryManager courseAndCategoryManager = new CourseAndCategoryManager(driver);
            courseAndCategoryManager.SelectCategory("Miscellaneous");
            courseAndCategoryManager.SelectCourse("");
        }
    }
}

