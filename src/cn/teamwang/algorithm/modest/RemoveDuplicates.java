package cn.teamwang.algorithm.modest;

/**
 * todo
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class RemoveDuplicates {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3};
        int[] nums2 = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝。方法若修改了值，原数组的值也会被修改。

//        System.out.println(test(nums1));
        System.out.println(test(nums2));
    }

    public static int test(int[] nums) {
        if (nums == null || nums.length == 1) {
            return nums.length;
        }

        int i = 0, j = 1;
        while (j < nums.length) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i + 1;
    }
}
