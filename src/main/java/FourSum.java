import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Given an array nums of n integers, return an array of all the unique quadruplets
 * [nums[a], nums[b], nums[c], nums[d]] such that:
 *
 * 0 <= a, b, c, d < n
 * a, b, c, and d are distinct.
 * nums[a] + nums[b] + nums[c] + nums[d] == target
 * You may return the answer in any order.
 *
 * Example 1:
 *
 * Input: nums = [1,0,-1,0,-2,2], target = 0
 * Output: [[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
 * Example 2:
 *
 * Input: nums = [2,2,2,2,2], target = 8
 * Output: [[2,2,2,2]]
 *
 * Constraints:
 *
 * 1 <= nums.length <= 200
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 */

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();

        for (int outter=0; outter<nums.length-3; outter++) {
            for (int inner=outter+1; inner<nums.length-2; inner++) {
                int num3Index = inner + 1;
                int num4Index = nums.length-1;
                if (outter > 0 && nums[outter] == nums[outter - 1]
                        || inner > outter + 1 && nums[inner] == nums[inner-1]) {
                    continue;
                }
                while (num3Index < num4Index) {
                    if (num3Index > inner + 1 && nums[num3Index] == nums[num3Index-1]
                            && num4Index < nums.length-1 && nums[num4Index] == nums[num4Index+1]) {
                        num3Index++;
                        num4Index--;
                        continue;
                    }
                    /**
                     * There are test cases where in the computed sum may exceed the max allowable range for a 32 bit
                     * integer. Convert to long to overcome this.
                     */

                    long sum = (long) nums[outter] + (long) nums[inner] + (long) nums[num3Index] + (long) nums[num4Index];
                    if (sum == target) {
                        result.add(Arrays.asList(nums[outter], nums[inner], nums[num3Index], nums[num4Index]));
                        num3Index++;
                        num4Index--;
                    } else if (sum < target) {
                        num3Index++;
                    } else {
                        num4Index--;
                    }
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        FourSum fourSum = new FourSum();
        System.out.println(fourSum.fourSum(new int[] {1000000000,1000000000,1000000000,1000000000}, -294967296));
        System.out.println(fourSum.fourSum(new int[] {1,0,-1,0,-2,2}, 0));
        System.out.println(fourSum.fourSum(new int[] {-2,-1,-1,1,1,2,2}, 0));
        System.out.println(fourSum.fourSum(new int[] {2,2,2,2,2}, 8));

    }
}
