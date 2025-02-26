package org.PageObjects.BottomNavigationBar;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.PageObjects.BasePage;
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

    public void clickHome() {
        this.home.click();
    }

    public void clickWebview() {
        this.webView.click();
    }

    public void clickLogin() {
        this.login.click();
    }

    public void clickForms() {
        this.forms.click();
    }

    public void clickSwipe() {
        this.swipe.click();
    }

    public void clickDrag() {
        this.drag.click();
    }
}
