package com.alura.appiumtst.features;

import com.alura.appiumtst.pageObjects.CadastroPageObject;
import com.alura.appiumtst.pageObjects.LoginPageObject;

import com.alura.appiumtst.resource.driverConfig.AppiumDriverAndroidConfig;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class TestFeatureCadastro {

    @Test
    public void tstCadastrarSenhaNaoConfere() throws NoSuchElementException {

        AppiumDriver driver = AppiumDriverAndroidConfig.Instance().driver;
        LoginPageObject teleLogin = new LoginPageObject(driver);

        teleLogin.FindElements();
        CadastroPageObject telaCadastro = teleLogin.AcessarTelaCadastro();
        telaCadastro.FindElements();
        telaCadastro.ExecutarBotaoCadastrar("AdejaNelson", "adeja123", "123adeja");

        Assert.assertEquals("Senhas não conferem", telaCadastro.MensagemErro());

        driver.navigate().back();
        driver.navigate().back();

    }

    @Test
    public void tstCadastrarSenhaValida() throws NoSuchElementException {

        AppiumDriver driver = AppiumDriverAndroidConfig.Instance().driver;
        LoginPageObject teleLogin = new LoginPageObject(driver);

        teleLogin.FindElements();
        CadastroPageObject telaCadastro = teleLogin.AcessarTelaCadastro();
        telaCadastro.FindElements();
        teleLogin = telaCadastro.ExecutarBotaoCadastrar("AdejaNelson", "adeja123", "adeja123");
        teleLogin.FindElements();

    }
}
