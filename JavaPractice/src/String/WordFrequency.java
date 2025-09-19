package String;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

//# Read from the file words.txt and output the word frequency list to stdout.
public class WordFrequency{
    public static void main(String[] args){
        String filePath = "C:\\Users\\nsinh\\Documents\\Projects\\Java\\JavaPractice\\src\\String\\word.txt";

        Map<String, Integer> wordCount = new HashMap<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;

            //read the file line by line
            while((line = br.readLine()) != null){
                //split line into words
                String[] words = line.toLowerCase().split("\\W+");

                for(String word:words){
                    if(!word.isEmpty()){
                        wordCount.put(word, wordCount.getOrDefault(word, 0)+1);
                    }
                }
            }

            //sort in desc freq
            wordCount.entrySet().stream().sorted((a,b) -> b.getValue().compareTo(a.getValue()))
            .forEach(entry->System.out.println(entry.getKey() + ":" + entry.getValue()));
        }catch(IOException e){
            System.err.println("Error reading the file: "+e.getMessage());
        }
    }
}