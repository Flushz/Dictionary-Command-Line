import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;

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

            dictionary.put(newWord.getWord_target(), newWord.getWord_explain());
        }
    }

    public static void insertFromFile() {
        try {
            Scanner inputFile = new Scanner(new File("D:\\Source\\Dictionary\\src\\dictionary.txt"));

            while (inputFile.hasNext()) {
                Word word = new Word();

                String curLine = inputFile.nextLine();
                String[] splittedWords = curLine.split("\t");

                word.setWord_target(splittedWords[ 0 ].trim());
                word.setWord_explain(splittedWords[ 1 ].trim());

                dictionary.put(word.getWord_target(), word.getWord_explain());
            }
            inputFile.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static void dictionaryLookup() {
        System.out.print("Search: ");
        String needWord = input.next();
        System.out.println(dictionary.getOrDefault(needWord, "No matched word found!"));
    }

    public static void dictionaryEdit() {
        System.out.print("Search: ");
        String neededWord = input.next();
        input.nextLine();
        System.out.print("Meaning: ");
        String meaning = input.nextLine();

        dictionary.put(neededWord, meaning);
    }

    public static void dictionaryDelete() {
        System.out.print("Search: ");
        String neededWord = input.next();

        dictionary.remove(neededWord);
    }
}


