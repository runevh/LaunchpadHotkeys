package net.godlyMark.launchpadhotkeys.handlers;

import lombok.Getter;
import lombok.Setter;
import net.godlyMark.launchpadhotkeys.misc.Point;
import net.godlyMark.launchpadhotkeys.objects.Key;

import java.util.ArrayList;
import java.util.List;

public class KeyHandler {

    @Setter @Getter private static Key selectedKey = null;
    @Getter private static final List<Key> keys = new ArrayList<>();
    public static void init(){
        for(int y = 0; y < 8; y++){
          for(int x = 0; x < 8; x++){
              Key key = new Key(new Point(x, y));
              keys.add(key);
          }
        }
    }
    public static Key getKeyFromLocation(int x, int y){
        if(x < 0 || x > 7 || y < 0 || y > 7) throw new RuntimeException();
        return keys.get(x + y*8);
    }


    public enum Effect {
        STATIC, BREATHING
    }
}
