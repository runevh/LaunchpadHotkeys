package net.godlyMark.launchpadhotkeys.objects;

import com.gluonhq.charm.glisten.control.BottomNavigationButton;
import io.cassaundra.rocket.Color;
import lombok.Getter;
import lombok.Setter;
import net.godlyMark.launchpadhotkeys.misc.Point;
import net.godlyMark.launchpadhotkeys.handlers.KeyHandler;


public class Key {

    @Getter @Setter private BottomNavigationButton navButton;
    @Getter @Setter boolean lighten = false;
    @Getter @Setter private KeyHandler.Effect effect = KeyHandler.Effect.STATIC;
    @Getter @Setter private Color color = Color.GREEN;
    @Getter private final Point coordinates;

    public Key(Point coordinates) {
        this.coordinates = coordinates;
    }
}
