package leroyMerlin.elements;

import leroyMerlin.driverProcess.DriverManager;
import leroyMerlin.driverProcess.UsefulMethods;

public class BuscadorElements extends UsefulMethods {

    public BuscadorElements(DriverManager driver) {
        super(driver);
    }

    protected String barraBusqueda = "homeHeaderSearchTextView";
    protected String editarBusqueda = "productSearchToolbarEditText";
    protected String primerResultado = "(//android.widget.TextView[contains(@resource-id, 'product_search_item_label')])[1]";
    protected String verTodosProductos = "sectionHomeRecommendedShowAllProductsButton";
    protected String imagenPrimerProducto = "(//android.widget.ImageView[contains(@resource-id, 'productChromeImageView')])[1]";
    protected String tituloProducto = "productDetailTitleTextView";
    protected String listaResultados = "//android.widget.TextView[contains(@resource-id,'product_search_item_label')]";

}
