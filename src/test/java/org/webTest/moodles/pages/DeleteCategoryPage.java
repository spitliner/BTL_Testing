package org.webTest.moodles.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class DeleteCategoryPage extends Page{
    public DeleteCategoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void delete() {
        String xpath = "//ul[@aria-labelledby='category-listing-title']//li[@class='listitem-category']";
        List<WebElement>  idList = driver.findElements(By.xpath(xpath));

        if (idList.size() == 1) {
            driver.get("https://sandbox.moodledemo.net/course/editcategory.php?parent=0");
            AddCategoryPage addCategoryPage = new AddCategoryPage(driver);
            addCategoryPage.add("Bingo", "100");
        }
        xpath = "//a[@id='action-menu-toggle-1']";
        driver.findElement(By.xpath(xpath)).click();

        xpath = "//div[@id='action-menu-1-menu']//a[@data-action='delete']";
        driver.findElement(By.xpath(xpath)).click();

        DeletePage confirm = new DeletePage(driver);
        confirm.confirm();
    }

    @Override
    public DeleteCategoryPage currentPage() {
        return this;
    }
}
