//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//

import java.security.SecureRandom;
import java.util.Scanner;

@SuppressWarnings("ConstantConditions")
class Main {
/* declaring constants*/
    private static final SecureRandom random = new SecureRandom();
    private static final String ALPHA_CAP = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String ALPHA = "abcdefghijklmnopqrstuvwxyz";
    private static final String NUMERICAL = "0123456789";
    private static final String SPECIAL_CHAR = "+-_=!@#$%^&*()[]";

    private static void Password(int length, String pType) {
        /* generate random password using the constant strings*/
        StringBuilder password = new StringBuilder();

        for(int i = 0; i < length; ++i) {
            int index = random.nextInt(pType.length());
            password.append(pType.charAt(index));
        }

        System.out.println(password);
    }

    private static void inputInfo() {
        /* get information about the number of characters and whether the user wants special characters or not*/
        Scanner scan = new Scanner(System.in);
        System.out.println("Input the number of characters");
        int length = scan.nextInt();
        System.out.println("Password contains: special characters? (Y/N)");
        String pType = scan.next().toUpperCase();
        switch (pType) {
            case "Y":
                Password(length, ALPHA_CAP + ALPHA + NUMERICAL + SPECIAL_CHAR);
                break;
            case "N":
                Password(length, ALPHA_CAP + ALPHA + NUMERICAL);
                break;
            default:
                System.out.println("There was an error");
                break;
        }

    }

    public static void main(String[] args) {
        System.out.println("Simple Password Generator");
        inputInfo();
        Scanner scan = new Scanner(System.in);
        boolean looping = true;

        while (looping){
            System.out.println("Do you want to restart?");
            String ans = scan.next();
            ans = ans.toUpperCase();
            if (ans.equals("N")) {
                break;
            }
            inputInfo();
        }

        System.out.println("Exited");
    }
}
