应用场景：**连续子串**。

滑动窗口的while循环时间复杂度不是O(n)，而是更小的O(logn)

滑动窗口虽然本质也是双指针，但是不一定需要数组**有序**。然后边界条件各不相同，视具体情况而定。

滑动窗口的规则：
1. **同一时刻，只能(向右)滑动 L 或 R**。即滑动右边界的时候左边界固定。
2. L,R 只能向右滑动。
3. 该算法仅适用于数组为正整数的情况，若有负数，可考虑用**前缀和**。
   
**通常情况下，r++位于最外层，l++位于内部循环。**

eg: 

[和大于等于 target 的最短子数组](../daily/offerII/medium/MinSubArrayLen.java)

[乘积小于 K 的子数组](../daily/offerII/medium/NumSubarrayProductLessThanK.java)

