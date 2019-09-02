package leroyMerlin;

import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.process.Actions;
import leroyMerlin.screen.LoginScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LoginTestKO {
    private static DriverManager driverManager;

    @Before
    public void startDriver()  {
        driverManager = new DriverManager();
    }

    @Test
    public void loginKO() throws InterruptedException {

        Actions actions = new Actions(driverManager);
        LoginScreen loginScreen = new LoginScreen(driverManager);

        /*Click permitir acceso al GPS*/
        actions.allowGPS();

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
            Assert.assertTrue("Test KO.", loginScreen.verifyBarraUsuario());
        } catch(Exception e) {
            Assert.fail("Something went wrong: " + e);
        }

    }

    @After
    public void endDriver()  {
        driverManager.quitDriver();
    }

}

