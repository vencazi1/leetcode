import java.util.Arrays;

/**
 * Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is
 * closest to target.
 *
 * Return the sum of the three integers.
 *
 * You may assume that each input would have exactly one solution.
 *
 *
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * Example 2:
 *
 * Input: nums = [0,0,0], target = 1
 * Output: 0
 * Explanation: The sum that is closest to the target is 0. (0 + 0 + 0 = 0).
 */

public class ThreeSumClosest {

    int getSum(int[] nums, int kIndex, int target) {
        /**
         * Sorted array.
         * Iterate nums starting from kIndex + 1 and find the number close to the target
         */
        int startIndex = kIndex + 1;
        int endIndex = nums.length-1;
        int minDiff = Integer.MAX_VALUE;
        int retValue = minDiff;
        while(startIndex < endIndex) {
            if (startIndex > kIndex + 1 && nums[startIndex] == nums[startIndex-1]
                    && endIndex < nums.length-1 && nums[endIndex] == nums[endIndex+1]) {
                startIndex++;
                endIndex--;
                continue;
            }
            int sum = nums[kIndex] + nums[startIndex] + nums[endIndex];
            int tempDiff = Math.abs(sum - target);
            if (tempDiff < minDiff) {
                minDiff = tempDiff;
                retValue = sum;
            }
            if (sum < target) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
        return retValue;
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int kIndex = 0;
        int endIndex = nums.length-2;
        int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        while(kIndex < endIndex) {
            int sum = getSum(nums, kIndex, target);
            int diff = Math.abs(target - sum);
            if (diff < minDiff) {
                minDiff = diff;
                minSum = sum;
            }
            kIndex++;
        }
        return minSum;
    }

    public static void main(String[] args) {
        ThreeSumClosest threeSum = new ThreeSumClosest();
        // 0,3,97,102,200
        System.out.println(threeSum.threeSumClosest(new int[] {0,3,97,102,200}, 300));
        System.out.println(threeSum.threeSumClosest(new int[] {-1,2,1,-4}, 1));
        System.out.println(threeSum.threeSumClosest(new int[] {0,0,0}, 1));
    }
}
