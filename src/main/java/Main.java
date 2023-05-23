import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {

    public static ArrayList<String> combine(String string, ArrayList<String> stringList) {
        ArrayList<String> newCombinations = new ArrayList<>();
        for (char c1character : string.toCharArray()) {
            for(String s : stringList) {
                for (char c2character: s.toCharArray()) {
                    String newString = String.valueOf(c1character) + c2character;
                    if (!newCombinations.contains(newString)) {
                        newCombinations.add(newString);
                    }
                }
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

    public static void main( String[] args ) {

        HashMap<Character, String> digitToLettersMap = initDigitToLettersMap();
        ArrayList<String> combinations = new ArrayList<>();

        String testString = "234";

        char c1 = testString.toCharArray()[0];
        char c2 = testString.toCharArray()[1];
        char c3 = testString.toCharArray()[2];

        String firstStr = digitToLettersMap.get(c1);
        String secondStr = digitToLettersMap.get(c2);
        String thirdStr = digitToLettersMap.get(c3);

        ArrayList<String> listContainingFirstString = new ArrayList<>();
        listContainingFirstString.add(secondStr);

        ArrayList<String> firstPlustSecondString = combine(firstStr, listContainingFirstString);
        System.out.println(firstPlustSecondString);
        ArrayList<String> lastPlusFirstTwoStrins = combine(thirdStr, firstPlustSecondString);

        System.out.println("String is " + testString);
        System.out.println("Output: " + lastPlusFirstTwoStrins);
        System.out.println("Number of combinations:" + lastPlusFirstTwoStrins.size());

        List<Character> newList = new ArrayList<>(Arrays.asList('a', 'b', 'c'));
    }
}
