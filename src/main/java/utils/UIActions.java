package utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UIActions {
    private WebDriver driver;

    public UIActions(WebDriver driver) {
        this.driver = driver;
    }
    public void click(WebElement element) {
        element.click();
    }

    public void enterText(WebElement element, String text) {
        element.sendKeys(text);
    }
    public void clearField(WebElement element) {
        element.clear();
    }


}
