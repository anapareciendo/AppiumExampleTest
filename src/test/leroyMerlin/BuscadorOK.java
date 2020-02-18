package leroyMerlin;

import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.process.Actions;
import leroyMerlin.screen.BuscadorScreen;
import org.junit.Assert;
import org.testng.annotations.Test;

public class BuscadorOK extends DriverManager{

    @Test
    public void BuscadorOK() throws InterruptedException {

        Actions actions = new Actions(driver);
        BuscadorScreen buscadorScreen = new BuscadorScreen(driver);

        /*Click permitir acceso al GPS*/
        actions.allowGPS();

        /*Click barra busqueda*/
        buscadorScreen.clickBarraBusqueda();

        /*Introducir busqueda*/
        buscadorScreen.sendKeysBusquedaInput("Tornillo");

        /*Click en el primer resultado de busqueda*/
        buscadorScreen.clickPrimerResultado();

        /*Click en Ver todos los productos*/
        buscadorScreen.clickVerTodosProductos();

        /*Click en la imagen del primer producto*/
        buscadorScreen.clickImagenPrimerProducto();

        /*Intenta capturar el nombre del producto*/
        Assert.assertTrue("No se muestra el nombre del producto.", buscadorScreen.verifyTituloProducto());
    }

}
