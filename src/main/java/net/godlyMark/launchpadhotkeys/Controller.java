package net.godlyMark.launchpadhotkeys;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import io.cassaundra.rocket.Color;
import net.godlyMark.launchpadhotkeys.handlers.KeyHandler;
import net.godlyMark.launchpadhotkeys.misc.Point;
import net.godlyMark.launchpadhotkeys.objects.Key;

public class Controller {

    public void onAction(javafx.event.ActionEvent e) {
        BottomNavigationButton button = (BottomNavigationButton) e.getSource();
        if(e.getSource() instanceof BottomNavigationButton){
            int x = (int) button.getLayoutX() / 60;
            int y = (int) button.getLayoutY() / 60;

            Key key = new Key(KeyHandler.Effect.BREATHING, Color.WHITE, new Point(x, 7-y));
            KeyHandler.lightKey(key);
        }
    }

}
