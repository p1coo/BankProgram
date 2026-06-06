import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static double readBalance(String filePath, double balance) {

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            
            if (line != null && !line.trim().isEmpty()) {
                balance = Double.parseDouble(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading balance from file.");
        }
        return balance;
    }
}