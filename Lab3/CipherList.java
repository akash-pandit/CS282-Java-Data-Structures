import java.util.ArrayDeque;

public class CipherList {
    private char[] alphabetArr = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private ArrayDeque<Character> shiftedStack;
    private String keyword;

    public String getCipher() {
        return keyword;
    }

    public ArrayDeque<Character> getEncryptStack() {
        return shiftedStack;
    }

    public CipherList(String keyword) {
        setCipher(keyword);
    }  // end constructor

    /**
     * Shifts the positions of letters based on an inputted keyword
     * @param keyword
     */
    public void setCipher(String keyword) {
        keyword = getUniqueKeyword(keyword);
        shiftedStack = new ArrayDeque<Character>();

        // add keyword chars to front of shifted stack
        for (char c : keyword.toCharArray()) {
            if (Character.isAlphabetic(c)) {
                shiftedStack.addLast(c);
            }
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
     * @param toEncrypt
     * @return encrypted string
     */
    public String encrypt(String toEncrypt) {
        toEncrypt = toEncrypt.toUpperCase();
        String output = "";

        for (int i = 0; i < toEncrypt.length(); i++) {
            char ch = toEncrypt.charAt(i);
            if (Character.isLetter(ch)) {
                int charPos = ch - 'A';
                output += (char) shiftedStack.toArray()[charPos];
            } else {
                output += ch;
            }
        }
        System.out.println(shiftedStack);
        return output;
    }


    public String decrypt(String toDecrypt) {
        toDecrypt = toDecrypt.toUpperCase();
        String output = "";
        int[] charPositions = getDecryptPosition(toDecrypt);

        for (int i = 0; i < toDecrypt.length(); i++) {
            char ch = toDecrypt.charAt(i);
            if (Character.isLetter(ch)) {
                int charPos = charPositions[i];
                output += (char) alphabetArr[charPos];
            } else {
                output += ch;
            }
        }
        return output;
    }


    private int[] getDecryptPosition(String toDecrypt) {
        int[] positions = new int[toDecrypt.length()];

        for (int pos_idx = 0; pos_idx < toDecrypt.length(); pos_idx++) {
            char ch = toDecrypt.charAt(pos_idx);
            if (!Character.isLetter(ch)) {
                positions[pos_idx] = -1;
                continue;
            }

            for (int chArr_idx = 0; chArr_idx < 26; chArr_idx++) {
                char shiftedChar = (char) shiftedStack.toArray()[chArr_idx];

                if (ch == shiftedChar)
                    positions[pos_idx] = chArr_idx;
            }
        }
        return positions;
    }

    /**
     * removes duplicate characters and case-sensitivity from the cipher keyword
     * @param keyword the cipher keyword
     * @return the cleaned keyword
     */
    private String getUniqueKeyword(String keyword) {
        String output = "";
        for (char c : keyword.toCharArray()) {
            if (output.indexOf(c) == -1) {
                output += c;
            }
        }
        return output.toUpperCase();
    }
}  // end class
