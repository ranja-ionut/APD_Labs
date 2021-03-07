package parallelBinarySearch;

import java.util.concurrent.BrokenBarrierException;

public class MyTask implements Runnable {
    private int id;

    public MyTask(int id) {
        this.id = id;
    }

    @Override
    public void run() {
        int start = (int) (id * (double) Main.N / Main.P);
        int end = (int) Math.min(((id + 1) * (double) Main.N / Main.P), Main.N - 1);

        while (Main.i_0 < Main.i_n && !Main.found
                && !(Main.element < Main.array[0] || Main.element > Main.array[Main.N - 1])
                && !(Main.i_n - Main.i_0 == 1)) {
            
            try {
                Main.barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            if (Main.array[start] < Main.element && Main.element < Main.array[end]) {
                synchronized (this) {
                    Main.i_0 = start;
                    Main.i_n = end;
                }
            }

            if (Main.array[start] == Main.element) {
                synchronized (this) {
                    Main.found = true;
                    Main.pos = start;
                }
            }

            if (Main.array[end] == Main.element) {
                synchronized (this) {
                    Main.found = true;
                    Main.pos = end;
                }
            }

            try {
                Main.barrier.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }

            start = Main.i_0 + (int) (id * (double) (Main.i_n - Main.i_0) / Main.P);
            end = (int) (Math.min(Main.i_0 + (id + 1) * (double) (Main.i_n - Main.i_0) / Main.P, Main.N - 1));
        }
    }
    
}
