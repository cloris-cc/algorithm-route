数据结构特性：
队列：先进先出
栈：先进后出
链表 & 数组：链表是链式存储结构，数组是顺序存储结构。数组**查询修改**快(通过下标查找O(1)，无需遍历O(N))，链表**插入删除**快。

穷举数组的优化方法：考虑哈希表
```java
    /**
     * O(n)
     * 因为要查找的目标值也在数组内，所以可以通过哈希表来保存、获取目标值，而不是二次遍历数组。
     * 总结：穷举数组+答案唯一时，可考虑哈希表。
     */
    public static int[] twoSum2_optimized(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return new int[0];
    }
```