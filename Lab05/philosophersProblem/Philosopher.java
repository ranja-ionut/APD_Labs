package philosophersProblem;

/**
 * @author cristian.chilipirea
 * 
 */
public class Philosopher implements Runnable {
	Object leftFork, rightFork;
	int id;

	public Philosopher(int id, Object leftFork, Object rightFork) {
		this.leftFork = leftFork;
		this.rightFork = rightFork;
		this.id = id;
	}

	@Override
	public void run() {
		if (id == 0) {
			synchronized (rightFork) {
				synchronized (leftFork) {
					System.out.println("Philosopher " + id + " is eating");
				}
			}
		} else {
			synchronized (leftFork) {
				synchronized (rightFork) {
					System.out.println("Philosopher " + id + " is eating");
				}
			}
		}
	}
}
