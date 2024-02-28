import java.util.Arrays;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.counting;
import static java.util.stream.Collectors.groupingBy;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 *
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 *
 * Constraints:
 *
 * 1 <= strs.length <= 200
 * 0 <= strs[i].length <= 200
 * strs[i] consists of only lowercase English letters.
 */
public class LongestCommonPrefix {

    /*public String longestCommonPrefix(String[] strs) {
        Map<String, Long> map = Arrays.stream(strs).map(str -> str.split(""))
                .flatMap(strArray -> Arrays.stream(strArray).distinct()).collect(groupingBy(s->s, counting()));
        return map.keySet().stream().filter(key -> map.get(key) == strs.length).reduce("", (a,b) -> a+b);
    }*/

    /**
     * Highly efficient.
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        Arrays.sort(strs);
        String firstStr = strs[0];
        String lastStr = strs[strs.length-1];
        int ind1 = 0;
        int ind2 = 0;
        while(ind1 < firstStr.length() && ind2 < lastStr.length()) {
            if (firstStr.charAt(ind1) == lastStr.charAt(ind2)) {
                ind1++;
                ind2++;
            } else {
                break;
            }
        }
        return firstStr.substring(0, ind1);
    }


    /**
     * The below could be a O(n^2)
     * @param strs
     * @return
     */
    public String longestCommonPrefix1(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String firstStr = strs[0];
        String[] rStrs = new String[strs.length-1];
        System.arraycopy(strs, 1, rStrs, 0, strs.length-1);
        int endIndex = 1;
        String resultStr = "";
        while(endIndex <= firstStr.length()) {
            String str = firstStr.substring(0, endIndex);
            if (Arrays.stream(rStrs).allMatch(s -> s.startsWith(str))) {
                resultStr = str;
                endIndex = endIndex + 1;
            } else {
                break;
            }
        }
        return resultStr;
    }

    public static void main(String[] args) {
        LongestCommonPrefix longestCommonPrefix = new LongestCommonPrefix();
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"flower","flower","flower", "flower"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"flower","flow","flight"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"dog","racecar","car"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"cir", "car"}));
        System.out.println(longestCommonPrefix.longestCommonPrefix(new String[] {"c", "acc", "ccc"}));
    }
}
