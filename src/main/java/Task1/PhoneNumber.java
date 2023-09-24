package Task1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class PhoneNumber {
    private static final String REG_EX="^\\d{3}-\\d{3}-\\d{4}$|^[(]\\d{3}[)]\\s\\d{3}-\\d{4}$";
    private static final String FILE_PATH="src/main/java/Task1/file.txt";


    public void phoneNumberCheck(){
        try(Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNext()){
                String string = scanner.nextLine();
                if(string.matches(REG_EX)){
                    System.out.println(string);
                }
            }
        }
        catch (FileNotFoundException e){
            throw new RuntimeException();
        }
    }
}
class PhoneNumberTest{
    public static void main(String[] args) {
        PhoneNumber phoneNumber = new PhoneNumber();
        phoneNumber.phoneNumberCheck();
    }
}

