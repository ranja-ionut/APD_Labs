package parallelBinarySearch;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static final int N = 30, P = 4;

    public static int[] array = new int[N];
    public static int element;
    public static CyclicBarrier barrier;

    public static int i_0 = 0, i_n = N, pos = -1;
    public static boolean found = false;

	public static void main(String[] args) {
        Random random = new Random();

        element = random.nextInt(N);

        System.out.println("Elementul cautat: " + element);

        System.out.print("Pozitii: ");
        for (int i = 0; i < N; i++) {
            System.out.print(i + " ");
            array[i] = random.nextInt(N);
        }

        System.out.println();

        Arrays.sort(array);

        System.out.print("Valori:  ");
        for (int i = 0; i < N; i++) {
            System.out.print(array[i] + " ");
        }

        System.out.println();
        
        Thread threads[] = new Thread[P];
        barrier = new CyclicBarrier(P);

        for (int i = 0; i < P; i++) {
		    threads[i] = new Thread(new MyTask(i));
        }

		for (int i = 0; i < P; i++)
			threads[i].start();
		for (int i = 0; i < P; i++) {
			try {
				threads[i].join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
        }
        
        if (pos >= 0) {
            System.out.println("Am gasit elementul " + element + " pe pozitia " + pos);
        } else {
            System.out.println("Elementul " + element + " nu exista in array");
        }
	}
}
