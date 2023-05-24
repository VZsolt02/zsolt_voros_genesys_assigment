import java.util.List;
import java.util.Scanner;

public class Main {


    public static void main( String[] args ) {

        Scanner sc = new Scanner(System.in);
        Combiner combiner = new Combiner();

        String input = "";
        boolean isValid;
        do {
            System.out.print("Input: ");
            input = sc.nextLine();
            isValid = combiner.validate(input);
            if (!isValid) {
                System.out.println("Invalid input!");
            }
        } while (!isValid);

        List<String> combinations = combiner.getAllCombinations(input);

        System.out.println("Output: " + combinations);
    }
}
