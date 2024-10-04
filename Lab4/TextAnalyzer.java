public class TextAnalyzer {
    private String paragraph;
    private String[] words;
    private int[] wordFrequency;
    private String[] palindromicWords;
    private String longestWord;

    public TextAnalyzer(String paragraph) {
        this.paragraph = paragraph;
    }

    public void populateWords() {
        // words = paragraph.split(" ");
        int wordsNum = 1;
        for (int i = 0; i < paragraph.length(); i++) {
            if (paragraph.charAt(i) == ' ')
                wordsNum++;
        }
        String[] wordss = new String[wordsNum];
        int start = 0, end = 0;
        int index = 0;
        for (int i = 0; i < paragraph.length(); i++) {
            if (i == paragraph.length() - 1) {
                wordss[index] = paragraph.substring(start);
            }
            if (paragraph.charAt(i) == ' ') {
                wordss[index] = paragraph.substring(start, end + 1);
                index++;
                start = end + 1;
            }
            end++;
        }
        int unique = 0;
        for (int i = 0; i < wordss.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (wordss[i].equals(wordss[j]))
                    isUnique = false;
            }
            if (isUnique)
                unique++;
        }
        int lastCount = 0;
        for (int i = 0; i < wordss.length; i++) {
            if (wordss[i].equals(wordss[wordss.length - 1]))
                lastCount++;
        }

        // THERE'S SOME WEIRD BT, IN WHICH THE LAST WORD GETS IGNORED...WHICH IS WHY
        // WAS FORCED TO DO THIS
        if (lastCount > 1)
            unique--;
        words = new String[unique];
        int cnt = 0;
        for (int i = 0; i < wordss.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < i; j++) {
                if (wordss[i].equals(wordss[j]))
                    isUnique = false;
            }
            if (lastCount > 1) {
                if (i == wordss.length - 1)
                    break;
            }
            if (isUnique) {
                words[cnt] = wordss[i];
                cnt++;
            }
        }
        System.out.println(words.length);
        for (int i = 0; i < words.length; i++) {
            System.out.println(words[i]);
        }
    }

    public void populateWordFrequency() {
        // TODO: Populate the word frequency
        wordFrequency = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            int count = 0;
            for (int j = 0; j < words.length; j++) {
                if (words[i] == words[j])
                    count++;
            }
            wordFrequency[i] = count;
        }
    }

    private boolean isPalindrome(String word) {
        if (word == null)
            return false;
        // TODO: Implement the isPalindrome method
        for (int i = 0; i < word.length() / 2; i++) {
            if (word.charAt(i) != word.charAt(word.length() - 1 - i))
                return false;
        }
        return true;
    }

    public void populatePalindromicWords() {
        // TODO: Populate the palindromic words
        int count = 0;
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i]))
                count++;
        }
        palindromicWords = new String[count];
        int index = 0;
        for (int i = 0; i < words.length; i++) {
            if (isPalindrome(words[i])) {
                palindromicWords[index] = words[i];
                index++;
            }
        }
    }

    public void populateLongestWord() {
        // TODO: Populate the longest word
        int len = 0;
        for (int i = 0; i < words.length; i++) {
            if (words[i].length() > len) {
                len = words[i].length();
                longestWord = new String(words[i]);
            }
        }
    }

    public void displayResults() {
        if (longestWord == null)
            return;
        System.out.println("Count of unique words: " + words.length);
        System.out.println("Count of unique palindromes: " + palindromicWords.length);
        System.out.println("Longest word: " + longestWord);
    }

    // TODO: Implement the getters
    public String getParagraph() {
        return paragraph;
    }

    public String[] getWords() {
        return words;
    }

    public int[] getWordFrequency() {
        return wordFrequency;
    }

    public String[] getPalindromicWords() {
        return palindromicWords;
    }

    public String getLongestWord() {
        return longestWord;
    }

    // DO NOT MODIFY THE CODE BELOW
    public void solve() {
        populateWords();
        populateWordFrequency();
        populatePalindromicWords();
        populateLongestWord();
        displayResults();
    }
}