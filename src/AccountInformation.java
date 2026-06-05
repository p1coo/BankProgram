import java.io.BufferedReader;
import java.io.FileReader;

public class AccountInformation {
    public static void accountInformation() {
        // Code for displaying account information
        try(BufferedReader reader = new BufferedReader(new FileReader("/home/pico/Projects/BaskProgram/BANKPROGRAM/AccountInformation.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
            
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
        }
    }
}
