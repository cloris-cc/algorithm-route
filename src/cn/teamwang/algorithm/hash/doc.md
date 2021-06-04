利用哈希表O(nlogn)替代穷举法O(n^2)

穷举数组的优化方法：考虑**哈希表**。

其中`map.containsKey()`的时间复杂度最好是O(1)，最坏是O(logn)。`list.contains()`的时间复杂度为O(n)

解题模板：

1. Map<pre_res, index>

2. for循环内有一个cur_res

另外，要注意map的res有覆盖的情况。
