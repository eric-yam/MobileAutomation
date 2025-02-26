package TestScripts;

import org.TestScriptData.AppiumSetupData;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
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
    public void setupAppiumServer() {
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
        }
    }

    @BeforeMethod
    public void setupDriver() {
        Iterator<AppiumSetupData> appiumSetupDataIterator = appiumSetupDataProvider();

        //There should only be one set of AppiumSetupData
        if (appiumSetupDataIterator.hasNext()) {
            AppiumSetupData asd = appiumSetupDataIterator.next();
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

    @AfterMethod
    public void cleanUpDriver() {
        driver.quit();
    }

    @AfterTest
    public void cleanUpAppiumServer() {
        appiumServer.stop();

//        driver.quit();
//        appiumServer.close();
    }

}
