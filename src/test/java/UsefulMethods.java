import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class UsefulMethods extends DriverManager{

    /**
     * Wait for visible.
     *
     * @param element  the element
     * @param waitTime the wait time
     */
    public void waitForVisible(MobileElement element, int waitTime) {
        long startTime = System.currentTimeMillis();
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.visibilityOf(element));
        }catch (Exception ex){ }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("[WAIT_VISIBLE] [" + element.toString() + "] [" + totalTime + "]");
    }

    /**
     * Wait for click.
     *  @param element  the element
     * @param waitTime the wait time
     */
    public void waitForClick(MobileElement element, int waitTime) {
        long startTime = System.currentTimeMillis();
        try {
            WebDriverWait wait = new WebDriverWait(driver, waitTime);
            wait.until(ExpectedConditions.elementToBeClickable(element));
        }catch (Exception ex){ }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("[WAIT_CLICK] [" + element.toString() + "] [" + totalTime + "]");
    }

    /** Metodo para pulsar en elemento "Permitir" acceso a ubicación */
    public void permitirGPS() throws InterruptedException{

        MobileElement aceptarGPS = (MobileElement) driver.findElementByXPath("//android.widget.Button[2]");
        waitForClick(aceptarGPS, 10);

        try{
            driver.findElementByXPath("//android.widget.Button[2]").click();
        }catch (Exception e){
            Assert.fail("Something went wrong: " + e);
        }

    }

    /** Método para desloguear */
    public void desloguear() throws InterruptedException {

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
