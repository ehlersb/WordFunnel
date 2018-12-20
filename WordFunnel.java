import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Benjamin Ehlers on 12/20/2018.
 */
public class WordFunnel {

    private int count;
    private String word;

    public WordFunnel(String word, int count) {
        this.word = word;
        this.count = count;
    }

    public int maxWordFunnelCount(WordFunnel wordFunnel) throws FileNotFoundException {
        ArrayList<Integer> countList = new ArrayList<>();
        if(isInWordBank(wordFunnel.word)) wordFunnel.count++;
        wordFunnelCount(wordFunnel, countList);
        int maxCount = 0;
        for(int i : countList) {
            if (i > maxCount) maxCount = i;
        }
        return maxCount;
    }

    public void wordFunnelCount(WordFunnel wordFunnel, ArrayList<Integer> countList) throws FileNotFoundException {
        for(int i = 0; i < wordFunnel.word.length(); i++) {
            WordFunnel currentWordFunnel = new WordFunnel(wordFunnel.word, wordFunnel.count);
            currentWordFunnel.setWord(removeLetterAtIndex(wordFunnel.word, i));
            if(isInWordBank(currentWordFunnel.word))
                currentWordFunnel.count++;
            wordFunnelCount(currentWordFunnel, countList);
        }
        countList.add(wordFunnel.count);
    }

    private boolean isInWordBank(String word) throws FileNotFoundException {
        File wordBank = new File("wordbank.txt");
        Scanner scanner = new Scanner(wordBank);
        while(scanner.hasNextLine()) {
            String wordCheck = scanner.nextLine();
            if (word.equals(wordCheck))
                return true;
        }
        return false;
    }

    private String removeLetterAtIndex(String word, int index) {
        String substring = "";
        ArrayList<Character> characterArrayList = new ArrayList<>();
        char[] wordCharArray = word.toCharArray();
        for(char character : wordCharArray) {
            characterArrayList.add(character);
        }
        characterArrayList.remove(index);
        for(char character : characterArrayList) {
            substring += character;
        }
        return substring;
    }

    public String getWord() {
        return this.word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getCount() {
        return this.count;
    }
}
