import java.util.ArrayDeque;
import java.util.HashMap;

public class CipherList {
    private char[] alphabetArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private ArrayDeque<Character> shiftedStack = new ArrayDeque<Character>();
    private HashMap<Character, Integer> charToInt = new HashMap<Character, Integer>(26);

    public CipherList(String keyword) {
        populateMap();
        setCipher(keyword);
        System.err.println(shiftedStack);
    }  // end constructor

    public void setCipher(String keyword) {
        keyword = getUniqueKeyword(keyword.toUpperCase());

        // add keyword chars to front of shifted stack
        for (char c : keyword.toCharArray()) {
            shiftedStack.addLast(c);
        }

        // add the remaining chars
        for (char c : alphabetArr) {
            if (!shiftedStack.contains(c)) {
                shiftedStack.addLast(c);
            }
        }
    }

    /**
     * Encrypts a string of length 140 with the instance cipher.
     * @return encrypted string
     */
    public String encrypt(String input) {
        // for (char c : input.toCharArray()) {
        //     int alphabetPos = c - 'A'
        // }
        return "";
    }

    private String getUniqueKeyword(String keyword) {
        String output = "";
        for (char c : keyword.toCharArray()) {
            if (output.indexOf(c) == -1) {
                output += c;
            }
        }
        return output;
    }

    private void populateMap() {

    }

}  // end class
