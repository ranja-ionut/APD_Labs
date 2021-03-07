package src.multipleProducersMultipleConsumers;

import java.util.concurrent.ArrayBlockingQueue;

public class Buffer {
	int value;

	ArrayBlockingQueue<Integer> queue = new ArrayBlockingQueue<>(30);

	void put(int value) {
		try {
			queue.put(value);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	int get() {
		int value;
		try {
			value = queue.take();
		} catch (InterruptedException e) {
			e.printStackTrace();
			value = -1;
		}

		return value;
	}
}
