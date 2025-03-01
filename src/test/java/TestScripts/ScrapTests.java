package TestScripts;

import org.PageObjects.BottomNavigationBar.BottomNavBar;
import org.PageObjects.Login.LoginPage;
import org.PageObjects.Login.SignUpPage;
import org.TestScriptData.LoginHomeTestData;
import org.TestScriptData.TestDataFactory;
import org.testng.annotations.Test;

public class ScrapTests extends BaseTest {

    @Test(dataProvider = "InvalidLoginData", dataProviderClass = TestDataFactory.class)
    public void invalid_login_test_0(LoginHomeTestData ltd) {
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

    @Test(dataProvider = "ValidLoginData", dataProviderClass = TestDataFactory.class)
    public void test_01(LoginHomeTestData ltd) {
        System.out.println(ltd.getEmail());
        System.out.println(ltd.getPassword());
    }

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

    @Test
    public void simpleTest() {
        System.out.println("Simple Test Method.");
    }

}
