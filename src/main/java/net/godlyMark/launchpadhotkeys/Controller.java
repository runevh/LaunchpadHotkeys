package net.godlyMark.launchpadhotkeys;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import io.cassaundra.rocket.Color;
import net.godlyMark.launchpadhotkeys.handlers.EffectHandler;
import net.godlyMark.launchpadhotkeys.handlers.KeyHandler;
import net.godlyMark.launchpadhotkeys.handlers.ScreenHandler;
import net.godlyMark.launchpadhotkeys.misc.Point;
import net.godlyMark.launchpadhotkeys.objects.Key;

public class Controller {

    public void onAction(javafx.event.ActionEvent e) {
        BottomNavigationButton button = (BottomNavigationButton) e.getSource();
        if(e.getSource() instanceof BottomNavigationButton){
            int x = (int) button.getLayoutX() / 60;
            int y = (int) button.getLayoutY() / 60;

            Key key = KeyHandler.getKeyFromLocation(x, y);
            if(key.getNavButton() == null) key.setNavButton(button);
            KeyHandler.setSelectedKey(key);
        }
    }

}
