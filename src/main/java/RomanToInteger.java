import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:
 *
 * Input: s = "III"
 * Output: 3
 * Explanation: III = 3.
 * Example 2:
 *
 * Input: s = "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 3:
 *
 * Input: s = "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */

public class RomanToInteger {

    static final Map<Character, Integer> map = new HashMap<>();
    static {
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int romanToInt(String s) {
        int ind = s.length()-1;
        char prevChar = s.charAt(ind);
        ind = ind - 1;
        int runningTotal = map.get(prevChar);
        while(ind >= 0) {
            char currentChar = s.charAt(ind);
            if (map.get(prevChar) > map.get(currentChar)) {
                /**
                 * prev - I and current - V
                 * VI ie bigger roman appears ahead of a smaller Roman
                 * do the math ie runningTotal = runningTotal - map.get(current)
                 */
                runningTotal = runningTotal - map.get(currentChar);
            } else {
                /**
                 * prev - V and current - I
                 * IV ie a smaller Roman appears ahead of a bigger Roman
                 * do the math ie runningTotal = runningTotal + map.get(current)
                 */
                runningTotal = runningTotal + map.get(currentChar);
            }
            prevChar = currentChar;
            ind = ind - 1;
        }
        return runningTotal;
    }

    public static void main(String[] args) {
        RomanToInteger romanToInteger = new RomanToInteger();
        System.out.println(romanToInteger.romanToInt("LVIII"));
        System.out.println(romanToInteger.romanToInt("III"));
        System.out.println(romanToInteger.romanToInt("MCMXCIV"));
    }
}
