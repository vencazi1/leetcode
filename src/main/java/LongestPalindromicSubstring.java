/**
 * Given a string s, return the longest palindromic substring in s.
 *
 * Example 1:
 *
 * Input: s = "babad"
 * Output: "bab"
 * Explanation: "aba" is also a valid answer.
 * Example 2:
 *
 * Input: s = "cbbd"
 * Output: "bb"
 *
 * 1 <= s.length <= 1000
 *
 */

public class LongestPalindromicSubstring {

    public boolean isPalindrome(String s) {
        return new StringBuilder(s).reverse().toString().equals(s);
    }

    public String longestPalindrome(String s) {
        if (s.length() == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder(s);
        StringBuilder reverseSb = new StringBuilder(s).reverse();
        int endIndex = 1;
        int startIndex = 0;
        String palanStr = "";
        String prevStr = "";
        String str = "";
        while(endIndex <= sb.length()) {
            str = reverseSb.substring(startIndex, endIndex);
            if (s.indexOf(str) != -1) {
                // substring exists
                // isPalindrome(s)
                if (isPalindrome(str)) {
                    prevStr = str;
                }
                endIndex = endIndex + 1;
            } else {
                // the substring with the newly added endIndex does not exist.
                palanStr = palanStr.length() > prevStr.length() ? palanStr : prevStr;
                // restart from startIndex + 1
                startIndex = startIndex + 1;
                endIndex = startIndex + 1;
            }
        }
        return palanStr.length() > prevStr.length() ? palanStr : prevStr;
    }

    public static void main(String[] args) {
        LongestPalindromicSubstring longestPalindromicSubstring = new LongestPalindromicSubstring();
        System.out.println(longestPalindromicSubstring.longestPalindrome("dabba"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("cbbd"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("a"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("ac"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("bab"));
        System.out.println(longestPalindromicSubstring.longestPalindrome("aacabdkacaa"));

    }

}
