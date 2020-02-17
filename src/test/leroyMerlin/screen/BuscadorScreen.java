package leroyMerlin.screen;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.elements.BuscadorElements;
import org.openqa.selenium.Dimension;

import java.util.List;

public class BuscadorScreen extends BuscadorElements {

    private AppiumDriver driver;

    public BuscadorScreen(DriverManager driver) {
        super(driver);
        this.driver = driver.getDriver();
    }

    public void clickBarraBusqueda(){
        click((MobileElement) driver.findElementById(barraBusqueda));
    }

    public void clickEditarBusqueda(){

        click((MobileElement) driver.findElementById(editarBusqueda));
    }

    public void sendKeysBusquedaInput(String keys){
        sendKeys((MobileElement) driver.findElementById(editarBusqueda), keys);
    }

    public void clickPrimerResultado(){
        click((MobileElement) driver.findElementByXPath(primerResultado));
    }

    public void clickVerTodosProductos(){

        click((MobileElement) driver.findElementById(verTodosProductos));
    }

    public void clickImagenPrimerProducto(){

        click((MobileElement) driver.findElementByXPath(imagenPrimerProducto));
    }

    public boolean verifyTituloProducto(){
        return isDisplayed((MobileElement) driver.findElementById(tituloProducto));
    }

    public int numeroResultadosEncontrados(){
        return driver.findElementsByXPath(listaResultados).size();
    }
}
