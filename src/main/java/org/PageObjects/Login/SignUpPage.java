package org.PageObjects.Login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.WebElement;

public class SignUpPage extends LoginHomePage {
    @AndroidFindBy(accessibility = "input-repeat-password")
    private WebElement confirmPassword;

    @AndroidFindBy(accessibility = "button-SIGN UP")
    private WebElement signUpButton;

    public SignUpPage(AndroidDriver driver) {
        super(driver);
    }

    public void fillSignUpPage(String email, String password, String confirmPassword) {
        /**
         * Cases:
         * Invalid Email
         * Invalid Password (Empty)
         * Invalid Password (too short)
         * Passwords don't match
         */

        this.inputEmail(email);
        this.inputPassword(password);
        this.inputConfirmPassword(confirmPassword);
        this.clickSignUpButton();
        this.processAlertPanel();
    }

    public void inputConfirmPassword(String repeatPassword) {
        this.confirmPassword.sendKeys(repeatPassword);
    }

    public void clickSignUpButton() {
        this.signUpButton.click();
    }
}
