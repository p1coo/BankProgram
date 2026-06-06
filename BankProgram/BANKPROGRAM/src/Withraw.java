import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Withraw {
    public static double withdraw() {
        // import scanner
        Scanner scanner = new Scanner(System.in);

        // Variable for withdraw amount
        double withdrawAmount;


        try {
              // Code for withdrawing money from the account
              System.out.print("Withdraw amount: ");
              withdrawAmount = scanner.nextDouble();
               Main.balance -= withdrawAmount;
              System.out.println("Withdrawal successful. New balance: $" + Main.balance);
              Reader.readBalance();
        } catch (Exception e) {
            System.out.println("Invalid input. Please enter a valid withdraw amount.");
        }
        

        try(FileWriter writerD = new FileWriter(FilePath.accBpath)) {
            writerD.write(Double.toString(Main.balance));
        } catch (IOException e) {
            System.out.println("Error writing balance to file");

        }

        // return the new balance after withdraw
        return Main.balance;
    }
}
