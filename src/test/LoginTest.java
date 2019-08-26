import io.appium.java_client.MobileElement;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends UsefulMethods{

    @Test
    public void loginOK() throws InterruptedException {

        allowGPS();

        /*Usando RE para encontrar el botón Tú*/
        driver.findElementByXPath("(//android.widget.ImageView[contains(@resource-id, 'mainViewPagerTabIcon')])[5]").click();

        /*Click en elemento "Iniciar sesión"*/
        driver.findElementById("button").click();

        /*Introducir usuario y contraseña*/
        MobileElement emailInput = (MobileElement) driver.findElementById("loginUsernameEditText");
        emailInput.click();
        emailInput.sendKeys("pruebasleroypre049@yopmail.com");
        driver.findElementById("loginPasswordEditText").sendKeys("Leroy123");

        /*Click en elemento "Entrar"*/
        driver.findElementById("button").click();

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

        /*Llamamos al método para aceptar el uso del GPS*/
        allowGPS();

        /*Usando RE para encontrar el botón Tú*/
        driver.findElementByXPath("(//android.widget.ImageView[contains(@resource-id, 'mainViewPagerTabIcon')])[5]").click();

        /*Click en elemento "Iniciar sesión"*/
        driver.findElementById("button").click();

        /*Introducir usuario incorrecto y contraseña*/
        MobileElement emailInput = (MobileElement) driver.findElementById("loginUsernameEditText");
        emailInput.click();
        emailInput.sendKeys("pruebas@yopmail.com");
        driver.findElementById("loginPasswordEditText").sendKeys("Leroy123");

        /*Click en elemento "Entrar"*/
        driver.findElementById("button").click();

        Thread.sleep(5000);

        /*Intenta ejecutar el find y sino captura excepcion*/
        try {
            Assert.assertTrue("Test KO.", driver.findElementById("loginUsernameEditText").isDisplayed());
        } catch(Exception e) {
            Assert.fail("Something went wrong: " + e);
        }

    }
}

