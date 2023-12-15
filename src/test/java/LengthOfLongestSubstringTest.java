import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LengthOfLongestSubstringTest {

    LengthOfLongestSubstring lengthOfLongestSubstring;

    @BeforeAll
    public static void setup() {
        System.out.println("Before All LengthOfLongestSubstring Test");
    }

    @BeforeEach
    public void beforeEach() {
        System.out.println("Before Each LengthOfLongestSubstring Test");
        lengthOfLongestSubstring = new LengthOfLongestSubstring();
    }

    @Test
    public void testLengthOfLongestSubstring1() {
        int length = lengthOfLongestSubstring.lengthOfLongestSubstring("bbbbb");
        Assertions.assertEquals(1, length);
    }

    @Test
    public void testLengthOfLongestSubstring2() {
        int length = lengthOfLongestSubstring.lengthOfLongestSubstring("abcabcbb");
        Assertions.assertEquals(3, length);
    }

    @Test
    public void testLengthOfLongestSubstring3() {
        int length = lengthOfLongestSubstring.lengthOfLongestSubstring("pwwkew");
        Assertions.assertEquals(3, length);
    }
}
