import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.junit.Test;

public class LoginTest extends MetodosUtiles{

    @Test
    public void loginCorrecto() throws InterruptedException {

        Thread.sleep(5000);
        permitirGPS();

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
            desloguear();
        } catch(Exception e) {
            Assert.fail("Something went wrong: " + e);
        }

    }

    @Test
    public void loginIncorrecto() throws InterruptedException {

        /*Llamamos al método para aceptar el uso del GPS*/
        permitirGPS();

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


