import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)
 *
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 *
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string s, int numRows);
 *
 * Example 1:
 *
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 *
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * Example 3:
 *
 * Input: s = "A", numRows = 1
 * Output: "A"
 *
 * Constraints:
 *
 * 1 <= s.length <= 1000
 */

public class ZigzagConvertion {
    public String convert(String s, int numRows) {
        if (numRows > s.length() || numRows == 1) {
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for(int ind = 0; ind < numRows; ind++) {
            stringBuilders[ind] = new StringBuilder();
        }
        int ind = 0;
        int index = 0;
        String[] strArray = s.split("");
        boolean incrementFlag = true;
        while (index < strArray.length) {
            if (ind == 0) {
                incrementFlag = true;
            } else if (ind == numRows - 1) {
                incrementFlag = false;
            }
            stringBuilders[ind].append(strArray[index]);
            if (incrementFlag) {
                ind = ind + 1;
            } else {
                ind = ind - 1;
            }
            index = index + 1;
        }
        return Arrays.stream(stringBuilders).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        ZigzagConvertion zigzagConvertion = new ZigzagConvertion();
        System.out.println(zigzagConvertion.convert("PAYPALISHIRING", 3));
        System.out.println(zigzagConvertion.convert("PAYPALISHIRING", 4));
        System.out.println(zigzagConvertion.convert("ABC", 2));
        System.out.println(zigzagConvertion.convert("AB", 1));
    }
}
