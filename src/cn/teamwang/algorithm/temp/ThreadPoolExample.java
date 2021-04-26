package cn.teamwang.algorithm.temp;

import java.util.concurrent.*;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class ThreadPoolExample {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) { // foreach concrete business
//            threadPool.execute(new OrderTask(i + ""));
            Future<String> submit = threadPool.submit(new OrderTaskAdv());
            FutureTask<String> task = new FutureTask<>(new OrderTaskAdv());

            System.out.println(submit.get());
        }
        System.out.println("10 tasks have been dispatched successfully.");
        threadPool.shutdown();
    }
}
