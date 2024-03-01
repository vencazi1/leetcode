import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Every close bracket has a corresponding open bracket of the same type.
 */


public class ValidParanthesis {
    static Map<String, String> map = new HashMap<>();
    static {
        map.put(")", "(");
        map.put("}", "{");
        map.put("]", "[");
    }

    public boolean isValid(String s) {
        int ind = 0;
        Stack<String> stack = new Stack<>();
        String[] strArray = s.trim().split("");
        while (ind < strArray.length) {
            String value = strArray[ind];
            switch (value) {
                case "(":
                case "{":
                case "[":
                    stack.push(value);
                    break;
                default:
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!stack.pop().equals(map.get(value))) {
                        return false;
                    }
            }
            ind = ind + 1;
        }
       return !stack.isEmpty() ? false : true;
    }

    public static void main(String[] args) {
        ValidParanthesis validParanthesis = new ValidParanthesis();
        System.out.println(validParanthesis.isValid("]"));
        System.out.println(validParanthesis.isValid("()"));
        System.out.println(validParanthesis.isValid("()[]{}"));
        System.out.println(validParanthesis.isValid("(]"));
    }
}
