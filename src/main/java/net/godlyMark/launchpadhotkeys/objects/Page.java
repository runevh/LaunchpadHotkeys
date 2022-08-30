package net.godlyMark.launchpadhotkeys.objects;

import lombok.Getter;

import java.util.Vector;

public class Page {
    @Getter private static Page currentPage;
    @Getter private static int index = 1;

    //private static Page pages[8];

    Vector<Key> keys = new Vector<>();
}
