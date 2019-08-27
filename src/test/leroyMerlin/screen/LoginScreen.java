package leroyMerlin.screen;

import io.appium.java_client.MobileElement;
import leroyMerlin.elements.LoginElements;
import leroyMerlin.utilities.*;


public class LoginScreen extends LoginElements {

    Actions actions = new Actions();

    public void clickBotonTu(){

        actions.click((MobileElement) driver.findElementByXPath(botonTu));

    }

    public void clickBotonIniciarSesion(){

        actions.click((MobileElement) driver.findElementById(botonIniciarSesion));
    }

    public void clickEmailInput(){

        actions.click((MobileElement) driver.findElementById(emailInput));
    }

    public void sendKeysEmailInput(String keys){

        actions.sendKeys((MobileElement) driver.findElementById(emailInput), keys);
    }

    public void clickPasswordInput(){

        actions.click((MobileElement) driver.findElementById(passwordInput));
    }

    public void sendKeysPasswordInput(String keys){

        actions.sendKeys((MobileElement) driver.findElementById(passwordInput), keys);
    }

    public void clickBotonEntrar(){

        actions.click((MobileElement) driver.findElementById(botonEntrar));
    }
}
