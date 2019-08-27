package leroyMerlin.elements;
import io.appium.java_client.MobileElement;
import leroyMerlin.process.DriverManager;

public class LoginElements extends DriverManager {

    public String botonTu = "(//android.widget.ImageView[contains(@resource-id, 'mainViewPagerTabIcon')])[5]";
    public String botonIniciarSesion = "button";
    public String emailInput = "loginUsernameEditText";
    public String passwordInput = "loginPasswordEditText";
    public String botonEntrar = "button";

}
