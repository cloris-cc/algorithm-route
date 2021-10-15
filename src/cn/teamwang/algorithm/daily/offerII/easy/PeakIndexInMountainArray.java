package cn.teamwang.algorithm.daily.offerII.easy;

/**
 * 剑指 Offer II 069. 山峰数组的顶部
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class PeakIndexInMountainArray {
    public static void main(String[] args) {
        int[] arr1 = {0, 1, 0};
        int[] arr2 = {1, 3, 5, 4, 2};
        int[] arr3 = {0, 10, 5, 2};
        int[] arr4 = {3, 4, 5, 1};
        int[] arr5 = {24, 69, 100, 99, 79, 78, 67, 36, 26, 19};
        int[] arr6 = {3, 5, 3, 2, 0};
//        System.out.println(peakIndexInMountainArray(arr1));
//        System.out.println(peakIndexInMountainArray(arr2));
//        System.out.println(peakIndexInMountainArray(arr3));
//        System.out.println(peakIndexInMountainArray(arr4));
//        System.out.println(peakIndexInMountainArray(arr5));
//        System.out.println(peakIndexInMountainArray(arr6));
//        System.out.println("=======");
//        System.out.println(peakIndexInMountainArray1(arr1));
//        System.out.println(peakIndexInMountainArray1(arr2));
//        System.out.println(peakIndexInMountainArray1(arr3));
//        System.out.println(peakIndexInMountainArray1(arr4));
        System.out.println(peakIndexInMountainArray1(arr5));
        System.out.println(peakIndexInMountainArray1(arr6));
        System.out.println(peakIndexInMountainArray2(arr5));
        System.out.println(peakIndexInMountainArray2(arr6));
    }

    // O(n)
    public static int peakIndexInMountainArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return i - 1;
            }
        }
        return -1;
    }

    // O(logN)
    public static int peakIndexInMountainArray1(int[] arr) {
        // 找到 arr[i-1] < arr[i] > arr[i+1] 。
        // 若 arr[i-1] > arr[i]：往左
        // 若 arr[i] < arr[i+1]: 往右
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (mid != 0 && arr[mid] < arr[mid - 1]) {
                r = mid - 1;
            } else if (arr[mid] < arr[mid + 1]) {
                l = mid + 1;
            } else {
                if (arr[mid] > arr[mid - 1] && arr[mid] > arr[mid + 1]) {
                    return mid;
                }
            }
        }
        return -1;
    }

    public static int peakIndexInMountainArray2(int[] arr) {
        int l = 1, r = arr.length - 2;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] > arr[mid - 1]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return r;
    }

}
