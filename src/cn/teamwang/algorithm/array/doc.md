数组的工具类：Arrays
List集合的工具类：Collections

二维数组排序：
```java
int [][]a = new int [5][2];

Arrays.sort(a, new Comparator<int[]>() {
@Override
public int compare(int[] o1, int[] o2) {
if (o1[0]==o2[0]) return o1[1]-o2[1];
return o1[0]-o2[0];
}
});
```
