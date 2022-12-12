package serieRecap.es3;

import java.util.stream.Stream;

public class Exercise3 {

    public static void main(String[] args) {
        final String input = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod " +
                "tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, " +
                "quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. " +
                "Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu " +
                "fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in " +
                "culpa qui officia deserunt mollit anim id est laborum.";

        final Stream<Character> samlpeCharacterStream = input.chars().mapToObj(c -> Character.valueOf((char) c));
        System.out.println(input.chars().distinct().count());

        System.out.println(input.chars().anyMatch(Character::isDigit));
    }
}