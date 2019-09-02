package leroyMerlin.driverProcess;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static io.appium.java_client.touch.offset.ElementOption.element;

public class UsefulMethods {

    private AppiumDriver driver;

    public UsefulMethods(DriverManager driver) {
        this.driver = driver.getDriver();
    }


    protected void click(MobileElement element){
        element.click();
        System.out.println("[CLICK] [" + element.toString() + "]");
    }


    protected String getText(MobileElement element) {
        String text=element.getText();
        System.out.println("[GET_TEXT] [" +  text + "] [" + element.toString() + "]");
        return text;
    }


    protected void sendKeys(MobileElement element, String keys){
        element.sendKeys(keys);
        System.out.println("[SEND_KEYS] [" +  keys + "] [" + element.toString() + "]");
    }


    protected boolean isDisplayed(MobileElement element){
        try {
            return element.isDisplayed();
        } catch (Exception e){
            return false;
        }
    }

    protected void scroll(MobileElement element, Integer x, Integer y){

        (new TouchAction(driver))
                .longPress(element(element))
                .waitAction()
                .moveTo(PointOption.point(x,y))
                .release()
                .perform();

        System.out.println("[SCROLL] [PRESS: " + element.toString() + "] [" + "MOVE TO: " + x + "," + y + "]");

    }


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
        }catch (Exception ignored){ }
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
        }catch (Exception ignored){ }
        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;
        System.out.println("[WAIT_CLICK] [" + element.toString() + "] [" + totalTime + "]");
    }


}
