[百度百科 - 排序算法比较](https://baike.baidu.com/item/冒泡排序/4602306?fr=aladdin#5)

![](http://uploadfiles.nowcoder.net/images/20150905/562077_1441438125469_C3CB91D00CEB6F14114E695667CBE3B1)

### 稳定性

> 稳定的：插入冒泡、归并基数

不稳定：重复的数字经过排序后，和原来的相对顺序可能不一样。

对于`Arrays.sort()`使用的是**快排**,所以是不稳定的。 

对于`Collections.sort()`使用的是**归并排序**,是稳定的。