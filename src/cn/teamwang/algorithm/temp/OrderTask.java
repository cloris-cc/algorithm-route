package cn.teamwang.algorithm.temp;

/**
 * @author <a href="mailto:clorisforcoding@gmail.com">Jacky Fang</a>
 */
public class OrderTask implements Runnable {
    private final String orderId;

    public OrderTask(String orderId) {
        this.orderId = orderId;
    }

    @Override
    public void run() {
        System.out.println("starting processing order: [" + orderId + "]");

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("finished processing order: [" + orderId + "]");
    }
}
