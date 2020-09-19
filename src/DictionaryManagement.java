import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Map;
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
        System.out.print("Search for editing: ");
        String neededWord = input.next();
        input.nextLine();
        System.out.print("Meaning: ");
        String meaning = input.nextLine();

        dictionary.put(neededWord, meaning);
    }

    public static void dictionaryDelete() {
        System.out.print("Search for deleting: ");
        String neededWord = input.next();

        if (dictionary.containsKey(neededWord)) {
            dictionary.remove(neededWord);
        } else {
            System.out.println("No matched word found!");
        }
    }

    public static boolean naivePatternSearch(String mainString, String pattern) {
        int patLength = pattern.length();
        int mainLength = mainString.length();

        for (int i = 0; i <= (mainLength - patLength); ++i) {
            int j;
            for (j = 0; j < patLength; ++j) {
                if (mainString.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            if (j == patLength) {
                return true;
            }
        }
        return false;
    }

    public static void dictionaryExportToFile() {
        try {
            System.out.println("Enter file name: ");
            String fileName = input.next();
            File exportedDict = new File(fileName);

            if (exportedDict.createNewFile()) {
                FileWriter fileWriter = new FileWriter(exportedDict);
                for(Map.Entry<String, String> word : dictionary.entrySet()) {
                    fileWriter.write(word.getKey() + "\t" + word.getValue() + "\n");
                }
                fileWriter.close();
            } else {
                System.out.println("Can not create new file! File already exists!");
            }
        } catch(IOException exception) {
            System.out.println("An error occurred!");
            exception.printStackTrace();
        }
    }

}


