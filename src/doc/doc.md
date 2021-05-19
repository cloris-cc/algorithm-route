数据结构特性：
队列：先进先出
栈：先进后出
链表 & 数组：链表是链式存储结构，数组是顺序存储结构。数组**查询修改**快(通过下标查找O(1)，无需遍历O(N))，链表**插入删除**快。

穷举数组的优化方法：考虑**哈希表**。时间复杂度从O(n^2)变成O(nlogn),其中`map.containsKey()`的时间复杂度最好是O(1)，最坏是O(logn)。
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

小学数学：
最大公约数求法：辗转相除法。
如求319，377的最大公约数。377mod319=58, 319mod58=29, 58mod29=0. 故答案是29。   
2. 程序方法：公式法。
a * b = 最大公约数 * 最小公倍数
