import java.io.BufferedReader;
import java.io.Console;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static List<String> combine(String first, List<String> second) {
        List<String> newCombinations = new ArrayList<>();

        if (second.isEmpty()) {
            second.add("");
        }

        for (char strcharacter : first.toCharArray()) {
            for (String str2 : second) {
                String newString = str2 + strcharacter;
                newCombinations.add(newString);
            }
        }

        return newCombinations;
    }

    public static List<String> combine(String first, String second) {
        List<String> newCombinations = new ArrayList<>();
        for (char s1character : first.toCharArray()) {
            for (char s2character : second.toCharArray()) {
                String newString = String.valueOf(s1character) + s2character;
                newCombinations.add(newString);
            }
        }


        return newCombinations;
    }
    public static HashMap<Character, String> initDigitToLettersMap() {
        HashMap<Character, String> digitToLettersMap = new HashMap<>();
        digitToLettersMap.put('2', "abc");
        digitToLettersMap.put('3', "def");
        digitToLettersMap.put('4', "ghi");
        digitToLettersMap.put('5', "jkl");
        digitToLettersMap.put('6', "mno");
        digitToLettersMap.put('7', "pqrs");
        digitToLettersMap.put('8', "tuv");
        digitToLettersMap.put('9', "wxyz");

        return digitToLettersMap;
    }

    public static boolean validate(String input) {
        if (input == null) return false;
        if (input.length() > 4) return false;

        for (char inputchar : input.toCharArray()) {
            if (Integer.parseInt(String.valueOf(inputchar)) < 2) {
                return false;
            }
        }

        return true;
    }
    public static String readInput() {
        Scanner sc = new Scanner(System.in);
        String input = "";
        do {
            System.out.println("Your input: ");
            input = sc.nextLine();
        } while (!validate(input));

        return input;
    }


    public static void main( String[] args ) {

        HashMap<Character, String> digitToLettersMap = initDigitToLettersMap();

        String testString = readInput();


        List<String> combinations = new ArrayList<>();
        for (char strcharacter : testString.toCharArray()) {
            combinations = combine(digitToLettersMap.get(strcharacter), combinations);
            System.out.println(combinations);
            System.out.println("Combinations: " + combinations.size());
        }

    }
}
