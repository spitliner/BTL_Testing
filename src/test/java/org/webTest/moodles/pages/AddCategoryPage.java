package org.webTest.moodles.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddCategoryPage extends Page{

    private static final String idCategoryXpath = "//div[@id='fitem_id_idnumber']//input";
    private static final String nameCategoryXpath = "//div[@id='fitem_id_name']//input";
    private static final String submitXpath = "//input[@id='id_submitbutton']";


    @FindBy(xpath = idCategoryXpath)
    @CacheLookup
    WebElement idCategory;

    @FindBy(xpath = nameCategoryXpath)
    @CacheLookup
    WebElement nameCategory;

    @FindBy(xpath = submitXpath)
    @CacheLookup
    WebElement submitBtn;
    public AddCategoryPage(WebDriver driver){
        super(driver);
        PageFactory.initElements(this.driver, this);
    }

    public void add(String category, String id) {
        nameCategory.sendKeys(category);
        idCategory.sendKeys(id);
        submitBtn.click();
    }

    @Override
    public AddCategoryPage currentPage() {
        return this;
    }
}
