package leroyMerlin;

import leroyMerlin.process.UsefulMethods;
import leroyMerlin.screen.LoginScreen;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends UsefulMethods {

    @Test
    public void loginOK() throws InterruptedException {

        allowGPS();

        LoginScreen loginScreen = new LoginScreen();

        /*Click botón Tú*/
        loginScreen.clickBotonTu();

        /*Click en elemento "Iniciar sesión"*/
        loginScreen.clickBotonIniciarSesion();

        /*Introducir usuario y contraseña*/
        loginScreen.clickEmailInput();
        loginScreen.sendKeysEmailInput("pruebasleroypre049@yopmail.com");

        loginScreen.sendKeysPasswordInput("Leroy123");

        /*Click en elemento "Entrar"*/
        loginScreen.clickBotonEntrar();

        Thread.sleep(5000);

        /*Intenta ejecutar el find y sino captura excepcion*/
        try {
            Assert.assertTrue("Test KO.", driver.findElementById("toolbarUserLastName").isDisplayed());
            logout();
        } catch(Exception e) {
            Assert.fail("Something went wrong: " + e);
        }

    }

    @Test
    public void loginKO() throws InterruptedException {

        allowGPS();

        LoginScreen loginScreen = new LoginScreen();

        /*Click botón Tú*/
        loginScreen.clickBotonTu();

        /*Click en elemento "Iniciar sesión"*/
        loginScreen.clickBotonIniciarSesion();

        /*Introducir usuario y contraseña*/
        loginScreen.clickEmailInput();
        loginScreen.sendKeysEmailInput("noexiste@yopmail.com");

        loginScreen.sendKeysPasswordInput("Leroy123");

        /*Click en elemento "Entrar"*/
        loginScreen.clickBotonEntrar();

        Thread.sleep(5000);

        /*Intenta ejecutar el find y sino captura excepcion*/
        try {
            Assert.assertTrue("Test KO.", driver.findElementById("loginUsernameEditText").isDisplayed());
        } catch(Exception e) {
            Assert.fail("Something went wrong: " + e);
        }

    }
}


