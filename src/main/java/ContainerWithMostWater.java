/**
 * You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints of
 * the ith line are (i, 0) and (i, height[i]).
 *
 * Find two lines that together with the x-axis form a container, such that the container contains the most water.
 *
 * Return the maximum amount of water a container can store.
 * Example 1:
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
 * In this case, the max area of water (blue section) the container can contain is 49.
 *
 * Example 2:
 * Input: height = [1,1]
 * Output: 1
 *
 * Example 3:
 * Input: height = [1,2,1]
 * Output: 2 [1 2 1] because additional 1 is from 0 to 1 on x-axis
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 105
 * 0 <= height[i] <= 104
 */

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int frontIndex = 0;
        int backIndex = height.length-1;
        int maximumArea = 0;
        int tempArea = 0;
        while(frontIndex < backIndex) {
            if (height[frontIndex] < height[backIndex]) {
                tempArea = height[frontIndex] * (backIndex - frontIndex);
                frontIndex++;
            } else if (height[frontIndex] > height[backIndex]){
                tempArea = height[backIndex] * (backIndex - frontIndex);
                backIndex--;
            } else { // both height[frontIndex] == height[backIndex]
                tempArea = height[frontIndex] * (backIndex - frontIndex);
                frontIndex++;
                backIndex--;
            }
            maximumArea = Math.max(maximumArea, tempArea);
        }
        return maximumArea;
    }

    public static void main(String[] args) {
        ContainerWithMostWater containerWithMostWater = new ContainerWithMostWater();
        System.out.println(containerWithMostWater.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
        System.out.println(containerWithMostWater.maxArea(new int[]{1,1}));
        System.out.println(containerWithMostWater.maxArea(new int[]{1,2,1}));
    }
}
