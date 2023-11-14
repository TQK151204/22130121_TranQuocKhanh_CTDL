package Lab_8;

import java.io.FileNotFoundException;

public class TestMyWordCountApp {
	public static void main(String[] args) throws FileNotFoundException {
		MyWordCountApp app = new MyWordCountApp();
		System.out.println(app.countUnique());
		app.printWordCounts();
		app.printWordCountsAlphabet();
	}
}
