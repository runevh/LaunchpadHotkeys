package net.godlyMark.launchpadhotkeys.handlers;

import io.cassaundra.rocket.Color;
import io.cassaundra.rocket.Pad;
import net.godlyMark.launchpadhotkeys.Main;
import net.godlyMark.launchpadhotkeys.Util;
import net.godlyMark.launchpadhotkeys.objects.Key;
import org.checkerframework.checker.units.qual.A;

import java.math.BigDecimal;
import java.util.*;

public class EffectHandler implements Runnable{

    private static final int MINIMUM = 50;
    private List<Key> tempKeys;

    @Override
    public void run() {
        tempKeys = new ArrayList<>(KeyHandler.getKeys());
        while(true){
            try {
                if(KeyHandler.getSelectedKey() != null) breath(KeyHandler.getSelectedKey());
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public EffectHandler() {

    }

    private void stat(Key key){
        if(!hasToUpdate(key)) return;

        update(key);
    }

    private void off(Key key){
        if(!hasToUpdate(key)) return;

        update(key);
    }

    private void update(Key key){
        int index = KeyHandler.getKeys().indexOf(key);
        tempKeys.set(index, key);
    }

    private boolean hasToUpdate(Key key){
        int index = KeyHandler.getKeys().indexOf(key);
        return !tempKeys.get(index).equals(KeyHandler.getKeys());
    }

    private static void breath(Key key){
        Color original = key.getColor();

        double r = original.getRed() / 100f;
        double g = original.getGreen() / 100f;
        double b = original.getBlue() / 100f;

        long current = System.currentTimeMillis();
        double x = (current / 1000.0) - (int) (current / 1000);
        double y = (100 - MINIMUM) / 2.0 * Math.cos(x/(0.5/Math.PI)) + (100 - MINIMUM) / 2.0 + MINIMUM;

        Pad pad = new Pad(key.getCoordinates().getX(), key.getCoordinates().getY());
        Color color = Color.BLUE.copy((int) (r * y), (int) (g * y), (int) (b * y));

        Main.getRocket().setPad(pad, color);
        ScreenHandler.updateSelectedNavButton(key.getNavButton(), color);
    }

}
