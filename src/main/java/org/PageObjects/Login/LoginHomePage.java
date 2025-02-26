package org.PageObjects.Login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.PageObjects.BasePage;
import org.openqa.selenium.WebElement;

public abstract class LoginHomePage extends BasePage {
    @AndroidFindBy(accessibility = "input-email")
    private WebElement email;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement password;

    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement loginHeader;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement signUpHeader;

    public LoginHomePage(AndroidDriver driver) {
        super(driver);
    }

    public void inputEmail(String email) {
        this.email.sendKeys(email);
    }

    public void inputPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginHeader() {
        this.loginHeader.click();
    }

    public void clickSignUpHeader() {
        this.signUpHeader.click();
    }
}
