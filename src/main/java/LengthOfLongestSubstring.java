import java.util.HashMap;
import java.util.Map;

/**
 * Given a string s, find the length of the longest
 * substring
 *  without repeating characters.
 *
 *
 *
 * Example 1:
 *
 * Input: s = "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 * Example 2:
 *
 * Input: s = "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 * Example 3:
 *
 * Input: s = "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 * Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */

public class LengthOfLongestSubstring {

    public int lengthOfLongestSubstring(String s) {
        int eIndex = 0;
        int maxLength = 0;
        Map<Character, Character> map = new HashMap<>();
        String str = "";
        while(eIndex < s.length()) {
            String nextStr = String.valueOf(s.charAt(eIndex));
            if (str.contains(nextStr)) {
                maxLength = str.length() > maxLength ? str.length() : maxLength;
                // Update str
                str = str.substring(str.indexOf(nextStr) + 1, str.length()) + nextStr;
            } else {
                str = str + nextStr;
            }
            eIndex++;
        }
        return str.length() > maxLength ? str.length() : maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("dvdf"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("aaaaaa"));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(""));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring(" "));
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("   "));

        // e - 6
        // a - 7
    }
}
