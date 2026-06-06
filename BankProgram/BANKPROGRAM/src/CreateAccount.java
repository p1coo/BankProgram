import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.InputMismatchException;

public class CreateAccount {
    public final static void createAccount() {
        Scanner scanner = new Scanner(System.in);
        String name = null;
        String pass = null;

        try(BufferedReader reader = new BufferedReader(new FileReader(FilePath.accIpath))) {
            String line = reader.readLine();
            if(line == null){
                System.out.println("\n\n************************");
                System.out.println("** Welcome to VS bank **");
                System.out.println("************************");
                System.out.println("Please select an option:");
                System.out.println("1. Create an account");
                System.out.println("2. Exit");
                System.out.println("************************");
                System.out.print("Enter your choice: ");
                Main.userChoice = scanner.nextInt();
                scanner.nextLine(); 
            } else {
                Login.login();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Account file not found, creating a new one...");
            Main.userChoice = 1;
        } catch (IOException e) {
            System.out.print(e);
        }
        
        if(Main.userChoice == 1){
            try {
                System.out.print("Enter your name: ");
                name = scanner.nextLine();
                System.out.print("Enter a password: ");
                pass = scanner.nextLine();
                System.out.println("Creating account...\n");
                System.out.println("Account created successfully!");

                try(FileWriter writerB = new FileWriter(FilePath.accIpath)) {
                    writerB.write(name + "\n");
                    writerB.write(pass + "\n");
                } catch (Exception e) {
                    System.out.println("An error occurred while writing to the file.");
                }

                Login.login();

            } catch (InputMismatchException e) {
                System.out.println("Invalid input.");
            }
        } else if(Main.userChoice == 2){
            Main.isWork = false;
        }
    }
}