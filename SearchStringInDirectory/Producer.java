import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class Producer implements Runnable {

	private LinesReader visitor = new LinesReader();
	private Path start;

	public Producer(Path path) {
		start = path;
	}

	@Override
	public void run() {
		try {
			Files.walkFileTree(start, visitor);
			Buffer.getInstance().setProducingEnded();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
