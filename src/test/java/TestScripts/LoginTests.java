package TestScripts;

import org.PageObjects.BottomNavigationBar.BottomNavBar;
import org.PageObjects.Login.LoginPage;
import org.TestScriptData.LoginHomeTestData;
import org.TestScriptData.TestDataFactory;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;

public class LoginTests extends BaseTest {
    @Test(dataProvider = "ValidLoginData", dataProviderClass = TestDataFactory.class)
    public void valid_login_test(LoginHomeTestData ltd) {
        BottomNavBar bnb = new BottomNavBar(driver);
        bnb.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.clickLoginHeader();
        lp.fillLoginPage(ltd.getEmail(), ltd.getPassword());
    }

    @Test(dataProvider = "InvalidLoginData", dataProviderClass = TestDataFactory.class)
    public void invalid_login_test(LoginHomeTestData lhtd) {
        BottomNavBar bnb = new BottomNavBar(driver);
        bnb.clickLogin();

        LoginPage lp = new LoginPage(driver);
        lp.clickLoginHeader();
        lp.fillLoginPage(lhtd.getEmail(), lhtd.getPassword());

        assertTrue(lp.fieldErrorMsgDisplayed());
        assertTrue(lp.verifyExpectedErrorMsgDisplayed(lhtd.getExpectedErrorMsgs()));
    }
}