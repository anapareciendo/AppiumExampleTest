package leroyMerlin.process;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.elements.LoginElements;
import org.junit.Assert;
import org.openqa.selenium.Dimension;

import java.awt.*;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class Actions extends LoginElements {
    private AppiumDriver driver;

    public Actions(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
    }

    /** Metodo para pulsar en elemento "Permitir" acceso a ubicación */
    public void allowGPS() throws InterruptedException{
        try{
            driver.findElementByXPath("//android.widget.Button[2]").click();
        }catch (Exception e){
            Assert.fail("Something went wrong: " + e);
        }

    }

    /** Método para desloguear */
    public void logout() throws InterruptedException {

        /*Pulsar en el elemento "Tú" del menú*/
        driver.findElementByXPath("(//android.widget.ImageView[contains(@resource-id, 'mainViewPagerTabIcon')])[5]").click();

        /*Pulsar en el elemento "Mis datos"*/
        driver.findElementById("button").click();
        Thread.sleep(5000);

        /*Hacer scroll desde "Mis direcciones" hacia arriba*/
        /*Obtener la dimension de la pantalla*/
        Dimension size= driver.manage().window().getSize();
        Integer mitadAncho = (size.width / 2);
        MobileElement misDirecciones = (MobileElement) driver.findElementById("myDataFragmentMyAddressesChrome");
        /*Scroll para que se visualice el elemento "Cerrar sesión"*/
        scroll(misDirecciones, mitadAncho, 10);

        /*Pulsar en el elemento "Cerrar sesión"*/
        driver.findElementById("myDataFragmentLogoutChrome").click();

        /*Pulsar en "Si" en el popup de confirmación*/
        driver.findElementByXPath("//android.widget.Button[2]").click();

    }

}
