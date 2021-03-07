package multipleProducersMultipleConsumersNBuffer;

import java.util.Queue;
import java.util.concurrent.Semaphore;

/**
 * @author Gabriel Gutu <gabriel.gutu at upb.ro>
 *
 */
public class Buffer {
    Queue queue;
    Semaphore plin, gol;

    public Buffer(int size) {
        queue = new LimitedQueue(size);
        plin = new Semaphore(0);
        gol = new Semaphore(size);
    }

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
