import java.util.Scanner;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class wordCount {

	public static void main(String[] args) {

		FileInputStream fileByteStream = null;
		Scanner inFS = null;
		String currWord;

		try {
			fileByteStream = new FileInputStream("poem.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		inFS = new Scanner(fileByteStream);

		System.out.println("Reading file words");

		ArrayList<String> arr = new <String>ArrayList();

		while (inFS.hasNext()) {

			currWord = inFS.next();

			arr.add(currWord);

		}

		try {
			fileByteStream.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

		for (String x : arr) {

			System.out.println(x);
		}

	}

}
