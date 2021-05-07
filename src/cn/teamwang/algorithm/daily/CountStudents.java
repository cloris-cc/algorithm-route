package cn.teamwang.algorithm.daily;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 1700. 无法吃午餐的学生数量
 *
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class CountStudents {
    public static void main(String[] args) {
        int[] stu1 = {1, 1, 0, 0};
        int[] san1 = {0, 1, 0, 1};
        int[] stu2 = {1, 1, 1, 0, 0, 1};
        int[] san2 = {1, 0, 0, 0, 1, 1};


        System.out.println(countStudents(stu1, san1));
        System.out.println(countStudents(stu2, san2));
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        for (int student : students) {
            q1.offer(student);
        }
        for (int sandwich : sandwiches) {
            q2.offer(sandwich);
        }

        // q1所有元素都不等于q2.peek
        while (!q1.isEmpty() && q1.contains(q2.peek())) {
            if (q1.peek().equals(q2.peek())) {
                q1.poll();
                q2.poll();
            } else {
                // 放入队尾
                q1.offer(q1.poll());
            }
        }
        return q1.size();

    }

}
