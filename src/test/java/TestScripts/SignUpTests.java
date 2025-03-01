package TestScripts;

import org.PageObjects.BottomNavigationBar.BottomNavBar;
import org.PageObjects.Login.SignUpPage;
import org.TestScriptData.LoginHomeTestData;
import org.TestScriptData.TestDataFactory;
import org.testng.annotations.Test;

import static org.testng.AssertJUnit.assertTrue;

public class SignUpTests extends BaseTest {

    @Test(dataProvider = "ValidSignUpData", dataProviderClass = TestDataFactory.class)
    public void validSignUpTest(LoginHomeTestData lhtd) {
        BottomNavBar bnb = new BottomNavBar(driver);
        bnb.clickLogin();

        SignUpPage sup = new SignUpPage(driver);
        sup.clickSignUpHeader();
        sup.fillSignUpPage(lhtd.getEmail(), lhtd.getPassword(), lhtd.getConfirmPassword());
    }

    @Test(dataProvider = "InvalidSignUpData", dataProviderClass = TestDataFactory.class)
    public void invalidSignUpTest(LoginHomeTestData lhtd) {
        BottomNavBar bnb = new BottomNavBar(driver);
        bnb.clickLogin();

        SignUpPage sup = new SignUpPage(driver);
        sup.clickSignUpHeader();
        sup.fillSignUpPage(lhtd.getEmail(), lhtd.getPassword(), lhtd.getConfirmPassword());
        assertTrue(sup.fieldErrorMsgDisplayed());
        assertTrue(sup.verifyExpectedErrorMsgDisplayed(lhtd.getExpectedErrorMsgs()));
    }
}
