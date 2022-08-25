package net.godlyMark.launchpadhotkeys.handlers;

import lombok.Getter;
import net.godlyMark.launchpadhotkeys.objects.Key;

import java.util.ArrayList;
import java.util.List;

public class KeyHandler {

    @Getter private static final List<Key> activeKeys = new ArrayList<>();

    public static void lightKey(Key key){
        if(!activeKeys.contains(key)) {activeKeys.add(key); System.out.println("test");};
    }

    public enum Effect {
        NONE, BREATHING
    }
}
