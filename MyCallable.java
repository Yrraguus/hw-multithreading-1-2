import java.util.concurrent.Callable;

public class MyCallable implements Callable<String> {
    public String threadName;
    public int iterations;
    public int messageCounter;

    public MyCallable(String threadName, int iterations) {
        this.threadName = threadName;
        this.iterations = iterations;
    }

    @Override
    public String call() throws Exception {
        Thread.currentThread().setName(threadName);
        for (int i = 0; i < iterations; i++) {
            Thread.sleep(50);
            System.out.println("Я " + Thread.currentThread().getName() + ". Всем привет!");
            messageCounter++;
        }
        return this.threadName + ": количество выведенных соощений: " + messageCounter;
    }
}
