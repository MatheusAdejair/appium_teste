package com.alura.appiumtst.resource.driverConfig;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverIOSConfig {

    public final AppiumDriver driver;
    private static AppiumDriverIOSConfig _instance;

    public static AppiumDriverIOSConfig Instance(){

        if(AppiumDriverIOSConfig._instance == null){
            AppiumDriverIOSConfig._instance = new AppiumDriverIOSConfig();
        }

        return AppiumDriverIOSConfig._instance;
    }

    private AppiumDriverIOSConfig() {
        File apk = new File("src/main/resources/APKs/alura_esporte.apk");
        DesiredCapabilities configurations = new DesiredCapabilities();
        configurations.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configurations.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.IOS);
        configurations.setCapability(MobileCapabilityType.AUTOMATION_NAME, "Instruments");

        URL urlConnect = null;
        try {
            urlConnect = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AppiumDriver<>(urlConnect, configurations);
    }
}
