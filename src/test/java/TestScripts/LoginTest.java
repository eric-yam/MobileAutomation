package TestScripts;

import org.TestScriptData.LoginTestData;
import org.TestScriptData.TestDataFactory;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @Test(dataProvider = "LoginData", dataProviderClass = TestDataFactory.class)
    public void test_01(LoginTestData ltd) {
        System.out.println(ltd.getEmail());
        System.out.println(ltd.getPassword());
    }

    @Test
    public void simpleTest() {
        System.out.println("Simple Test Method.");
    }

}
