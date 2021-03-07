package src.task3;

import java.util.concurrent.ExecutorService;

public class MyRunnable implements Runnable {
    private ExecutorService tpe;
    private int[] graph;
    private int step;

    public MyRunnable(ExecutorService tpe, int[] graph, int step) {
        this.tpe = tpe;
        this.graph = graph;
        this.step = step;
    }

    @Override
    public void run() {
        if (Main.N == step) {
            synchronized (Main.class) {
                if (Main.done == 1) {
                    printQueens(graph);
                    Main.done = 0;
                    tpe.shutdown();
                    return;
                }
            }
        }
        for (int i = 0; i < Main.N; ++i) {
            int[] newGraph = graph.clone();
            newGraph[step] = i;

            if (check(newGraph, step)) {
                tpe.submit(new MyRunnable(tpe, newGraph, step + 1));
            }
        }
    }

    private static boolean check(int[] arr, int step) {
        for (int i = 0; i <= step; i++) {
            for (int j = i + 1; j <= step; j++) {
                if (arr[i] == arr[j] || arr[i] + i == arr[j] + j || arr[i] + j == arr[j] + i)
                    return false;
            }
        }
        return true;
    }

    private static void printQueens(int[] sol) {
        StringBuilder aux = new StringBuilder();
        for (int i = 0; i < sol.length; i++) {
            aux.append("(").append(sol[i] + 1).append(", ").append(i + 1).append("), ");
        }
        aux = new StringBuilder(aux.substring(0, aux.length() - 2));
        System.out.println("[" + aux + "]");
    }
    
}
