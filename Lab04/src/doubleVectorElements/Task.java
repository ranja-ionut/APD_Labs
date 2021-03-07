package src.doubleVectorElements;

public class Task implements Runnable{
    private int id;
    private int[] v;

    public Task(int id, int[] v){
        this.id = id;
        this.v = v;
    }

    public void run(){
        int start = (int)(id * (double) Main.N / Main.P);
        int end = (int)Math.min((id + 1) * (double)Main.N / Main.P, Main.N);

        for (int i = start; i < end; i++) {
			v[i] = v[i] * 2;
		}
    }
}
