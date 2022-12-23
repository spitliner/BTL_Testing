package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.webTest.moodles.supporters.MiscellaneousFunctions;

import java.util.List;

public class CourseAndCategoryManager extends Page {
    private static final String categoryListXpath = "//a[contains(@class,'categoryname')]";
    private static final String expandSubCategoryXpath = "//i[@Title='Expand']";
    private static final String courseListXpath = "//ul[contains(@class,'course-list')]//li";

    @FindBy(xpath = categoryListXpath)
    List<WebElement> categoryList;

    @FindBy(xpath = expandSubCategoryXpath)
    List<WebElement> expandSubCategoryElementList;

    @FindBy(xpath = courseListXpath)
    List<WebElement> courseList;

    public CourseAndCategoryManager(WebDriver driver) {
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void ExpandSubCategory() {
        List<WebElement> elementList;
        while (0 != expandSubCategoryElementList.size()) {
            elementList = expandSubCategoryElementList;
            for (WebElement element: elementList) {
                element.click();
            }
        }
    }

    public Boolean SelectCategory(final String categoryName) {
        this.ExpandSubCategory();
        WebElement element = MiscellaneousFunctions.findElementWithString(this.categoryList, categoryName);
        if (null != element) {
            element.click();
        }
        return Boolean.FALSE;
    }

    public Boolean SelectCourse(final String courseName) {
        for (WebElement element:this.courseList) {
            //System.out.println(element.getText());

        }
        return Boolean.FALSE;
    }
}
