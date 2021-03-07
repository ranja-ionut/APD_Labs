package src.shortestPathsFloyd_Warshall;
import java.util.concurrent.CyclicBarrier;
/**
 * @author cristian.chilipirea
 *
 */
public class Main {
	public static final int P = Runtime.getRuntime().availableProcessors(), N = 5;
	public static CyclicBarrier barrier;

	public static void main(String[] args) {
		int M = 9;
		int graph[][] = { { 0, 1, M, M, M }, 
				          { 1, 0, 1, M, M }, 
				          { M, 1, 0, 1, 1 }, 
				          { M, M, 1, 0, M },
						  { M, M, 1, M, 0 } };
						  
		Thread[] threads = new Thread[P];
		barrier = new CyclicBarrier(P);

		for (int i = 0; i < P; i++) {
			threads[i] = new Thread(new Task(i, graph));
			threads[i].start();
		}
		
		// Parallelize me (You might want to keep the original code in order to compare)
		/*for (int k = 0; k < 5; k++) {
			for (int i = 0; i < 5; i++) {
				for (int j = 0; j < 5; j++) {
					graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
				}
			}
		}*/
		
		try {
			for (int i = 0; i < P; i++) {
				threads[i].join();
			}
		}  catch (InterruptedException e) {
            e.printStackTrace();
        }

		for (int i = 0; i < 5; i++) {
			for (int j = 0; j < 5; j++) {
				System.out.print(graph[i][j] + " ");
			}
			System.out.println();
		}
	}
}
