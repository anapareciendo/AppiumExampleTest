import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    public AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {
        /*Configuramos las capabilities*/
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("app", "C:\\Users\\araparicio\\Documents\\Cursos atSistemas\\Automatizacion\\LM_apks\\LEROY MERLIN_com.iphonedroid.leroymerlin.pre.apk");
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "AndroidDevice");
        desiredCapabilities.setCapability("appPackage", "com.iphonedroid.leroymerlin.pre");
        desiredCapabilities.setCapability("appWaitActivity", "com.iphonedroid.leroymerlin.screen.main.MainActivity");
        desiredCapabilities.setCapability("noReset", "false");

        /*Indicamos la url de nuestro servidor appium*/
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        /*Creamos el driver pasandole la url y las capabilities*/
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
