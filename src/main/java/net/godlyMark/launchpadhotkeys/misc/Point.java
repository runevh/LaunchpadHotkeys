package net.godlyMark.launchpadhotkeys.misc;

import lombok.Getter;

public class Point {
    @Getter private int x;
    @Getter private int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
