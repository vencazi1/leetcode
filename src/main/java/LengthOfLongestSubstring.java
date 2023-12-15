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
        int stInd = 0;
        int endInd = 0;
        String  searchStr = "";
        int maxLength = 0;
        while(endInd < s.length()) {
            String nextChar = String.valueOf(s.charAt(endInd));
            if (searchStr.contains(nextChar)) {
                // Find lastIndex of the nextChar in the string 0 to end
                int lastIndexOf = s.substring(0, endInd).lastIndexOf(nextChar);
                stInd = lastIndexOf + 1;
                endInd = endInd + 1;
                if (endInd > s.length()) {
                    break;
                }
                searchStr = s.substring(stInd, endInd);
            } else {
                searchStr = searchStr + nextChar;
                endInd++;
            }
            maxLength = Integer.max(searchStr.length(), maxLength);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        LengthOfLongestSubstring lengthOfLongestSubstring = new LengthOfLongestSubstring();
        System.out.println(lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew"));
        // e - 6
        // a - 7
    }
}
