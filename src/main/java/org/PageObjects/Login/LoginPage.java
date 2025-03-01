package org.PageObjects.Login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class LoginPage extends LoginHomePage {
    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "(//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup" +
            "/android.view.ViewGroup/android.view.ViewGroup[4]//following-sibling::android.widget.TextView)[2]")
    private WebElement invalidEmailPromptMsg;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void fillLoginPage(String email, String password) {
        /**
         * Cases:
         * Invalid Email
         * Invalid Password (Empty)
         * Invalid Password (too short)
         */

        this.inputEmail(email);
        this.inputPassword(password);
        this.clickLoginButton();
        this.processAlertPanel();
    }

    public boolean invalidEmailMsgDisplayed() {
        return !this.invalidEmailPromptMsg.getText().isEmpty();
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }
}
