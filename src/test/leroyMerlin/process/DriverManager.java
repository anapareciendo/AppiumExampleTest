package leroyMerlin.process;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.remote.DesiredCapabilities;

import javax.xml.ws.Service;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

public class DriverManager {

    static public AndroidDriver driver;

    @Before
    public void setUp() throws MalformedURLException {

        /*Configuramos las capabilities*/
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        File app = new File("src/test//leroyMerlin/resources", "LEROY_MERLIN_pre.apk");
        desiredCapabilities.setCapability("app", app.getAbsolutePath());
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "AndroidDevice");
        desiredCapabilities.setCapability("appPackage", "com.iphonedroid.leroymerlin.pre");
        desiredCapabilities.setCapability("appWaitActivity", "com.iphonedroid.leroymerlin.screen.main.MainActivity");
        desiredCapabilities.setCapability("noReset", "false");

        /*Indicamos la url de nuestro servidor appium*/
        URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        /*Iniciamos Appium*/

        /**
        AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(desiredCapabilities)
                .withIPAddress(appiummIP)
                .usingPort(Integer.valueOf(4723));
        service = builder.build();
        service.start();
         */

        /*Creamos el driver pasandole la url y las capabilities*/
        driver = new AndroidDriver(remoteUrl, desiredCapabilities);

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
