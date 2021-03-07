package src.task1;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;

public class MyRunnable implements Runnable {
    private ExecutorService tpe;
    private ArrayList<Integer> partialPath;
    private int destination;

    public MyRunnable(ExecutorService tpe, ArrayList<Integer> partialPath, int destination) {
        this.tpe = tpe;
        this.partialPath = partialPath;
        this.destination = destination;
    }

    @Override
    public void run() {
        if (partialPath.get(partialPath.size() - 1) == destination) {
            synchronized (Main.class) {
                if (Main.done == 1) {
                    System.out.println(partialPath);
                    Main.done = 0;
                    tpe.shutdown();
                    return;
                }
            }
        }

        // se verifica nodurile pentru a evita ciclarea in graf
        int lastNodeInPath = partialPath.get(partialPath.size() - 1);
        for (int[] ints : Main.graph) {
            if (ints[0] == lastNodeInPath) {
                if (partialPath.contains(ints[1]))
                    continue;
                ArrayList<Integer> newPartialPath = new ArrayList<>(partialPath);
                newPartialPath.add(ints[1]);
                tpe.submit(new MyRunnable(tpe, newPartialPath, destination));
            }
        }
    }
    
}
