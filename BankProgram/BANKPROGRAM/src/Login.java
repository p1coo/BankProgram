import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Scanner;

public class Login {
    public static void login() {
        Scanner scanner = new Scanner(System.in);
        String inputName;
        String inputPass;

        System.out.println("\n\n************************");
        System.out.println("** Welcome to VS bank **");
        System.out.println("************************");
        System.out.println("Please select an option:");
        System.out.println("1. Login");
        System.out.println("5. Exit");
        System.out.println("************************");
        System.out.print("Enter your choice: ");
        
        Main.userChoice = scanner.nextInt();
        scanner.nextLine();

        if (Main.userChoice == 1) {
            try(BufferedReader reader = new BufferedReader(new FileReader(FilePath.accIpath))) {
                String accName = reader.readLine();
                String accPass = reader.readLine();

                if (accName == null || accPass == null) {
                    System.out.println("No account data found. Please create an account first.");
                    CreateAccount.createAccount();
                    return;
                }

                accName = accName.trim();
                accPass = accPass.trim();

                System.out.print("Enter your name (in account): ");
                inputName = scanner.nextLine().trim();
                System.out.print("Enter your password (in account): ");
                inputPass = scanner.nextLine().trim();

                if(inputName.equals(accName) && inputPass.equals(accPass)) {
                    Reader.readBalance();
                    while (Main.isWork) {
                        System.out.println("\n\n************************");
                        System.out.println("** Welcome to VS bank **");
                        System.out.println("************************");
                        System.out.println("1. Account information");
                        System.out.println("2. Check balance");
                        System.out.println("3. Deposit");
                        System.out.println("4. Withdraw");
                        System.out.println("5. Exit");
                        System.out.println("************************");
                        System.out.print("Enter your choice: ");
                        
                        int menuChoice = scanner.nextInt();
                        scanner.nextLine();
                        
                        switch (menuChoice) {
                            case 1:
                                AccountInformation.accountInformation();
                                break;
                            case 2:
                                System.out.println("Current Balance: $" + Main.balance);
                                break;
                            case 3:
                                Deposit.deposit();
                                break;
                            case 4:
                                Withraw.withdraw();
                                break;
                            case 5:
                                System.out.println("Exiting VS Bank. Goodbye!");
                                Main.isWork = false;
                                break;
                            default:
                                System.out.println("Invalid choice.");
                        }
                    }
                } else {
                    System.out.println("Invalid username or password.");
                }
            } catch (Exception e) {
                System.out.println("An error occurred during login:");
                e.printStackTrace(); // ai tell me this line
            }
        } else if (Main.userChoice == 5) {
            Main.isWork = false;
        } else {
            System.out.println("Invalid choice.");
        } 
    }
}