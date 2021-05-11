package cn.teamwang.algorithm.daily.nowcoder;

/**
 * 请实现有重复数字的升序数组的二分查找
 * https://www.nowcoder.com/practice/4f470d1d3b734f8aaf2afb014185b395?tpId=188&tqId=38290&rp=1&ru=%2Factivity%2Foj&qru=%2Fta%2Fjob-code-high-week%2Fquestion-ranking&tab=answerKey
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class Search {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 4, 4, 5};
        int[] nums2 = {1, 1, 1, 1, 1};
        System.out.println(search1(nums1, 4));
        System.out.println(search1(nums1, 3));
        System.out.println(search1(nums2, 1));
    }

    public static int search1(int[] nums, int target) {
        int l = 0, r = nums.length - 1, index = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        // 向左查找，直到不等于target或index为0为止。
        while (index > 0 && nums[index - 1] == target) {
            index--;
        }
        return index;
    }

    public static int search2(int[] nums, int target) {
        int l = 0, r = nums.length - 1, index = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                index = mid;
                // 继续向左查找
                r = mid - 1;
            }
        }
        return index;
    }
}
