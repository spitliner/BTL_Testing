package org.webTest.moodles.testScenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITest;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.webTest.moodles.pages.LoginPage;
import org.webTest.moodles.pages.MainPage;

import java.util.ArrayList;
import java.util.List;



public class TestLogin implements ITest {
    private String testCaseName;

    public TestLogin(String testCaseName) {
        this.testCaseName = testCaseName;

    }

    @Override
    public String getTestName() {
        return this.testCaseName;
    }
}
