package org.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class HomeListPage extends BasePage {
    // Test Page Factory works with AndroidDriver
//    @AndroidFindBy( = "App")
//    WebElement appOption;

    @AndroidFindBy(xpath = "//android.widget.TextView[@content-desc=\"Content\"]")
    WebElement contentOption;

    public HomeListPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickButton() {
        contentOption.click();
    }
}
