package org.PageObjects.Login;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.Panels.AlertPanel;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends LoginHomePage {
    @AndroidFindBy(accessibility = "button-LOGIN")
    private WebElement loginButton;

    @AndroidFindBy(xpath = "(//android.widget.ScrollView[@content-desc=\"Login-screen\"]/android.view.ViewGroup" +
            "/android.view.ViewGroup/android.view.ViewGroup[4]//following-sibling::android.widget.TextView)[2]")
    private WebElement invalidEmailPromptMsg;

    public LoginPage(AndroidDriver driver) {
        super(driver);
    }

    public void loginUser(String email, String password, boolean successLogin) {
        this.inputEmail(email);
        this.inputPassword(password);
        this.clickLoginButton();

        if (successLogin) {
            this.processLoginAlertPanel();
        }
    }

    public boolean invalidEmailMsgDisplayed() {
        return !this.invalidEmailPromptMsg.getText().isEmpty();
    }

    public void processLoginAlertPanel() {
        AlertPanel loginAlertPanel = new AlertPanel(this.driver);
        loginAlertPanel.waitForAlert();
        loginAlertPanel.clickOkButton();
    }

    public void clickLoginButton() {
        this.loginButton.click();
    }
}
