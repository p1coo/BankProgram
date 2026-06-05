import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // filePath for storing account balance
        String filePath = "/home/pico/Projects/BaskProgram/BANKPROGRAM/src/account_balance.txt";

        // Variable for user's choice or something else
        int userChoice; // see the user's choice for the menu options
        boolean isWork = true; // see if the user wants to exit the program
        double balance = 0.0; // see the user's balance

        // Main loop for the program
        while (isWork) {
            // Welcome message and options
            welcomeMsg();
            userChoice = scanner.nextInt();

            // use switch statement to handle user's choice
            switch (userChoice) {
                case 1:
                    // Code for choice 1
                    CreateAccount.createAccount();
                    break;
                case 2:
                    // Code for choice 2
                    AccountInformation.accountInformation();
                     break;
                case 3:
                     // Code for choice 3
                     balance = Deposit.deposit(balance);
                     break;
                case 4:
                     // Code for choice 4
                     balance = Withraw.withraw(balance);
                     break;
                case 5:
                     // Code for choice 5
                     balance = Reader.readBalance(filePath, balance);
                     System.out.println("Current balance: $" + balance);
                     break;
                case 6:
                     // Code for choice 6
                     System.out.println("Exiting the program. Goodbye!");
                     isWork = false;
                 default:
                     System.out.println("Invalid choice");
                     break;
            }   
        }      
    }
    static void welcomeMsg(){
        System.out.println("\n\n************************");
        System.out.println("** Welcome to VS bank **");
        System.out.println("************************");
        System.out.println("Please select an option:");
        System.out.println("1. Create an account");
        System.out.println("2. Account information");
        System.out.println("3. Deposit");
        System.out.println("4. Withdraw");
        System.out.println("5. Check balance");
        System.out.println("6. Exit");
        System.out.println("************************");
        System.out.print("Enter your choice: ");
    }
}