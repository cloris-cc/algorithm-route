二分查找：查找**有序**数组

若有**重复元素**，要返回最左或最右边的那个则需要做**加减1**操作：

```java
    // 返回最左
    private static int binarySearch_left(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                // to left
                r--;
            }
        }
        return l;
```

```java
    // 返回最右
    private static int binarySearch_right(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] < target) {
                l = mid + 1;
            } else if (nums[mid] > target) {
                r = mid - 1;
            } else {
                // to right
                l++;
            }
        }
        return r;
```

