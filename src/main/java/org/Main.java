package org;/*
 * write down how appium worksbegin setting up intellij maven project for appium automation
 * write down setup steps for maven project
 * difference between testng and junit
 * APIDemos-debug.apk from https://github.com/appium/appium/blob/master/packages/appium/sample-code/apps/ApiDemos-debug.apk
 *
 * note that with parameterized tests, help us re-use test cases
while testing, it is discouraged to use for loops to loop over different input values
it is also easier to debug as we can percisely identify which test data input is causing the test script to fail i
 * */

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws MalformedURLException {
        System.out.println(System.getProperty("user.dir") + "\\resources\\ApiDemos-debug.apk");

        //Initialize Appium server
        //C:\Users\Eric\AppData\Roaming\npm\node_modules\appium\build\lib\main.js
        AppiumServiceBuilder builder = new AppiumServiceBuilder()
                .withAppiumJS(new File("C:\\Users\\Eric\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723);

        AppiumDriverLocalService appiumServer = AppiumDriverLocalService.buildService(builder);
        appiumServer.start();

        //Initialize Android Driver
        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("Pixel_9_API_35");
        options.setApp(System.getProperty("user.dir") + "\\resources\\ApiDemos-debug.apk");

        URL url = new URL("http://127.0.0.1:4723/");
        AndroidDriver driver = new AndroidDriver(url, options);

        driver.quit();
        appiumServer.stop();

    }
}