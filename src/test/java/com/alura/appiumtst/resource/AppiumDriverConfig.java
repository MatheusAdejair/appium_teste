package com.alura.appiumtst.resource;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumDriverConfig {

    public final AppiumDriver driver;
    private static AppiumDriverConfig _instance;

    public static AppiumDriverConfig Instance(){

        if(AppiumDriverConfig._instance == null){
            AppiumDriverConfig._instance = new AppiumDriverConfig();
        }

        return AppiumDriverConfig._instance;
    }

    private AppiumDriverConfig() {
        File apk = new File("src/main/resources/alura_esporte.apk");
        DesiredCapabilities configurations = new DesiredCapabilities();
        configurations.setCapability(MobileCapabilityType.APP, apk.getAbsolutePath());
        configurations.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        configurations.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        URL urlConnect = null;
        try {
            urlConnect = new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver = new AppiumDriver<>(urlConnect, configurations);
    }
}
