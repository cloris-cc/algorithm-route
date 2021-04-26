package cn.teamwang.algorithm.temp;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class TestMain {

    public static void main(String[] args) {
        Laptop laptop1 = new Laptop("razer15精英版", 12999);
        Laptop laptop2 = new Laptop("lenovoR9000k", 10999);
        Laptop laptop3 = new Laptop("razer15精英版", 12999);

        System.out.println(laptop1.equals(laptop2)); // false
        System.out.println(laptop1.equals(laptop3)); // true

        ExecutorService executorService = Executors.newFixedThreadPool(3);
    }
}
