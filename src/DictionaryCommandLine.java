public class DictionaryCommandLine extends DictionaryManagement {

    private static final int FIRST_INDEX = 1;

    public static void showAllWords() {
        int wordOrder = FIRST_INDEX;

        System.out.printf("%-4s |%-15s |%-15s%n", "No", "English", "Vietnamese");
        for (Word word : dictionary) {
            System.out.printf("%-4d| %-15s| %-15s%n", wordOrder++, word.getWord_target(), word.getWord_explain());
        }
    }

    public static void dictionaryBasic() {
        DictionaryManagement.insertFromCommandLine();
        DictionaryManagement.insertFromFile();
        showAllWords();
    }

    public static void dictionaryAdvanced() {
        DictionaryManagement.insertFromFile();
        DictionaryManagement.dictionaryLookup();
        showAllWords();
    }
}
