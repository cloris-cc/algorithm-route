双指针包括两类：
1. 快慢指针。主要解决链表中的问题，比如典型的判定链表中是否包含环
2. 左右指针。主要解决数组（或者字符串）中的问题，比如二分查找。

## 例题

### 链表：快慢指针

#### [判定链表中是否含有环](./HasCycle.java):

单链表的特点是每个节点只知道下一个节点，所以一个指针的话无法判断链表中是否含有环的。

但是如果链表中含有环，那么这个指针就会陷入死循环，因为环形数组中没有 null 指针作为尾部节点。

经典解法就是用两个指针，一个每次前进两步，一个每次前进一步。如果不含有环，跑得快的那个指针最终会遇到 null，说明链表不含环；如果含有环，快指针最终会超慢指针**一圈**，和慢指针(**在环内**)相遇，说明链表含有环。

```java
fast = fast.next.next; // 防止[null].next
slow = slow.next;
```

#### [判断链表是否有环，若有，则返回这个环的起始位置](./DetectCycle.java)

当快慢指针相遇时，让其中任一个指针重新指向头节点，然后让它俩以相同速度前进，再次相遇时所在的节点位置就是环开始的位置。[具体运算过程](https://www.cnblogs.com/kyoner/p/11087755.html)


#### [链表的中间结点](./MiddleNode.java)

寻找链表中点的一个重要作用是对链表进行归并排序。

回想数组的归并排序：求中点索引递归地把数组二分，最后合并两个有序数组。对于链表，合并两个有序链表是很简单的，难点就在于二分。

但是现在你学会了找到链表的中点，就能实现链表的二分了。关于归并排序的具体内容本文就不具体展开了。

### 数组：左右指针

> 应用场景：和二分查找一样，也是适用于**有序**数组。(不一定是有序了，看[盛最多水的容器](../daily/top100/MaxArea.java))

二分查找就是双指针的一种应用场景，不做介绍。

#### [两数之和](./TwoSum.java)

#### [反转数组](./ReverseNums.java)

#### [滑动窗口](../slidingwindow)

