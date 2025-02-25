package org.PageObjects;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class BottomNavBar extends BasePage {
    @AndroidFindBy(accessibility = "Home")
    private WebElement home;

    @AndroidFindBy(accessibility = "Webview")
    private WebElement webView;

    @AndroidFindBy(accessibility = "Login")
    private WebElement login;

    @AndroidFindBy(accessibility = "Forms")
    private WebElement forms;

    @AndroidFindBy(accessibility = "Swipe")
    private WebElement swipe;

    @AndroidFindBy(accessibility = "Drag")
    private WebElement drag;

    public BottomNavBar(AndroidDriver driver) {
        super(driver);
    }

    private void clickHome() {
        this.home.click();
    }

    private void clickWebview() {
        this.webView.click();
    }

    private void clickLogin() {
        this.login.click();
    }

    private void clickForms() {
        this.forms.click();
    }

    private void clickSwipe() {
        this.swipe.click();
    }

    private void clickDrag() {
        this.drag.click();
    }
}
