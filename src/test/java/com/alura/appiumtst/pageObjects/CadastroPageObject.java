package com.alura.appiumtst.pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CadastroPageObject extends PageObjectBase{

    private MobileElement inputName;
    private MobileElement inputPassword;
    private MobileElement inputConfirmPassword;
    private MobileElement botaoCadastrar;
    private MobileElement mensagemErro;
    private By erroID;

    public CadastroPageObject(AppiumDriver driver){
        super(driver);

    }
    
    @Override
    public void FindElements(){

        inputName = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_nome");
        inputPassword = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_senha");
        inputConfirmPassword = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/input_confirmar_senha");
        botaoCadastrar = (MobileElement) driver.findElementById("br.com.alura.aluraesporte:id/cadastro_usuario_botao_cadastrar");

    }

    private void PreencherFormularioCadastro(String usuario, String senha, String confirmacaoSenha){

        //inputName.click();
        inputName.setValue(usuario);
        // inputPassword.click();

        inputPassword.setValue(senha);
        //inputConfirmPassword.click();
        inputConfirmPassword.setValue(confirmacaoSenha);

    }

    public LoginPageObject ExecutarBotaoCadastrar(String usuario, String senha, String confirmacaoSenha){

        PreencherFormularioCadastro(usuario, senha, confirmacaoSenha);
        botaoCadastrar.click();
        return new LoginPageObject(driver);
    }

    public String MensagemErro(){

        erroID = By.id("br.com.alura.aluraesporte:id/erro_cadastro");

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(erroID));

        mensagemErro = (MobileElement) driver.findElement(erroID);
        return mensagemErro.getText();

    }
}
