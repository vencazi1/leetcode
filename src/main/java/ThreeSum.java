import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]]
 * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
 *
 * Notice that the solution set must not contain duplicate triplets.
 *
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Explanation:
 * nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
 * nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
 * nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
 * The distinct triplets are [-1,0,1] and [-1,-1,2].
 * Notice that the order of the output and the order of the triplets does not matter.
 * Example 2:
 *
 * Input: nums = [0,1,1]
 * Output: []
 * Explanation: The only possible triplet does not sum up to 0.
 * Example 3:
 *
 * Input: nums = [0,0,0]
 * Output: [[0,0,0]]
 * Explanation: The only possible triplet sums up to 0.
 */

public class ThreeSum {

    public List<List<Integer>> twoSum(int[] nums, int kIndex) {
        List<List<Integer>> list = new ArrayList<>();
        int startIndex = kIndex + 1;
        int endIndex = nums.length-1;
        while(startIndex < endIndex) {
            if (startIndex > kIndex + 1 && nums[startIndex] == nums[startIndex-1] &&
                    endIndex < nums.length-1 && nums[endIndex] == nums[endIndex+1]) {
                /**
                 * The value of kIndex, nums[startIndex] and nums[endIndex] are the same as
                 * what was processed in the previous iteration. This can be ignored there by gaining
                 * in performance.
                 */
                startIndex++;
                endIndex--;
                continue;
            }
            int sum = nums[kIndex] + nums[startIndex] + nums[endIndex];
            if (sum == 0) {
                list.add(Arrays.asList(nums[kIndex], nums[startIndex], nums[endIndex]));
                startIndex++;
                endIndex--;
            } else if (sum < 0) {
                startIndex++;
            } else {
                endIndex--;
            }
        }
        return list;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        int kIndex = 0;
        while (kIndex < nums.length-2) {
            if (nums[kIndex] > 0) {
                break;
            }
            if (kIndex > 0 && nums[kIndex] == nums[kIndex-1]) {
                /**
                 * The previous and current value of k are the same.
                 * So can be ignored.
                 */
                kIndex++;
                continue;
            }
            List<List<Integer>> tempSums = twoSum(nums, kIndex);
            if (tempSums != null) {
                list.addAll(tempSums);
            }
            kIndex++;
        }
        return list;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[] {-4,-2,1,-5,-4,-4,4,-2,0,4,0,-2,3,1,-5,0}));
        System.out.println(threeSum.threeSum(new int[] {-1,0,1,2,-1,-4}));
        System.out.println(threeSum.threeSum(new int[] {0,1,1}));
        System.out.println(threeSum.threeSum(new int[] {0,0,0}));
        System.out.println(threeSum.threeSum(new int[] {-1,0,0,1}));
    }
}
