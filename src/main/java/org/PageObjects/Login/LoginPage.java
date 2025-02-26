package org.PageObjects.Login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends LoginHomePage {
    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginButton;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }
}
