import java.util.Map;
import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement {
    private static final int FIRST_INDEX = 1;

    private static final Scanner input = new Scanner(System.in);

    public static void showAllWords() {
        int wordOrder = FIRST_INDEX;

        System.out.printf("%-4s| %-15s| %-15s%n", "No", "English", "Vietnamese");
        for (Map.Entry<String, String> word : dictionary.entrySet()) {
            System.out.printf("%-4d| %-15s| %-15s%n", wordOrder++, word.getKey(), word.getValue());
        }
    }

    public static void dictionarySearcher() {
        System.out.println("Search for: ");
        String pattern = input.next();

        boolean isExisted = false;
        for(Map.Entry<String, String> word : dictionary.entrySet()) {
            String mainString = word.getKey();

            if(naivePatternSearch(mainString, pattern)) {
                System.out.println(mainString);
                isExisted = true;
            }
        }

        if (!isExisted) {
            System.out.println("No word found!");
        }
    }

    public static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandLine();
        showAllWords();
    }

    public static void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile();
        DictionaryManagement.dictionaryLookup();
        DictionaryManagement.dictionaryEdit();
        DictionaryManagement.dictionaryDelete();
        showAllWords();
    }
}
