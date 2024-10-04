public class Practice {
    int a = 5;

    // consturcting the class
    public Practice(int a) {
        // System.out.println("Practice class is created");
        this.a = a;
    }

    public int[] getUniqueNumbers(String numbers) {
        String[] num = numbers.split(", ");
        int[] intarr = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            intarr[i] = Integer.parseInt(num[i]);
        }
        int[] uniqueLarge = new int[intarr.length];
        int count = 0;
        for (int i = 0; i < intarr.length; i++) {
            boolean isUnique = true;
            for (int j = 0; j < count; j++) {
                if (uniqueLarge[j] == intarr[i]) {
                    isUnique = false;
                    break;
                }
            }
            if (isUnique) {
                uniqueLarge[count] = intarr[i];
                count++;
            }
        }
        int[] uniqueNumbers = new int[count];
        System.arraycopy(uniqueLarge, 0, uniqueNumbers, 0, count);
        return uniqueNumbers;
    }

    public boolean isPalindrome(String word) {
        String reverse = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reverse += word.charAt(i);
        }
        return word.equals(reverse);
    }

    public static void main(String[] args) {
        Practice practice = new Practice(4);
        int[] uniqueNumbers = practice.getUniqueNumbers("1, 2, 3, 4, 5, 1, 2, 3, 4, 5");
        for (int number : uniqueNumbers) {
            System.out.println(number);
        }
        System.out.println("Length: " + uniqueNumbers.length); // Should be 5 for the given sample
        String notPalin = "hello";
        String palin = "racecar";
        System.out.println(notPalin + " is a palindrome: " + practice.isPalindrome(notPalin));
        System.out.println(palin + " is a palindrome: " + practice.isPalindrome(palin));
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }
}
