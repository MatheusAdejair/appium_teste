package com.alura.appiumtst.features;

import com.alura.appiumtst.resource.AppiumDriverConfig;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.util.NoSuchElementException;
import java.util.regex.Matcher;

public class TestFeatureCadastro {

    @Test
    public void tstCadastrarSenhaNãoConfere() throws NoSuchElementException {

        AppiumDriver driver =  AppiumDriverConfig.Instance().driver;


        MobileElement botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        MobileElement inputName = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        MobileElement inputPassword = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        MobileElement inputConfirmPassword = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        MobileElement buttonConfirmRegister = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");


        inputName.click();
        inputName.sendKeys("Adejanelson Perigoso - Agora no Mobile");

        inputPassword.click();
        inputPassword.sendKeys("adeja123");

        inputConfirmPassword.click();
        inputConfirmPassword.sendKeys("adeja124");

        buttonConfirmRegister.click();

        MobileElement messageErroPassword = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/erro_cadastro");
        Assert.assertEquals("Senhas não conferem", messageErroPassword.getText());

        driver.navigate().back();
        driver.navigate().back();

    }

    @Test
    public void tstCadastrarSenhaValida() throws NoSuchElementException {

        AppiumDriver driver =  AppiumDriverConfig.Instance().driver;


        MobileElement botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoCadastro.click();

        MobileElement inputName = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        MobileElement inputPassword = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        MobileElement inputConfirmPassword = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        MobileElement buttonConfirmRegister = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");


        inputName.click();
        inputName.sendKeys("Adejanelson Perigoso - Agora no Mobile");

        inputPassword.click();
        inputPassword.sendKeys("adeja123");

        inputConfirmPassword.click();
        inputConfirmPassword.sendKeys("adeja123");

        buttonConfirmRegister.click();

        MobileElement buttonLogin = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");




    }
}
