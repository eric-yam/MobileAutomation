package TestScripts;

import org.PageObjects.BottomNavBar;
import org.PageObjects.Login.LoginPage;
import org.PageObjects.Login.SignUpPage;
import org.TestScriptData.LoginTestData;
import org.TestScriptData.TestDataFactory;
import org.testng.annotations.Test;

public class SimpleTests extends BaseTest {
    @Test
    public void navigation_test() {
        BottomNavBar bnb = new BottomNavBar(driver);
        bnb.clickHome();
        bnb.clickWebview();
        bnb.clickLogin();
        bnb.clickForms();
        bnb.clickSwipe();
        bnb.clickDrag();
    }

    @Test(dataProvider = "LoginData", dataProviderClass = TestDataFactory.class)
    public void login_test(LoginTestData ltd) {
        BottomNavBar bnb = new BottomNavBar(driver);
        bnb.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.clickLoginHeader();
        lp.inputEmail(ltd.getEmail());
        lp.inputPassword(ltd.getPassword());
        lp.clickLoginButton();

        lp.clickSignUpHeader();

        SignUpPage sup = new SignUpPage(driver);
        sup.inputEmail(ltd.getEmail());
        sup.inputPassword(ltd.getPassword());
        sup.inputConfirmPassword(ltd.getPassword());
    }
}
