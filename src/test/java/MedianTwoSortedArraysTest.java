import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MedianTwoSortedArraysTest {
    MedianTwoSortedArrays medianTwoSortedArrays = new MedianTwoSortedArrays();

    @BeforeAll
    public static void setup() {
    }

    @Test
    public void happyPathEvenLength() {
        double result = medianTwoSortedArrays.findMedianSortedArrays(new int[]{1,2}, new int[] {3,4});
        Assertions.assertEquals(2.5, result);
    }

    @Test
    public void happyPathOddLength() {
        double result = medianTwoSortedArrays.findMedianSortedArrays(new int[]{1,2}, new int[] {3});
        Assertions.assertEquals(2, result);
    }

    @Test
    public void num1EmptyTest() {
        double result = medianTwoSortedArrays.findMedianSortedArrays(new int[0], new int[] {3});
        Assertions.assertEquals(3.0, result);
    }

    @Test
    public void num2EmptyTest() {
        double result = medianTwoSortedArrays.findMedianSortedArrays(new int[] {1,3}, new int[0]);
        Assertions.assertEquals(2.0, result);
    }

    @Test
    public void bothEmptyTest() {
        double result = medianTwoSortedArrays.findMedianSortedArrays(new int[0], new int[0]);
        Assertions.assertEquals(-1.0, result);
    }
}
