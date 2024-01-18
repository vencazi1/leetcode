public class MedianTwoSortedArrays {

    private int[] merge(int[] nums1, int[] nums2) {
        int len1 = nums1.length;
        int len2 = nums2.length;
        int[] nums3 = new int[(nums1.length + nums2.length)];
        int ind1 = 0;
        int ind2 = 0;
        int ind3 = 0;
        if (len1 == 0 && len2 == 0) {
            return nums3;
        }
        if (len1 == 0) {
            return nums2;
        } else if (len2 == 0) {
            return nums1;
        }
        while (true) {
            if (ind1 >= nums1.length || ind2 >= nums2.length) {
                break;
            }
            if (nums1[ind1] < nums2[ind2]) {
                nums3[ind3] = nums1[ind1];
                ind1++;
            } else {
                nums3[ind3] = nums2[ind2];
                ind2++;
            }
            ind3++;
        }
        if (ind1 < nums1.length) {
            System.arraycopy(nums1, ind1, nums3, ind3, nums1.length - ind1);
        } else if (ind2 < nums2.length) {
            System.arraycopy(nums2, ind2, nums3, ind3, nums2.length - ind2);
        }
        return nums3;
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums3 = merge(nums1, nums2);
        int len3 = nums3.length;
        if (len3 == 0) {
            return -1.0;
        }
        int mid = len3/2;
        return len3 % 2 == 0 ? (double) (nums3[mid-1] + nums3[mid])/2 : nums3[mid];
    }

    public static void main(String[] args) {
        MedianTwoSortedArrays medianTwoSortedArrays = new MedianTwoSortedArrays();
        int[] num1 = {};
        int[] num2 = {2, 3};
        System.out.println(medianTwoSortedArrays.findMedianSortedArrays(num1, num2));
    }
}
