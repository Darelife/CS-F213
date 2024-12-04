public class TextAnalyzer {
    private String paragraph;
    private String[] words;
    private int[] wordFrequency;
    private String[] palindromicWords;
    private String longestWord;

    public TextAnalyzer(String paragraph) {
        this.paragraph = paragraph;
    }

    
    public void populateWords(){
        // TODO: Split the paragraph into all the words

    }

    public void populateWordFrequency(){
        // TODO: Populate the word frequency
    }

    private boolean isPalindrome(String word){
         // TODO: Implement the isPalindrome method
         return false;
    }

    public void populatePalindromicWords(){
        // TODO: Populate the palindromic words
    }

    public void populateLongestWord(){
        // TODO: Populate the longest word
    }

    public void displayResults(){
        if(longestWord==null)
            return;
        System.out.println("Count of unique words: " + words.length);
        System.out.println("Count of unique palindromes: " + palindromicWords.length);
        System.out.println("Longest word: " + longestWord);
    }

    // TODO: Implement the getters

    // DO NOT MODIFY THE CODE BELOW
    public void solve(){
        populateWords();
        populateWordFrequency();
        populatePalindromicWords();
        populateLongestWord();
        displayResults();
    }
}