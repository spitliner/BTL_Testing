package org.webTest.moodles.supporters;

import org.openqa.selenium.WebElement;

import java.util.List;

public class MiscellaneousFunctions {
    public static WebElement findElementWithString(final List<WebElement> elementsList, final String text) {
        for (WebElement element: elementsList) {
            if (element.getText().contains(text)) {
                return element;
            }
        }
        return null;
    }
}
