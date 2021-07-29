import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class WordLadder {

    public static void main(String[] args) {
        String[] words = new String[] { "cat", "hat", "bad", "had" };
        List<String> result = new ArrayList<>();

        stringTransformation(words, "bat", "had", result);
        System.out.println(result.toString());
    }

    public static void stringTransformation(String[] words, String start, String stop, List<String> result) {
        Set<String> wordSet = new HashSet<String>();

        for (int k = 0; k < words.length; k++) {
            wordSet.add(words[k]);
        }

        // put start word in queue and try changing each letter to see if it matches the
        // words array
        // if it matches then add that to the queue and move on
        Queue<String> queue = new LinkedList<>();
        queue.add(start);
        result.add(start);
        while (!queue.isEmpty()) {

            char[] word = queue.remove().toCharArray();
            result.add(String.valueOf(word));
            for (int j = 0; j < word.length; j++) {
                char originalWord = word[j];
                for (char i = 'a'; i < 'z'; i++) {
                    if (word[j] == i)
                        continue;

                    word[j] = i;

                    if (String.valueOf(word).equals(stop)) {
                        result.add(String.valueOf(word));
                        return;
                    }
                    if (wordSet.contains(String.valueOf(word))) {
                        queue.add(String.valueOf(word));
                        wordSet.remove(String.valueOf(word));

                    }
                }
                word[j] = originalWord;

            }
        }
        // String[] stringArray = result.toArray(new String[0]);
        // stringArray;

    }
}
