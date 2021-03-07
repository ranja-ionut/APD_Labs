package src.task2;

import java.util.concurrent.ExecutorService;

public class MyRunnable implements Runnable {
    private ExecutorService tpe;
    private int[] colors;
    private int step;

    public MyRunnable(ExecutorService tpe, int[] colors, int step) {
        this.tpe = tpe;
        this.colors = colors;
        this.step = step;
    }

    @Override
    public void run() {
        if (step == Main.N) {
            synchronized(Main.class) {
                if (Main.done == 1) {
                    printColors(colors);
                    Main.done = 0;
                    tpe.shutdown();
                    return;
                }
            }
        }

        // for the node at position step try all possible colors
        for (int i = 0; i < Main.COLORS; i++) {
            int[] newColors = colors.clone();
            newColors[step] = i;
            if (verifyColors(newColors, step))
                tpe.submit(new MyRunnable(tpe, newColors, step + 1));
        }
    }

    private static boolean verifyColors(int[] colors, int step) {
        for (int i = 0; i < step; i++) {
            if (colors[i] == colors[step] && isEdge(i, step))
                return false;
        }
        return true;
    }

    private static boolean isEdge(int a, int b) {
        for (int[] ints : Main.graph) {
            if (ints[0] == a && ints[1] == b)
                return true;
        }
        return false;
    }

    static void printColors(int[] colors) {
        StringBuilder aux = new StringBuilder();
        for (int color : colors) {
            aux.append(color).append(" ");
        }
        System.out.println(aux);
    }
    
}
