package org.Panels;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.PageObjects.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

/**
 * For subsequent Alert panels found in the application, we can create a subclass
 * such that we accommodate the specific buttons the Alert panel may have (some may contain
 * more than just the OK button)
 */
public class AlertPanel extends BasePage {
    @AndroidFindBy(id = "android:id/parentPanel")
    private WebElement parentPanel;

    @AndroidFindBy(id = "android:id/alertTitle")
    private WebElement alertTitle;

    @AndroidFindBy(id = "android:id/message")
    private WebElement message;

    @AndroidFindBy(id = "android:id/button1")
    private WebElement okButton;

    public AlertPanel(AndroidDriver driver) {
        super(driver);
    }

    public void waitForAlert(String msg) {
        this.wait.until(ExpectedConditions.visibilityOf(this.parentPanel));
        this.wait.until(ExpectedConditions.textToBePresentInElement(this.alertTitle, msg));
    }

    public void clickOkButton() {
        this.okButton.click();
    }
}
