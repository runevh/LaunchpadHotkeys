package net.godlyMark.launchpadhotkeys.handlers;

import io.cassaundra.rocket.Color;
import io.cassaundra.rocket.Pad;
import net.godlyMark.launchpadhotkeys.Main;
import net.godlyMark.launchpadhotkeys.Util;
import net.godlyMark.launchpadhotkeys.objects.Key;

import java.math.BigDecimal;
import java.util.*;

public class EffectHandler implements Runnable{

    private static final int MINIMUM = 20;

    @Override
    public void run() {

        while(true){
            List<Key> keys = new ArrayList<>(KeyHandler.getActiveKeys());
            try {
                for(Key key : keys){
                    switch (key.getEffect()){
                        case BREATHING -> breath(key);
                        case NONE -> none(key);
                    }
                }
                Thread.sleep(20);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

    }

    public EffectHandler() {

    }

    private static void none(Key key){

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

        Main.getRocket().setPad(pad, Color.BLUE.copy((int) (r * y), (int) (g * y), (int) (b *y)));
    }

}
