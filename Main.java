// https://github.com/netology-code/jd-homeworks/blob/master/multithreading/task2/README.md

import java.util.List;
import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        System.out.println("Создаю потоки");
        Callable<String> myCallable1 = new MyCallable("поток 1", 18);
        Callable<String> myCallable2 = new MyCallable("поток 2", 19);
        Callable<String> myCallable3 = new MyCallable("поток 3", 20);
        Callable<String> myCallable4 = new MyCallable("поток 4", 21);
//        final ExecutorService threadPool1 = Executors.newFixedThreadPool(4);
        final ExecutorService threadPool1 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        final Future<String> result1 = threadPool1.submit(myCallable1);
        final Future<String> result2 = threadPool1.submit(myCallable2);
        final Future<String> result3 = threadPool1.submit(myCallable3);
        final Future<String> result4 = threadPool1.submit(myCallable4);
        System.out.println(result1.get());
        System.out.println(result2.get());
        System.out.println(result3.get());
        System.out.println(result4.get());
        threadPool1.shutdown();

        String result = null;
//        final ExecutorService threadPool2 = Executors.newFixedThreadPool(4);
        final ExecutorService threadPool2 = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
        final List<Callable<String>> tasks = List.of(myCallable1, myCallable2, myCallable3, myCallable4);
        try {
            result = threadPool2.invokeAny(tasks);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(result);
        threadPool2.shutdown();
    }
}
