import java.util.ArrayList;
import java.util.List;

public class MainConcurrencyWithJoin {
    public static final int THREADS_NUMBER = 10000;
    private  int counter;

    public static void main(String[] args) {
        final MainConcurrencyWithJoin mainConcurrency = new MainConcurrencyWithJoin();
        List<Thread> threads = new ArrayList<>(THREADS_NUMBER);

        for (int i = 0; i < THREADS_NUMBER; i++) {
            Thread thread = new Thread(() -> {
                for (int j = 0; j < 100; j++) {
                    mainConcurrency.inc();


                }
            });
            thread.start();
            threads.add(thread);

        }

        threads.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        System.out.println(mainConcurrency.counter);
    }



    private synchronized void inc() {    // !!! synchronized
        counter++;
    }
}

