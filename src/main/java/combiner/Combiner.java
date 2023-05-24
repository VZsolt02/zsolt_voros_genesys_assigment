import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Combiner {

    private static final int MAX_LENGTH = 4;
    private HashMap<Character, String> digitToLettersMap;

    public Combiner() {
        digitToLettersMap = new HashMap<>();
        digitToLettersMap.put('2', "abc");
        digitToLettersMap.put('3', "def");
        digitToLettersMap.put('4', "ghi");
        digitToLettersMap.put('5', "jkl");
        digitToLettersMap.put('6', "mno");
        digitToLettersMap.put('7', "pqrs");
        digitToLettersMap.put('8', "tuv");
        digitToLettersMap.put('9', "wxyz");
    }

    public boolean validate(String digits) {

        if (digits == null) return false;
        if (digits.length() > MAX_LENGTH) return false;

        if (digits.equals("")) return true;

        for (char digit : digits.toCharArray()) {
            if (!digitToLettersMap.containsKey(digit)) {
                return false;
            }
        }

        return true;
    }

    public List<String> combine(String first, List<String> second) {
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

    public List<String> getAllCombinations(String digits) {
        List<String> combinations = new ArrayList<>();
        for (char strcharacter : digits.toCharArray()) {
            combinations = combine(digitToLettersMap.get(strcharacter), combinations);
        }

        return combinations;
    }
}
