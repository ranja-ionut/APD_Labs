package src.doubleVectorElements;
/**
 * @author cristian.chilipirea
 *
 */
public class Main {
	public static final int P = Runtime.getRuntime().availableProcessors(), N = 100000013;
	public static void main(String[] args) {
		int v[] = new int[N];
		Thread[] threads = new Thread[P]; 
	
		for(int i=0;i<N;i++)
			v[i]=i;
		

		for (int i = 0; i < P; i++) {
			threads[i] = new Thread(new Task(i, v));
			threads[i].start();
		}

		try {
			for(int i = 0; i < P; i++){
				threads[i].join();
			}
		} catch (InterruptedException e) {
            e.printStackTrace();
        }

		for (int i = 0; i < N; i++) {
			if(v[i]!= i*2) {
				System.out.println("Wrong answer");
				System.exit(1);
			}
		}
		System.out.println("Correct");
	}

}
