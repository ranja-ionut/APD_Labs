package oneProducerOneConsumer;

import java.util.concurrent.Semaphore;

import multipleProducersMultipleConsumersNBuffer.LimitedQueue;

import java.util.Queue;

/**
 * @author Gabriel Gutu <gabriel.gutu at upb.ro>
 *
 */
public class Buffer {
	private final static int BUFFER_SIZE = 100; 
    Queue queue =  new LimitedQueue(BUFFER_SIZE);
	Semaphore plin = new Semaphore(0);
	Semaphore gol = new Semaphore(BUFFER_SIZE);

    void put(int value) {
        try {
            gol.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized(queue) {
            queue.add(value);
        }
        plin.release();
    }

    int get() {
        try {
            plin.acquire();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        int rez;
        synchronized(queue) {
            rez = (int)queue.poll();
        }
        gol.release();
        return rez;
	}
}