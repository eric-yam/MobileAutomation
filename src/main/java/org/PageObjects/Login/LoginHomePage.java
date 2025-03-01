package org.PageObjects.Login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindAll;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.PageObjects.BasePage;
import org.Panels.AlertPanel;
import org.openqa.selenium.WebElement;

import java.util.List;

public abstract class LoginHomePage extends BasePage {
    @AndroidFindBy(accessibility = "input-email")
    private WebElement email;

    @AndroidFindBy(accessibility = "input-password")
    private WebElement password;

    @AndroidFindBy(accessibility = "button-login-container")
    private WebElement loginHeader;

    @AndroidFindBy(accessibility = "button-sign-up-container")
    private WebElement signUpHeader;

    @AndroidFindAll({
            @AndroidBy(xpath = "//android.widget.TextView[contains(@text, 'Please')]")
    })
    private List<WebElement> errorMsgs;

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

    public boolean fieldErrorMsgDisplayed() {
        return !errorMsgs.isEmpty();
    }

    public void processAlertPanel() {
        AlertPanel alertPanel = new AlertPanel(this.driver);
        if (alertPanel.isAlertDisplayed()) {
            alertPanel.clickOkButton();
        }
    }

    public boolean verifyExpectedErrorMsgDisplayed(List<String> expectedErrorMsgs) {
        boolean isDisplayed = true;
        for (int i = 0; i < errorMsgs.size(); i++) {
            isDisplayed = isDisplayed && errorMsgs.get(i).getText().equals(expectedErrorMsgs.get(i));
        }
        return isDisplayed;
    }
}
