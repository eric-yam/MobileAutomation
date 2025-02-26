package TestScripts;

import org.TestScriptData.AppiumSetupData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;

import static org.TestScriptData.TestDataFactory.appiumSetupDataProvider;

public class BaseTest {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService appiumServer;

    /*
     *     Factory annotation requires knowledge of which subclass to instantiate.
     *     The alternative approach taken is to create a BeforeTest annotated method, then
     *     manually invoke a dataprovider method. Essentially simulates dataprovider
     *     injecting data before test starts
     */

    @BeforeTest
    public void setup() {
        Iterator<AppiumSetupData> appiumSetupDataIterator = appiumSetupDataProvider();

        //There should only be one set of AppiumSetupData
        if (appiumSetupDataIterator.hasNext()) {
            AppiumSetupData asd = appiumSetupDataIterator.next();

            //Initialize Appium Server
            AppiumServiceBuilder builder = new AppiumServiceBuilder()
                    .withAppiumJS(new File(asd.getAppiumPath()))
                    .withIPAddress(asd.getIpAddress())
                    .usingPort(asd.getPort());

            appiumServer = AppiumDriverLocalService.buildService(builder);
            appiumServer.start();

            //Initialize Android Driver
            UiAutomator2Options options = new UiAutomator2Options();
            options.setDeviceName(asd.getEmulatorDeviceName());
            options.setApp(System.getProperty(asd.getSysProperty()) + asd.getApkPath());

            URL url = null;
            try {
                url = new URL("http://" + asd.getIpAddress() + ":" + asd.getPort() + "/");
            } catch (MalformedURLException e) {
                throw new RuntimeException(e);
            }

            driver = new AndroidDriver(url, options);
        }
    }


    @AfterTest
    public void cleanUp() {
        driver.quit();
        appiumServer.stop();
//        appiumServer.close();
    }


//    @Factory(dataProvider = "AppiumSetupData", dataProviderClass = TestDataFactory.class)
//    public TestScripts.BaseTest(AppiumSetupData asd) throws MalformedURLException {
//        AppiumServiceBuilder builder = new AppiumServiceBuilder()
//                .withAppiumJS(new File(asd.getAppiumPath()))
//                .withIPAddress(asd.getIpAddress())
//                .usingPort(asd.getPort());
//
//        appiumServer = AppiumDriverLocalService.buildService(builder);
//        appiumServer.start();
//
//        //Initialize Android Driver
//        UiAutomator2Options options = new UiAutomator2Options();
//        options.setDeviceName(asd.getEmulatorDeviceName());
//        options.setApp(System.getProperty(asd.getSysProperty()) + asd.getApkPath());
//
//        URL url = new URL("http://" + asd.getIpAddress() + ":" + asd.getPort() + "/");
//        driver = new AndroidDriver(url, options);
//    }

//    @Factory(dataProvider = "TestScripts.LoginTest", dataProviderClass = TestDataFactory.class)
//    public Object[] factory(LoginTestData ltd) {
//        return new Object[]{new TestScripts.BaseTest()};
//    }

//    @AfterTest
//    public void tearDown() {
//        driver.quit();
//        appiumServer.stop();
//    }
}
