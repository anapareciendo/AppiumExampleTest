package leroyMerlin.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import leroyMerlin.elements.LoginElements;
import leroyMerlin.driverProcess.DriverManager;


public class LoginScreen extends LoginElements {
    private AppiumDriver driver;

    public LoginScreen(DriverManager driver) {
        super(driver);
        this.driver = driver.getDriver();
    }

    public void clickBotonTu(){

        click((MobileElement) driver.findElementByXPath(botonTu));

    }

    public void clickBotonIniciarSesion(){

        click((MobileElement) driver.findElementById(botonIniciarSesion));
    }

    public void clickEmailInput(){

        click((MobileElement) driver.findElementById(emailInput));
    }

    public void sendKeysEmailInput(String keys){

        sendKeys((MobileElement) driver.findElementById(emailInput), keys);
    }

    public void clickPasswordInput(){

        click((MobileElement) driver.findElementById(passwordInput));
    }

    public void sendKeysPasswordInput(String keys){

        sendKeys((MobileElement) driver.findElementById(passwordInput), keys);
    }

    public void clickBotonEntrar(){

        click((MobileElement) driver.findElementById(botonEntrar));
    }

    public boolean verifyBarraUsuario(){
        return isDisplayed((MobileElement) driver.findElementById(barraUsuario));
    }
}
