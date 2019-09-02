package leroyMerlin.driverProcess;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public AndroidDriver driver;
    protected AppiumDriverLocalService service;

    public DriverManager()  {

        /*Configuramos las capabilities*/
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        File app = new File("src/test/leroyMerlin/resources", "LEROY_MERLIN_pre.apk");
        desiredCapabilities.setCapability("app", app.getAbsolutePath());
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "AndroidDevice");
        desiredCapabilities.setCapability("appPackage", "com.iphonedroid.leroymerlin.pre");
        desiredCapabilities.setCapability("appWaitActivity", "com.iphonedroid.leroymerlin.screen.main.MainActivity");
        desiredCapabilities.setCapability("noReset", "false");
        desiredCapabilities.setCapability("unicodeKeyboard", "true");
        desiredCapabilities.setCapability("resetKeyboard", "true");

        /*Indicamos la url de nuestro servidor appium*/
        //URL remoteUrl = new URL("http://localhost:4723/wd/hub");

        /*Iniciamos el servicio de Appium*/
        AppiumServiceBuilder builder = new AppiumServiceBuilder().withCapabilities(desiredCapabilities)
                .withIPAddress("127.0.0.1")
                .usingPort(4723);
        service = builder.build();
        service.start();

        /*Creamos el driver pasandole la url y las capabilities*/
        driver = new AndroidDriver(service.getUrl(), desiredCapabilities);

        /*Esperamos a la generacion del driver*/
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }


    @SuppressWarnings("rawtypes")
    public AppiumDriver getDriver() {
        return driver;
    }

    public void quitDriver() {
        driver.quit();
    }
}
