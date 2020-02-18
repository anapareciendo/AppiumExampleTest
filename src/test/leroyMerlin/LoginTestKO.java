package leroyMerlin;

import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.process.Actions;
import leroyMerlin.screen.LoginScreen;
import org.junit.Assert;
import org.testng.annotations.Test;


public class LoginTestKO extends DriverManager{

    @Test
    public void loginKO() throws InterruptedException {

        Actions actions = new Actions(driver);
        LoginScreen loginScreen = new LoginScreen(driver);

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

        Assert.assertTrue("No se muestra el botón entrar.", loginScreen.verifyBotonEntrar());


    }

}


