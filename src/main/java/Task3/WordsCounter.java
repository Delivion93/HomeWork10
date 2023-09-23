package Task3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class WordsCounter {
    private final String FILE_PATH="src/main/java/Task3/words.txt";
    private List<Word> result = new ArrayList<>();
    private List<String> words = new ArrayList<>();
    private Set <String> uniqueWords = new HashSet<>();

    private void readWords(){
        try(Scanner scanner = new Scanner(new File(FILE_PATH))) {
            while (scanner.hasNext()){
                String line = scanner.nextLine();
                String[] lineWords = line.split("\s");
                for (String lineWord : lineWords) {
                    words.add(lineWord);
                }
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } ;
    }
    private void createSet(){
        for (String word : words) {
            uniqueWords.add(word);
        }
    }
    public void CountWords(){
        this.readWords();
        this.createSet();

        for (String uniqueWord : uniqueWords) {
            int counter =0;
            for (String word : words) {
                if(uniqueWord.equals(word)){
                    counter++;
                }
            }
            result.add(new Word(uniqueWord,counter));
        }
        Collections.sort(result, new WordsCountComparator());
        for (Word word : result) {
            System.out.println(word.getValue()+" "+word.getCounter());
        }
    }




}
class WordsCounterTest{
    public static void main(String[] args) {
        WordsCounter wd = new WordsCounter();
        wd.CountWords();
    }
}
