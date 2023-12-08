import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public Map<Integer, int[]> generateMap(int[] nums) {
        Map<Integer, int[]> map = new HashMap<>();
        int index = 0;
        for(int num : nums) {
            int[] indexArray = map.get(num);
            if (indexArray == null) {
                indexArray = new int[2];
                indexArray[0] = index;
            } else {
                indexArray[1] = index;
            }
            map.put(num, indexArray);
            index++;
        }
        return map;
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, int[]> map = generateMap(nums);
        for (int num : nums) {
            int diff = target - num;
            int[] indexArray = map.get(diff);
            if (indexArray != null) {
                if (num == diff) {
                    if (indexArray[1] != 0) {
                        return new int[] {indexArray[0], indexArray[1]};
                    }
                } else { // num != diff
                    return new int[] {map.get(num)[0], indexArray[0]};
                }
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        int[] indexArray = twoSum.twoSum(new int[]{3,3}, 6);
        Arrays.stream(indexArray).forEach(System.out::println);
    }

}
