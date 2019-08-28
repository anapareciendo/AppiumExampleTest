package leroyMerlin.process;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.elements.LoginElements;
import org.junit.Assert;

public class Actions extends LoginElements {
    private AppiumDriver driver;

    public Actions(DriverManager driver) {
        super(driver);
        this.driver = driver.getDriver();
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

        /*Scroll para que se visualice el elemento "Cerrar sesión"*/
        (new TouchAction(driver))
                .press(PointOption.point(357, 1123))
                .moveTo(PointOption.point(330, 567))
                .release()
                .perform();
        /*Pulsar en el elemento "Cerrar sesión"*/
        driver.findElementByXPath("//android.widget.LinearLayout[2]/android.widget.LinearLayout").click();

        /*Pulsar en "Si" en el popup de confirmación*/
        driver.findElementById("button1").click();

    }

}
