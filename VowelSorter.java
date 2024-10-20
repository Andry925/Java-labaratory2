import java.util.Scanner;

public class VowelSorter {

    public static int countVowels(StringBuffer word) {
        int count = 0;
        String vowels = "aeiouAEIOU";

        for (int i = 0; i < word.length(); i++) {
            if (vowels.indexOf(word.charAt(i)) != -1) {
                count++;
            }
        }
        return count;
    }

    public static int countWordsInText(StringBuffer text) {
        int wordCount = 1;
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) == ' ') {
                wordCount += 1;
            }
        }
        return wordCount;
    }

    public static StringBuffer[] splitGivenText(StringBuffer text, int wordCount) {
        StringBuffer[] wordsInBuffer = new StringBuffer[wordCount];
        int currentWordIndex = 0;
        wordsInBuffer[currentWordIndex] = new StringBuffer();

        for (int i = 0; i < text.length(); i++) {
            char currentChar = text.charAt(i);
            if (currentChar == ' ') {
                currentWordIndex++;
                wordsInBuffer[currentWordIndex] = new StringBuffer();
            } else {
                wordsInBuffer[currentWordIndex].append(currentChar);
            }
        }
        return wordsInBuffer;
    }

    
    public static void sortWordsByVowelAmount(StringBuffer[] words) {
        for (int i = 0; i < words.length - 1; i++) {
            for (int j = 0; j < words.length - 1 - i; j++) {
                if (countVowels(words[j]) > countVowels(words[j + 1])) {
                    StringBuffer temp = words[j];
                    words[j] = words[j + 1];
                    words[j + 1] = temp;
                }
            }
        }
    }

    
    public static StringBuffer joinSortedWordsBack(StringBuffer[] words) {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < words.length; i++) {
            result.append(words[i]);
            if (i < words.length - 1) {
                result.append(" ");
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Text that needs to be sorted ");
        String text = scanner.nextLine();

        StringBuffer textGiven = new StringBuffer(text);
        int wordCount = countWordsInText(textGiven);
        StringBuffer[] words = splitGivenText(textGiven, wordCount);

        sortWordsByVowelAmount(words);
        StringBuffer sortedText = joinSortedWordsBack(words);

        System.out.println("Text that is sorted: " + sortedText); 
    }
}
