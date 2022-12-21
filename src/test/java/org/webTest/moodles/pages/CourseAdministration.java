package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class CourseAdministration extends Page{
    public CourseAdministration(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }
}
