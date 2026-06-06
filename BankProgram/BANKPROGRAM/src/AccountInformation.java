import java.io.BufferedReader;
import java.io.FileReader;

public class AccountInformation {
    public final static void accountInformation() {
        try(BufferedReader reader = new BufferedReader(new FileReader(FilePath.accIpath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            System.out.println("An error occurred while reading the file.");
        }
    }

    public final static void welcome() {
        try(BufferedReader reader = new BufferedReader(new FileReader(FilePath.accIpath))) {
            String accName = reader.readLine();
            String accPass = reader.readLine();
            
            if (accName == null || accPass == null || accName.trim().isEmpty() || accPass.trim().isEmpty()) {
                CreateAccount.createAccount();
            } else {
                Login.login();
            }
        } catch (Exception e) {
            CreateAccount.createAccount();
        }
    }
}