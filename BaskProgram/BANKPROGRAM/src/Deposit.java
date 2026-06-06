import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Deposit {
    public static double deposit(double balance) {
        // import scanner
        Scanner scanner = new Scanner(System.in);

        // Variable for deposit amount
        double depositAmount;
        
        try {
              // Code for depositing money into the account
              System.out.print("Deposit amount: ");
              depositAmount = scanner.nextDouble();
              balance += depositAmount;
              System.out.println("Deposit successful. New balance: $" + balance);
              Reader.readBalance(null, balance);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid deposit amount.");
        }    

        try(FileWriter writerC = new FileWriter("/home/pico/Projects/BaskProgram/BANKPROGRAM/src/account_balance.txt")) {
            writerC.write(Double.toString(balance));
        } catch (IOException e) {
            System.out.println("Error writing balance to file");
            return balance;
        }

        // return the new balance after deposit
        return balance;
    }
}
