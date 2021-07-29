import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DialerPad {

    public static void main(String[] args) {
        String phoneNumber = "921";
        char[] pNumber = phoneNumber.toCharArray();

        Map<Character, String> dialerPadNotation = new HashMap<Character, String>();
        dialerPadNotation.put('2', "ABC");
        dialerPadNotation.put('3', "DEF");
        dialerPadNotation.put('4', "GHI");
        dialerPadNotation.put('5', "JKL");
        dialerPadNotation.put('6', "MNO");
        dialerPadNotation.put('7', "PQRS");
        dialerPadNotation.put('8', "TUV");
        dialerPadNotation.put('9', "WXYZ");

        List<String> result = new ArrayList<String>();
        dialerPadHelper(pNumber, dialerPadNotation, 0, result, new char[pNumber.length]);

        result.forEach(System.out::println);
    }

    public static void dialerPadHelper(char[] pNumber, Map<Character, String> dialerPadNotation, int i,
            List<String> result, char[] tempResult) {
        if (i == pNumber.length) {
            result.add(new String(tempResult));
            return;
        }
        String dialPadMatchingLetter = dialerPadNotation.get(pNumber[i]);
        if (dialPadMatchingLetter != null) {
            char[] dialPadMatchingChar = dialPadMatchingLetter.toCharArray();

            for (int j = 0; j < dialPadMatchingChar.length; j++) {
                tempResult[i] = dialPadMatchingChar[j];
                dialerPadHelper(pNumber, dialerPadNotation, i + 1, result, tempResult);
            }
        } else {
            // not matching word . just use the number
            tempResult[i] = pNumber[i];
            dialerPadHelper(pNumber, dialerPadNotation, i + 1, result, tempResult);
        }

    }

}
