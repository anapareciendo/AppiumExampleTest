package leroyMerlin;

import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.process.Actions;
import leroyMerlin.screen.BuscadorScreen;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class BuscadorKO {
    private static DriverManager driverManager;

    @Before
    public void startDriver()  {
        driverManager = new DriverManager();
    }

    @Test
    public void BuscadorKO() throws InterruptedException {

        Actions actions = new Actions(driverManager);
        BuscadorScreen buscadorScreen = new BuscadorScreen(driverManager);

        /*Click permitir acceso al GPS*/
        actions.allowGPS();

        /*Click barra busqueda*/
        buscadorScreen.clickBarraBusqueda();

        /*Introducir busqueda que no tenga resultados*/
        buscadorScreen.sendKeysBusquedaInput("jadskjas");

        /*Comprobar que la lista de resultados tiene size uno*/
        Assert.assertEquals("Hay más de un elemento en la lista de resultados.", 1, buscadorScreen.numeroResultadosEncontrados());
    }

    @After
    public void endDriver() throws IOException {
        driverManager.quitDriver();
    }
}
