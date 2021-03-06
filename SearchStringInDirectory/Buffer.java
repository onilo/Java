import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Buffer {

	private static Buffer instance = new Buffer();
	private BlockingQueue<ProductLine> queue;
	private boolean areProducersDone;

	public Buffer() {
		queue = new LinkedBlockingQueue<>();
		areProducersDone = false;
	}

	public static synchronized Buffer getInstance() {
		if (instance == null) {
			instance = new Buffer();
		}
		return instance;
	}

	public void add(ProductLine line) {
		synchronized (queue) {
			queue.add(line);
			queue.notify();
		}
	}

	public ProductLine getProductLine() {
		synchronized (queue) {
			while (queue.isEmpty()) {
				try {
					queue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			return queue.poll();
		}
	}

	public boolean isNotEmpty() {
		return !queue.isEmpty();
	}

	public boolean isProducingFinished() {
		return areProducersDone;
	}

	public void setProducingEnded() {
		areProducersDone = true;
	}
}
