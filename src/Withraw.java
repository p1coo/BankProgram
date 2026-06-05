import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Withraw {
    public static double withraw(double balance) {
        // import scanner
        Scanner scanner = new Scanner(System.in);

        // Variable for withdraw amount
        double withdrawAmount;


        try {
              // Code for withdrawing money from the account
              System.out.print("Withdraw amount: ");
              withdrawAmount = scanner.nextDouble();
               balance -= withdrawAmount;
              System.out.println("Withdrawal successful. New balance: $" + balance);
              Reader.readBalance(null, balance);
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid withdraw amount.");
        }
        

        try(FileWriter writerD = new FileWriter("/home/pico/Projects/BaskProgram/BANKPROGRAM/src/account_balance.txt")) {
            writerD.write(Double.toString(balance));
        } catch (IOException e) {
            System.out.println("Error writing balance to file");

        }

        // return the new balance after withdraw
        return balance;
    }
}
