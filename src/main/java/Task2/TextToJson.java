package Task2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TextToJson {
    private final String FILE_PATH="src/main/java/Task2/file.txt";
    private final String JSON_FILE_PATH="src/main/java/Task2/user.json";
    private List <User> userList = new ArrayList<>();



    private void textToObject(){
        try(Scanner scanner = new Scanner(new File(FILE_PATH))){
            while (scanner.hasNext()){
                String string = scanner.nextLine();
                if(!string.equals("name age")){
                    String[] fields = string.split("\s");
                    userList.add(new User(fields[0],Integer.parseInt(fields[1])));
                }
            }
        }
        catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
    private void objectToJsonFile(){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(userList);
        try (FileWriter writer = new FileWriter(JSON_FILE_PATH)){
            writer.write(json);
            writer.flush();
        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
    public void textToJsonFile(){
        this.textToObject();
        this.objectToJsonFile();
    }

}
class TextToJsonTest{
    public static void main(String[] args) {
        TextToJson ttj = new TextToJson();
        ttj.textToJsonFile();
    }
}


