import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        System.out.print("Give a keyword for the cipher: ");
        String keyword = scan.nextLine();
        CipherList cipher = new CipherList(keyword);
        cipher.setCipher(scan.nextLine());
    }
}
