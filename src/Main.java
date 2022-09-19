import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.io.BufferedReader;
import java.util.Map.Entry;
import java.util.stream.Collectors;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;



public class Main {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		BufferedReader bufferedReader = new FileReader("EdgarPoem.txt"));
		Map<String, Integer> wordCounts = new HashMap<>();
		String line;

			while ((line = bufferedReader.readLine()) != null) {

				String[] words = line.split("/\s/");
				for (String word : words) {

				word = word.trim();

				if (word.length() > 0) {

					if (wordCounts.containsKey(word)) {
						wordCounts.put(word, wordCounts.get(word) + 1);
					} else {
						wordCounts.put(word, 1);
					}
				}
			}
		}

		// sorting wordCounts by frequency
		Map<String, Integer> sortedWordCounts = wordCounts.entrySet().stream()
				.sorted(Collections.reverseOrder(Entry.comparingByValue()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));


		System.out.printf("Word", "Frequency");

		System.out.printf("====", "=========");

		for (Map.Entry<String, Integer> entry : sortedWordCounts.entrySet()) {
			System.out.printf( entry.getKey(), entry.getValue());
		}

		bufferedReader.close();
	}
}