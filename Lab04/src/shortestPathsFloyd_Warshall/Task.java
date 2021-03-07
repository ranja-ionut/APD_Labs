package src.shortestPathsFloyd_Warshall;
import java.util.concurrent.BrokenBarrierException;

public class Task implements Runnable{
    private int id, graph[][];

    public Task(int id, int[][] graph){
        this.id = id;
        this.graph = graph;
    }

    public void run(){
        int start = (int)(id * (double) Main.N / Main.P);
        int end = (int)Math.min((id + 1) * (double)Main.N / Main.P, Main.N);
        
        for (int k = 0; k < Main.N; k++) {
			for (int i = start; i < end; i++) {
				for (int j = 0; j < Main.N; j++) {
					graph[i][j] = Math.min(graph[i][k] + graph[k][j], graph[i][j]);
				}
            }
            
            try {
                Main.barrier.await();
            } catch (BrokenBarrierException | InterruptedException e) {
                e.printStackTrace();
            }
		}
    }
}
