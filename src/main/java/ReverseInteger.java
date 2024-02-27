/**
 * Given a signed 32-bit integer x, return x with its digits reversed.
 * If reversing x causes the value to go outside the signed 32-bit integer
 * range [-231, 231 - 1], then return 0.
 *
 * Example 1:
 *
 * Input: x = 123
 * Output: 321
 * Example 2:
 *
 * Input: x = -123
 * Output: -321
 * Example 3:
 *
 * Input: x = 120
 * Output: 21
 *
 * -231 <= x <= 231 - 1
 */

public class ReverseInteger {
    public int reverse(int x) {
        String xStr = String.valueOf(x);
        xStr = xStr.startsWith("-") ? xStr.substring(1) : xStr;
        long result = Long.parseLong(new StringBuilder(xStr).reverse().toString());
        result = x < 0 ? -1 * result : result;
        if (result < Integer.MIN_VALUE || result > Integer.MAX_VALUE) {
            return 0;
        }
        int resultInt = (int) result;
        return resultInt;
    }

    public static void main(String[] args) {
        ReverseInteger reverseInteger = new ReverseInteger();
        for (int i : new int[]{1534236469, -123, 120, -2147483648}) {
            System.out.println(reverseInteger.reverse(i));
        }
    }
}
