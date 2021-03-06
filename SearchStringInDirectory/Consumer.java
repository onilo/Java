public class Consumer implements Runnable {

	private static String keyword;

	public static void setKeyword(String keyword) {
		Consumer.keyword = keyword;
	}

	@Override
	public void run() {
		while (!Buffer.getInstance().isProducingFinished() || Buffer.getInstance().isNotEmpty()) {
			ProductLine data = Buffer.getInstance().getProductLine();
			if (data.getLine().contains(keyword)) {
				System.out.println(data.toString());
			}
		}
	}
}
