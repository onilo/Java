public class ProductLine {

	private String answerLine;
	private String line;

	public ProductLine(String fileName, long row, String line) {
		answerLine = String.join(" ", "In file:", fileName, ",", "row:", String.valueOf(row), ", line:");
		this.line = line;
	}

	public String getLine() {
		return line;
	}

	@Override
	public String toString() {
		return String.format("%s %s", answerLine, line);
	}
}
