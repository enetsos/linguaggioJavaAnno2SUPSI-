package serie6.es2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.BiPredicate;
import java.util.function.Predicate;

public class FileReader {
    private static String find(List<String> words, BiPredicate<String, String> operation){
        String corrente = words.get(0);
        for (String string : words) {
            if(operation.test(corrente, string)){
                corrente = string;
            }
        }
        return corrente;
    }

    private static List<String> findAll(List<String> words, Predicate<String> operation){
        List<String> corrente = new ArrayList<>();
        for (String string : words) {
            if(operation.test(string)){
                corrente.add(string);
            }
        }
        return corrente;
    }

    public static void main(String[] args) {
        List<String> file = null;
        try {
            file = Arrays.asList(new String(Files.readAllBytes(Paths.get("src/serie6/es2/file.txt"))).split("\\s+"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String grande = find(file, (corrente, test) -> {
            if(corrente.length() < test.length())
                return true;
            return false;
        });

        String piccola = find(file, (corrente, test) -> {
            if(corrente.length() > test.length() && test.length() > 5)
                return true;
            return false;
        });

        System.out.println("La parola più lunga è: " + grande);
        System.out.println("La parola più corta è: " + piccola);

        List<String> iniziaVocali = findAll(file, (s) -> {
            if(s.startsWith("a") || s.startsWith("e") || s.startsWith("i") || s.startsWith("o") || s.startsWith("u"))
                return true;
            return false;
        });

        List<String> iniziaT = findAll(file, (s) -> {
            if(s.startsWith("T"))
                return true;
            return false;
        });

        System.out.println("Le parole che iniziano con vocali sono: " + iniziaVocali);
        System.out.println("Le parole che iniziano con T sono: " + iniziaT);    

    }
}
