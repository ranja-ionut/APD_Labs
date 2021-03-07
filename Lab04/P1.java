public class P1 {
    static final int NTHREADS = Runtime.getRuntime().availableProcessors();

    public static void main(String[] args) {
        Task[] threads = new Task[NTHREADS];

        for (int i = 0; i < NTHREADS; i++) {
            threads[i] = new Task(i);
            threads[i].start();
        }

        try {
            for (int i = 0; i < NTHREADS; i++) {
                threads[i].join();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}