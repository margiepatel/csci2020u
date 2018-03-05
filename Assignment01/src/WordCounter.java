import java.io.*;
import java.util.*;

/*
    Name: Margie Patel and Tijauni Carey
    Date: 5/03/2018
    Name of Program: Spam Master 3000
*/

public class WordCounter {
    private Map<String,Integer> wordCounts;

    public WordCounter() {
        wordCounts = new TreeMap<>();
    }

    /*
        The countWord method counts the words inside the file required
        @param word - is a single word
    */
    private void countWord(String word) {
        if (wordCounts.containsKey(word)) {
            //Increments the count
            int oldCount = wordCounts.get(word);
            wordCounts.put(word, oldCount+1);
        } else {
            //Adds the word with a count of 1
            wordCounts.put(word, 1);
        }
    }

    /*
        The isWord method checks to see if the word is actually a word
        @param token - is a single word token
    */
    private boolean isWord(String token) {
        String pattern = "^[a-zA-Z]*$";
        if (token.matches(pattern)) {
            return true;
        } else {
            return false;
        }
    }

    /*
        The fileProcess method finds the words in the file
        required
        @param file- the name of the file and the information of the file
    */
    public void fileProcess(File file) throws IOException {
        if (file.isDirectory()) {
            //Used for directories, recursively call
            File[] filesInDir = file.listFiles();
            for (int i = 0; i < filesInDir.length; i++) {
                fileProcess(filesInDir[i]);
            }
        } else {
            //Used for single files, loads the words and count
            Scanner scanner = new Scanner(file);
            while (scanner.hasNext()) {
                String word = scanner.next();
                if (isWord(word)) {
                    countWord(word);
                }
            }
        }
    }

    /*
       The printWordCounts method prints out the word count
       @return map returns the wordCount of the map which contains a string and a number
    */
    public Map<String,Integer> printWordCounts() throws IOException {
        return wordCounts;
    }
}
