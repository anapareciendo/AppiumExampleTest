package leroyMerlin;

import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.process.Actions;
import leroyMerlin.screen.BuscadorScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class BuscadorOK {

    private static DriverManager driverManager;

    @Before
    public void startDriver()  {
        driverManager = new DriverManager();
    }

    @Test
    public void BuscadorOK() throws InterruptedException {

        Actions actions = new Actions(driverManager);
        BuscadorScreen buscadorScreen = new BuscadorScreen(driverManager);

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

    @After
    public void endDriver() throws IOException {
        driverManager.quitDriver();
    }
}
