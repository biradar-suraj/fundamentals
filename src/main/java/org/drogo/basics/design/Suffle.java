package org.drogo.basics.design;

import java.util.Collections;
import java.util.List;

public class Suffle {

    public static List<Song> getSuffledList(List<Song> songs) {
        Collections.shuffle(songs);
        return songs;
    }
}
