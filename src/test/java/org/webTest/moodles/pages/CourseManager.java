package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CourseManager extends CourseAndCategoryManager {
    public CourseManager(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
}
