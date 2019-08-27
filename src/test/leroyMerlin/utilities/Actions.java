package leroyMerlin.utilities;

import io.appium.java_client.MobileElement;

public class Actions {

    public String getText(MobileElement element) {
        String text=element.getText();
        System.out.println("[GET_TEXT] [" +  text + "] [" + element.toString() + "]");
        return text;
    }

    public void click(MobileElement element){
        element.click();
        System.out.println("[CLICK] [" + element.toString() + "]");
    }

    public void sendKeys(MobileElement element, String keys){
        element.sendKeys(keys);
        System.out.println("[SEND_KEYS] [" +  keys + "] [" + element.toString() + "]");
    }

}
