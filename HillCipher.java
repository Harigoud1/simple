import java.util.*;

public class HillCipher {

    public static void encrypt(String message, int[][] keyMatrix) {
        message = message.toUpperCase().replaceAll("[^A-Z]", "");

        if (message.length() % 2 != 0) {
            message += "X";
        }

        for (int i = 0; i < message.length(); i += 2) {

            int[] msgVector = new int[2];
            int[] cipherVector = new int[2];

            msgVector[0] = message.charAt(i) - 'A';
            msgVector[1] = message.charAt(i + 1) - 'A';

            for (int j = 0; j < 2; j++) {
                cipherVector[j] = (keyMatrix[j][0] * msgVector[0] +
                                   keyMatrix[j][1] * msgVector[1]) % 26;
            }

            System.out.print((char)(cipherVector[0] + 'A'));
            System.out.print((char)(cipherVector[1] + 'A'));
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] keyMatrix = new int[2][2];

        System.out.println("Enter 2x2 key matrix:");

        for(int i = 0; i < 2; i++){
            for(int j = 0; j < 2; j++){
                keyMatrix[i][j] = sc.nextInt();
            }
        }

        sc.nextLine();
        System.out.println("Enter message:");
        String message = sc.nextLine();

        System.out.print("Encrypted Message: ");
        encrypt(message, keyMatrix);

        sc.close();
    }
}