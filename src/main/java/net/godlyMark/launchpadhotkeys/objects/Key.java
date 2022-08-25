package net.godlyMark.launchpadhotkeys.objects;

import io.cassaundra.rocket.Color;
import lombok.Getter;
import lombok.Setter;
import net.godlyMark.launchpadhotkeys.misc.Point;
import net.godlyMark.launchpadhotkeys.handlers.KeyHandler;


public class Key {
    @Getter private KeyHandler.Effect effect;
    @Getter @Setter private Color color;
    @Getter private Point coordinates;

    public Key(KeyHandler.Effect effect, Color color, Point coordinates) {
        this.effect = effect;
        this.color = color;
        this.coordinates = coordinates;
    }
}
