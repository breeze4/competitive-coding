package udemy;

import org.junit.Assert;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class RansomNote {

    public static void main(String[] args) {
        // true
        String mag1 = "dying wool is what you will be doing";
        String note1 = "you will be dying";
        Assert.assertEquals(true, canRansom(note1, mag1));

        // true
        String mag2 = "you will love our textiles";
        String note2 = "textiles will love you";
        Assert.assertEquals(true, canRansom(note2, mag2));

        // false
        String mag3 = "you won't believe what happens next";
        String note3 = "living isn't for you";
        Assert.assertEquals(false, canRansom(note3, mag3));
    }

    public static boolean canRansom(String ransomNote, String magazine) {
        if (ransomNote == null || magazine == null) return false;
        String[] mag = magazine.split(" ");
        String[] note = ransomNote.split(" ");
        Map<String, Integer> track = new LinkedHashMap<>();
        int magIndex = 0;

        for (String n : note) {
            if (track.containsKey(n) && track.get(n) >= 1) {
                track.put(n, track.get(n) - 1);
            } else {
                String magWord = null;
                while (magIndex < mag.length && !n.equals(magWord)) {
                    magWord = mag[magIndex];
                    magIndex++;
                    track.put(magWord, track.get(magWord) != null ? track.get(magWord) + 1 : 1);
                }

                Integer count = track.get(n);
                if (n.equals(magWord) && count != null && count >= 1)
                    track.put(n, count - 1);
                else
                    return false;
            }
        }

        return true;
    }
}
