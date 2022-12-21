package org.webTest.moodles.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class DeletePage extends Page{
    public DeletePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void confirm() {
        driver.findElement(By.xpath("//input[@id='id_submitbutton']")).click();
        driver.navigate().to("https://sandbox.moodledemo.net/course/management.php?");
    }

    @Override
    public DeletePage currentPage() {
        return this;
    }
}
