
/*

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;


public class MainConcurrency2 {
    public static final int THREADS_NUMBER = 10000;

    private final AtomicInteger atomicCounter = new AtomicInteger();


//    private static final Lock lock = new ReentrantLock();
    private static final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    private static final Lock WRITE_LOCK = reentrantReadWriteLock.writeLock();
    private static final Lock READ_LOCK = reentrantReadWriteLock.readLock();

    private static final ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<SimpleDateFormat>() {
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat();
        }
    };

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());


        final MainConcurrency2 mainConcurrency2 = new MainConcurrency2();
        CountDownLatch latch = new CountDownLatch(THREADS_NUMBER);
        ExecutorService executorService = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());
//        CompletionService completionService = new ExecutorCompletionService(executorService);


        for (int i = 0; i < THREADS_NUMBER; i++) {
            Future<Integer> future = executorService.submit(() ->
            {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency2.inc();
                    System.out.println(threadLocal.get().format(new Date()));
                }
                latch.countDown();
                return 5;
            });

            latch.await(10, TimeUnit.SECONDS);
            executorService.shutdown();
//        System.out.println(mainConcurrency.counter);

        }
        System.out.println(mainConcurrency2.atomicCounter.get());

    }



    private void inc() {

//        WRITE_LOCK.lock();
//        try {
        atomicCounter.incrementAndGet();
//            counter++;
//        } finally {
//            WRITE_LOCK.unlock();
//        }

//        }
    }
}
*/