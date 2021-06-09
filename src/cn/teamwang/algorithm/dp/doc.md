## DP 概念

动态规划（Dynamic Programming，DP）是运筹学的一个分支，是求解**决策过程最优化**的过程。

以下参考自文章：[六大算法之三：动态规划](https://blog.csdn.net/zw6161080123/article/details/80639932)

https://baike.baidu.com/item/状态转移方程/7359039?fr=aladdin

对于Ai+1，只需要它的**上一个状态**Ai即可完成整个推理过程（而不需要更前序的状态）。我们将这一模型称为马尔科夫模型。对应的推理过程叫做“贪心法”。
如果从A0添加一个元素，得到A1的变化过程。即A0->A1; 进而有A1->A2; A2->A3; …… ; Ai->Ai+1. 这就是严格的归纳推理，也就是我们经常使用的数学归纳法；

对于Ai+1，需要**前面的所有前序状态**才能完成推理过程。我们将这一模型称为高阶马尔科夫模型。对应的推理过程叫做“动态规划法”。
{A1->A2}; {A1, A2->A3}; {A1,A2,A3->A4};……; {A1,A2,...,Ai}->Ai+1. 这种方式就是第二数学归纳法。

## 使用场景

返回值ans/res是int类型(int dp[i][j])

- 线性数据的**最优解**/**最大价值**(求最大值时，把默认的dp=0也放进来比较，即dp[i]= max(dp[i], ...))
- 最短路径，最长公共子序列，最大价值，多少种方案

此处的最优解包括常见的最大、最小值等。

## 典型例题

> DP解题思路：
> Step 1: 确定dp是几维数组。通过题目中可遍历的东西来看。dp[i][j]为...的ans/res(此处不是/不一定那个最优解)。
> Step 2: 求初始值。从i=0, j=0...入手。
> Step 3: 求状态转移方程。找到一个可转移过来的状态。可先从i-1, j-1, j(j<i)...入手，不行再用变量替代(例如，当dp[i]为一维数组，状态转移方程也可以引入变量j)。
> 
> 注意：
> 考虑到状态转移方程只和i-1(即上一行)有关，故可以省略（因为1是常数，当同时出现i-1,i+1或i-j时，则不能省略）。
> 状态转移方程的不一定是从上一个状态(i-1)转移来的。
> dp[i] = max(dp[j]) + 1 = max(dp[i], dp[j] + 1), j < i。并且因为方程用到了min/max + dp[i]自身，所以要对dp[i]赋值(不可能到达最大或最小值)
> **跳过初始化**：开辟+1的空间。[RobII](./medium/RobII.java) [MaxValue](./medium/MaxValue.java)


1. [最长公共子序列](./LongestCommonSubsequence.java)
2. [剪绳子I](./CuttingRope.java)
3. [找出第 K 大的异或坐标值](../daily/leetcode/KthLargestValue.java) & [最小的路径和](../daily/nowcoder/MinPathSum.java)

## 背包问题

0-1背包：[零钱兑换](./medium/CoinChange.java): 先遍历金额。状态转移方程 dp[i] = min(dp[i-coins[x]]) + 1 = min(dp[i], dp[i-coins[x]]+1) // 因为是最少硬币个数，所以用一个最大面值的硬币来凑
完全背包：[硬币](./medium/WaysToChange.java): 先遍历硬币面值。状态转移方程 dp[i] = dp[i] + dp[i-coins[x]]