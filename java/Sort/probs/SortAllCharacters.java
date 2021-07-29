package probs;

import java.util.Arrays;

public class SortAllCharacters {

    public static void main(String[] args) {

        char[] charInput = new char[] { 'r', '*', 'j', 'a', '!' };

        // int[] inp = new int[charInput.length];
        // for (int i = 0; i < charInput.length; i++) {
        // inp[i] = charInput[i];
        // }

        int[] freqs = new int[128];
        for (int i = 0; i < charInput.length; i++) {
            // int index = ch;// dont' need explicitly
            // ++freqs[index];
            freqs[i] = charInput[i]; // auto conversion to int from char
            // System.out.println(ch + ":"+ index);
        }

        // arr.clear(); // imp
        // for (int index = 0; index < freqs.length; ++index) {
        // while (freqs[index] > 0) {
        // arr.add((char)index);
        // --freqs[index];//missed this
        // }
        // }

        Arrays.stream(freqs).forEach(System.out::println);

    }

}
