import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static double readBalance() {

        try (BufferedReader reader = new BufferedReader(new FileReader(FilePath.accBpath))) {
            String line = reader.readLine();
            
            if (line != null && !line.trim().isEmpty()) {
                Main.balance = Double.parseDouble(line.trim());
            }
        } catch (IOException | NumberFormatException e) {
            System.out.println("Error reading balance from file.");
        }
        return Main.balance;
    }
}