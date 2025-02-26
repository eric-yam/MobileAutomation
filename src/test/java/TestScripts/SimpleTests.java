package TestScripts;

import org.PageObjects.BottomNavigationBar.BottomNavBar;
import org.PageObjects.Login.LoginPage;
import org.PageObjects.Login.SignUpPage;
import org.TestScriptData.LoginTestData;
import org.TestScriptData.TestDataFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class SimpleTests extends BaseTest {
    @Test(dataProvider = "InvalidLoginData", dataProviderClass = TestDataFactory.class)
    public void invalid_login_test(LoginTestData ltd) {
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

    @Test(dataProvider = "InvalidLoginData", dataProviderClass = TestDataFactory.class)
    public void invalid_login_test_2(LoginTestData ltd) {
        BottomNavBar bnb = new BottomNavBar(driver);
        bnb.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.clickLoginHeader();
        lp.loginUser(ltd.getEmail(), ltd.getPassword(), ltd.getExpectedStatus());

        assertTrue(lp.invalidEmailMsgDisplayed());
    }

    @Test(dataProvider = "ValidLoginData", dataProviderClass = TestDataFactory.class)
    public void valid_login_test(LoginTestData ltd) {
        BottomNavBar bnb = new BottomNavBar(driver);
        bnb.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.clickLoginHeader();
        lp.loginUser(ltd.getEmail(), ltd.getPassword(), ltd.getExpectedStatus());
    }
}