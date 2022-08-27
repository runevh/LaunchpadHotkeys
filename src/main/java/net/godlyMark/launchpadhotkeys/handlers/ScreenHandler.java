package net.godlyMark.launchpadhotkeys.handlers;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import io.cassaundra.rocket.Color;
import javafx.scene.layout.Background;

public class ScreenHandler {

    public static void updateSelectedNavButton(BottomNavigationButton btn, Color color){
        java.awt.Color cc = new java.awt.Color(color.getRed(), color.getGreen(), color.getBlue());
        String hex =  "#"+Integer.toHexString(cc.getRGB()).substring(2);
        btn.setStyle("-fx-background-color: " + hex + ";");
    }
}
