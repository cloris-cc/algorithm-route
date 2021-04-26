package cn.teamwang.algorithm.temp;

import java.util.Random;
import java.util.concurrent.Callable;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class OrderTaskAdv implements Callable<String> {
    @Override
    public String call() {
        return "hello world";
    }
}
