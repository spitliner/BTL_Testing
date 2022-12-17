package org.webTest.moodles.testScenario;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.ITestContext;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import java.util.ArrayList;
import java.util.List;

public class TestAuxiliary {
    public TestAuxiliary() {
        System.setProperty("webdriver.chrome.driver", "Binary\\chromedriver.exe");
        System.setProperty("webdriver.gecko.driver", "Binary\\geckodriver.exe");
        System.setProperty("webdriver.edge.driver", "Binary\\msedgedriver.exe");
    }

    @BeforeSuite
    public void prepareSuit() {

    }

    @BeforeTest
    public void prepareTest(ITestContext context) {
        List<WebDriver> WebDriversList = new ArrayList<>();
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setBinary("C:\\Program Files\\Mozilla Firefox\\firefox.exe");
        WebDriversList.add(new FirefoxDriver(firefoxOptions));
        WebDriversList.add(new EdgeDriver());
        WebDriversList.add(new ChromeDriver());
        context.setAttribute("WebDriversList", WebDriversList);
    }

    @AfterTest
    public void clearTest(ITestContext context) {
        List<WebDriver> WebDriversList = (List<WebDriver>) context.getAttribute("WebDriversList");
        for (WebDriver driver:WebDriversList) {
            driver.quit();
        }
    }
}