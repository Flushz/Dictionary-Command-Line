import java.util.Scanner;

public class DictionaryManagement extends Dictionary {
    private static final Scanner input = new Scanner(System.in);

    public static void insertFromCommandLine() {
        System.out.println("Number of words: ");
        int number = input.nextInt();

        for (int i = 0; i < number; ++i) {
            Word newWord = new Word();

            System.out.print("New word: ");
            newWord.setWord_target(input.next());

            input.nextLine();

            System.out.print("Explanation in Vietnamese: ");
            newWord.setWord_explain(input.nextLine());

            words.add(newWord);
        }
    }
}
/*
    public static int compareTwoWords(Word word1, Word word2) {
        return word1.word_target.compareTo(word2.word_target);
    }


    public static void sortDictionary() {
        for (int i = 1; i < words.size(); ++i) {
            Word currentWord = words.get(i);
            int hole = i;

            while (hole > 0 && compareTwoWords(words.get(hole - 1), currentWord) > 0) {
                words.set(i, words.get(i - 1));
                hole -= 1;
            }
            words.set(hole, currentWord);
        }
    }*/
