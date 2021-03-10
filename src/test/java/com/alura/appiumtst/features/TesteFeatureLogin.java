package com.alura.appiumtst.features;

import com.alura.appiumtst.pageObjects.CadastroPageObject;
import com.alura.appiumtst.pageObjects.LoginPageObject;
import com.alura.appiumtst.resource.driverConfig.AppiumDriverAndroidConfig;
import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;

public class TesteFeatureLogin {

    @Test
    public void tstLoginUsuarioNaoCadastrado() throws NoSuchElementException {

        AppiumDriver driver = AppiumDriverAndroidConfig.Instance().driver;
        LoginPageObject teleLogin = new LoginPageObject(driver);

        teleLogin.FindElements();
        teleLogin.PreencherFormularioLogin("AdejaNelson", "adeja123");
        teleLogin.ExecutarBotaoLogar();

        Assert.assertEquals("Usuário ou senha inválidos", teleLogin.MensagemErroLogin());

    }
    @Test
    public void tstLoginUsuarioNaoInseriuSenha() throws NoSuchElementException {

        AppiumDriver driver = AppiumDriverAndroidConfig.Instance().driver;
        LoginPageObject teleLogin = new LoginPageObject(driver);

        teleLogin.FindElements();
        teleLogin.PreencherFormularioLogin("AdejaNelson", " ");
        teleLogin.ExecutarBotaoLogar();

        Assert.assertEquals("Usuário ou senha inválidos", teleLogin.MensagemErroLogin());

    }
}
