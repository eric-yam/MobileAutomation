package TestScripts;

import org.PageObjects.BottomNavigationBar.BottomNavBar;
import org.TestScriptData.LoginTestData;
import org.TestScriptData.TestDataFactory;
import org.testng.annotations.Test;

public class ScrapTests extends BaseTest {

    @Test(dataProvider = "ValidLoginData", dataProviderClass = TestDataFactory.class)
    public void test_01(LoginTestData ltd) {
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
