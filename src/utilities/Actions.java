import io.appium.java_client.MobileElement;

public class Actions {

    public String getText(MobileElement element) {
        String text=element.getText();
        System.out.println("[GET_TEXT] [" +  text + "] [" + element.toString() + "]");
        return text;
    }
    
}
