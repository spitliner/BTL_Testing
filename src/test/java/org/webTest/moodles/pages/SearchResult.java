package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SearchResult {
    private WebDriver driver;

    private static final String target_xpath = "//div[cite[contains(.,'trinhhoangtien.vn')]]";

    private static final String nextResult_xpath = "//span[text()='Tiếp']";

    @FindBy(xpath = target_xpath)
    List<WebElement> target;

    @FindBy(xpath = nextResult_xpath)
    List<WebElement> nexResult;

    public SearchResult(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, driver);
    }

    public Boolean getTarget() {
        while (0 != nexResult.size()) {
            if (0 != target.size()) {
                target.get(0).click();
                return true;
            }
        }
        return false;
    }
}
