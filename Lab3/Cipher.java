import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Cipher {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int selection;
        String keyword = "";
        String input;

        CipherList cipher = new CipherList(keyword);

        System.out.println("\n===== Lab 3: Cipher =====");
        do {
            
            System.out.println("Enter an integer to pick its option:");
            System.out.println("1 Enter Key word");  //takes new key word and re-aligns shifted array
            System.out.println("2 Encrypt message");  //takes a message of 140 characters and encrypts message
            System.out.println("3 Decrypt message"); //takes an encrypted massage of 140 characters and decrypts it
            System.out.println("4 create encrypted file"); // takes message and creates text file with encrypted message 
            System.out.println("5 decrypt file"); //Ask for file path, reads document and decrypts message
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
                        input = scan.nextLine();
                        
                        System.out.println(cipher.encrypt(input));
                    }
                    break;
                
                case 3:  // decrypt
                    if (keyword.equals("")) {
                        System.out.println("Please assign a keyword to encrypt with.");
                    } else {
                        System.out.print("Phrase to decrypt: ");
                        input = scan.nextLine();

                        System.out.println(cipher.decrypt(input));
                    }
                    break;

                case 4: // encrypt to file
                    if (keyword.equals(""))
                        System.out.println("Please assign a keyword to encrypt with.");
                    else {
                        System.out.print("Phrase to encrypt: ");
                        input = scan.nextLine();
                        String msg = cipher.encrypt(input);

                        try {
                            FileWriter file = new FileWriter("encrypted.txt");
                            file.write(msg);
                            file.close();
                            System.out.println("Message encrypted to encrypted.txt.");
                        } catch (IOException e) {
                            System.err.println("IO Error: message could not be written to encrypted.txt.");
                        }
                    }
                    break;

                case 5: // decrypt from file
                    if (keyword.equals("")) {
                        System.out.println("Please assign a keyword to encrypt with.");
                    } else {
                        try {
                            File file = new File("encrypted.txt");
                            Scanner fileReader = new Scanner(file);
                            System.out.println(cipher.decrypt(fileReader.nextLine()));
                            fileReader.close();
                        } catch (IOException e) {
                            System.err.println("IO Error: message could not be read from encrypted.txt.");
                        }
                    }
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
