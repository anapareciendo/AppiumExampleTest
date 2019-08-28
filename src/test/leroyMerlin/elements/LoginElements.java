package leroyMerlin.elements;
import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.driverProcess.UsefulMethods;

public class LoginElements extends UsefulMethods {

    public LoginElements(DriverManager driver) {
        super(driver);
    }

    protected String botonTu = "(//android.widget.ImageView[contains(@resource-id, 'mainViewPagerTabIcon')])[5]";
    protected String botonIniciarSesion = "button";
    protected String emailInput = "loginUsernameEditText";
    protected String passwordInput = "loginPasswordEditText";
    protected String botonEntrar = "button";
    protected String barraUsuario = "toolbarUserLastName";

}
