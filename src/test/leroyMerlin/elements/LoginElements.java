package leroyMerlin.elements;
import io.appium.java_client.android.AndroidDriver;
import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.driverProcess.UsefulMethods;

public class LoginElements extends UsefulMethods {

    public LoginElements(AndroidDriver driver) {
        super(driver);
    }

    protected String botonTu = "(//android.widget.ImageView[contains(@resource-id, 'mainViewPagerTabIcon')])[5]";
    protected String botonIniciarSesion = "button";
    protected String emailInput = "loginUsernameEditText";
    protected String passwordInput = "loginPasswordEditText";
    protected String botonEntrar = "button";
    protected String firstName = "toolbarUserFirstName";

}
