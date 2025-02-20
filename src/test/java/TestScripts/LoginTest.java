package TestScripts;

import org.PageObjects.HomeListPage;
import org.TestScriptData.LoginTestData;
import org.TestScriptData.TestDataFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "LoginTest", dataProviderClass = TestDataFactory.class)
    public void test_01(LoginTestData ltd) {
        System.out.println(ltd.getUsername());
        System.out.println(ltd.getPassword());
    }

    @Test
    public void simpleTest() {
        System.out.println("Simple Test Method.");
    }

    @Test
    public void simpleTest_2() {
//        WebElement temp = driver.findElement(AppiumBy.id("android:id/list")
        HomeListPage homeListPage = new HomeListPage(driver);

    }
}
