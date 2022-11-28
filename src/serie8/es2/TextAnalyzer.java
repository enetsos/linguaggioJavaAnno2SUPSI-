package serie8.es2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

//Svolto da Walter Losa e Adriano Chiriacò
public class TextAnalyzer {
    public static void main(String[] args) {
        try {
            List<String> testo = Arrays.asList(new String(Files.readAllBytes(Paths.get("src/es2/file.txt"))).split("\\s+"));
            System.out.println("Parola più lunga: " + longestWord(testo));
            System.out.println("Parola più corta: " + shortestWord(testo));
            System.out.println("Parola con più vocali: " + highestVowelWord(testo));
            System.out.println("Parola con almeno 10 caratteri: " + firstWordAtLeast10ch(testo));
            //testo.stream().filter((word) -> word.length()>10).forEach(System.out::println);
        }catch(IOException ioe){
            System.out.println(ioe.getMessage());
        }
    }

    private static String longestWord(List<String> words) {
        return words.stream().max(Comparator.comparing(String::length)).orElse("<not found>");
    }

    private static String shortestWord(List<String> words) {
        return words.stream().min(Comparator.comparing(String::length)).orElse("<not found>");
    }

    private static String highestVowelWord(List<String> words) {
        Collections.sort(words,(a,b)->getVowels(b)-getVowels(a));
        return words.get(0);
    }

    private static String firstWordAtLeast10ch(List<String> words){
        String atLeast10 = words.stream().filter((word)->word.length() > 10).findFirst().get();

        return atLeast10;
    }

    private static int getVowels(String str){
        int tot = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i)=='a'||str.charAt(i)=='e'||str.charAt(i)=='i'||str.charAt(i)=='o'||str.charAt(i)=='u'){
                tot++;
            }
        }
        return tot;
    }
}
