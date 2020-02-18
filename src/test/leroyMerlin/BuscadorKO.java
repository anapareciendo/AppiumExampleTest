package leroyMerlin;

import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.process.Actions;
import leroyMerlin.screen.BuscadorScreen;
import org.junit.Assert;
import org.testng.annotations.Test;


public class BuscadorKO extends DriverManager{

    @Test
    public void BuscadorKO() throws InterruptedException {

        Actions actions = new Actions(driver);
        BuscadorScreen buscadorScreen = new BuscadorScreen(driver);

        /*Click permitir acceso al GPS*/
        actions.allowGPS();

        /*Click barra busqueda*/
        buscadorScreen.clickBarraBusqueda();

        /*Introducir busqueda que no tenga resultados*/
        buscadorScreen.sendKeysBusquedaInput("jadskjas");

        /*Comprobar que la lista de resultados tiene size uno*/
        Assert.assertEquals("Hay más de un elemento en la lista de resultados.", 1, buscadorScreen.numeroResultadosEncontrados());
    }

}
