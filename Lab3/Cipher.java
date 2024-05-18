import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selection;
        String keyword = "";
        String toEncode;
        CipherList cipher = new CipherList(keyword);

        System.out.println("\n===== Lab 3: Cipher =====");
        do {
            
            System.out.println("Enter an integer to pick its option:");
            System.out.println("1 Enter Key word");  //takes new key word and re-aligns shifted array
            System.out.println("2 Encrypt message");  //takes a message of 140 characters and encrypts message
            System.out.println("3 Decrypt message"); //takes an encrypted massage of 140 characters and decrypts it
            System.out.println("9 Quit");  //exits program;
            
            selection = scan.nextInt();
            scan.nextLine();
            
            switch (selection) {
                case 1:  // set keyword
                    System.out.print("Keyword: ");
                    keyword = scan.nextLine();
                    cipher.setCipher(keyword);
                    break;
                
                case 2:  // encrypt
                    if (keyword.equals("")) {
                        System.out.println("Please assign a keyword to encrypt with.");
                    } else {
                        System.out.print("Phrase to encrypt: ");
                        toEncode = scan.nextLine();
                        
                        System.out.println(cipher.encrypt(toEncode));
                    }
                    break;
                
                case 3:  // decrypt
                    
                    break;
                
                case 9:  //
                    break;
            
                default:
                    break;
            }

        } while (selection != 9);
        scan.close();
    }
}
