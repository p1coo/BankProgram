import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Deposit {
    public static double deposit() {
        // import scanner
        Scanner scanner = new Scanner(System.in);

        // Variable for deposit amount
        double depositAmount;
        
        try {
              // Code for depositing money into the account
              System.out.print("Deposit amount: ");
              depositAmount = scanner.nextDouble();
              Main.balance += depositAmount;
              System.out.println("Deposit successful. New balance: $" + Main.balance);
              Reader.readBalance();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid deposit amount.");
        }    

        try(FileWriter writerC = new FileWriter(FilePath.accBpath)) {
            writerC.write(Double.toString(Main.balance));
        } catch (IOException e) {
            System.out.println("Error writing balance to file");
            return Main.balance;
        }

        // return the new balance after deposit
        return Main.balance;
    }
}
