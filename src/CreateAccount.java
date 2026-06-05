import java.util.Scanner;
import java.io.FileWriter;
import java.util.InputMismatchException;

public class CreateAccount {
    public static void createAccount() {
        // Code for creating an account

        // Import Scanner class to read user input
        Scanner scanner = new Scanner(System.in);

        // Variables
        String name = null;
        int age = 0;
        String pass = null;

        try {

            // Ask user for name and age
        System.out.print("Enter your name: ");
        name = scanner.nextLine();
        System.out.print("Enter your age: ");
        age = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character left by nextInt()
        System.out.print("Enter a password: ");
        pass = scanner.nextLine();
        System.out.println("Creating account...");

        System.out.println("Account created successfully!");

        } catch (InputMismatchException e) {
            System.out.println("Invalid input. Please enter a valid name and age.");
        }

        try(FileWriter writerB = new FileWriter("/home/pico/Projects/BaskProgram/BANKPROGRAM/AccountInformation.txt")) {
            writerB.write("Name: " + name + "\n");
            writerB.write("Age: " + age + "\n");
            writerB.write("Password: " + pass + "\n");
        } catch (Exception e) {
            System.out.println("An error occurred while writing to the file.");
        }
    }
}
