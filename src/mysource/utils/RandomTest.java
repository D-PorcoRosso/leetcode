package mysource.utils;

import java.util.Random;

public class RandomTest {

    public static int[] genRandomIntArray(int size) {
        int[] result = new int[size];
        Random rand = new Random();
        for ( int i = 0 ; i < size ; i++ ) {
            result[i] = rand.nextInt();
        }
        return result;
    }
}