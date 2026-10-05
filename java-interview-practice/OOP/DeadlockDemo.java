public class DeadlockDemo {
    static final Object lock1 = new Object();
    static final Object lock2 = new Object();

    public static void main(String[] args) {
        new Thread(() -> {
            synchronized (lock1) {
                pause(100);
                synchronized (lock2) {
                    System.out.println("A done");
                }
            }
        }, "thread-A").start();

        new Thread(() -> {
            synchronized (lock2) {          // opposite order — this is the bug
                pause(100);
                synchronized (lock1) {
                    System.out.println("B done");
                }
            }
        }, "thread-B").start();
    }

    static void pause(long ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}