package for_test;

import java.util.concurrent.TimeUnit;

/**
 * Created by se4 on 16.08.16.
 */
public class Main {

    public static void main(String[] args) throws InterruptedException {
//пример создания потоко
        Thread[] threads = new Thread[1];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(new Cc());
        }
        startThreads(threads);


    }
    private static void startThreads(Thread[] threads) {
        for (Thread t : threads)
            t.start();
    }
///////

}

