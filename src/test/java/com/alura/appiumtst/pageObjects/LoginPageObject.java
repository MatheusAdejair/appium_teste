package com.alura.appiumtst.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPageObject extends PageObjectBase{

    private MobileElement botaoCadastro;
    private MobileElement botaoLogar;
    private MobileElement inputUsuario;
    private MobileElement inpoutSenha;
    private MobileElement mensagemErro;
    private By erroID;

    public LoginPageObject(AppiumDriver driver){
        super(driver);

    }

    @Override
    public void FindElements(){

        inputUsuario = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_usuario");
        inpoutSenha = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        botaoCadastro = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_cadastrar_usuario");
        botaoLogar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/login_botao_logar");

    }

    public CadastroPageObject AcessarTelaCadastro() {

        botaoCadastro.click();
        return new CadastroPageObject(driver);
    }

    public void PreencherFormularioLogin(String usuario, String senha){

        inputUsuario.setValue(usuario);
        inpoutSenha.setValue(senha);
    }

    public void ExecutarBotaoLogar(){

        botaoLogar.click();
    }
    public String MensagemErroLogin(){

        erroID = By.id("br.com.alura.aluraesporte:id/mensagem_erro_login");
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(erroID));

        mensagemErro = (MobileElement) driver.findElement(erroID);
        return mensagemErro.getText();
    }

}
