package leroyMerlin;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({

        LoginTestOK.class,
        LoginTestKO.class,
        BuscadorOK.class,

})

public class AllTests {
}
