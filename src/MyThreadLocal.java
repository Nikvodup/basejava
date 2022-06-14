
/*
Class SimpleDateFormat is MUTABLE and NOT threadsafe as it's stateful. So all threads can't have
access to one instance of the class. ThreadLocal class allows each thread to lock onto
individual instance of SimpleDateFormat.
 */
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadLocal {
    public static final int THREADS_NUMBER = 5;
    private final AtomicInteger atomicCounter = new AtomicInteger();


    private static final ThreadLocal<SimpleDateFormat> threadLocal = ThreadLocal.withInitial(() -> new SimpleDateFormat());

    public static void main(String[] args) {
        final MyThreadLocal myThreadLocal = new MyThreadLocal();
        for (int i = 0; i < THREADS_NUMBER; i++) {

                for (int j = 0; j < 3; j++) {
                  //  System.out.println(myThreadLocal.inc());
                 //   System.out.println(threadLocal.get().format(new Date()));
                    System.out.println(myThreadLocal.atomicCounter.get());
                }

        }
     //   System.out.println(myThreadLocal.atomicCounter.get());

    }

  //  private int inc() {
  //  return     atomicCounter.incrementAndGet();
    //  return   ++counter;
  //  }
}
