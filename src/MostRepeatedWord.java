import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Collections;


public class MostRepeatedWord {

	public static void main(String[] args) throws Exception {

		FileReader file = new FileReader("poem.txt");
		BufferedReader reader = new BufferedReader(file);

		Map<String, Integer> frequency = new HashMap<>();

		String line = reader.readLine();

		while (line != null) {

			// System.out.println("Processing line: " + line);

			if (!line.trim().equals("")) {
				String[] words = line.split(" ");

				for (String word : words) {

					if (word == null || word.trim().equals("")) {
						continue;
					}
					String processed = word.toLowerCase();
					//processed = processed.replace(",", "");
					processed = processed.replaceAll("[^a-zA-Z0-9]", "");

					if (frequency.containsKey(processed)) {
						frequency.put(processed, frequency.get(processed) + 1);
					} else {
						frequency.put(processed, 1);

					}

				}

			}

			line = reader.readLine();

		}		
				
		//System.out.println(frequency);
		
		int mostFrequentlyUsed = 0;
		String theWord = null;
		
		for(String word : frequency.keySet()) {
			Integer theVal = frequency.get(word);
			if( theVal > mostFrequentlyUsed) {
				mostFrequentlyUsed = theVal;
				theWord = word;
				
			}			
			
			
		}
		
		// System.out.printf("The most frequently used word is '%s', %d, times", theWord, mostFrequentlyUsed);
		
		//System.out.println();
		//System.out.println();
		
		// Now let's sort HashMap by keys first
		// all you need to do is create a TreeMap with mappings of HashMap
		// TreeMap keeps all entries in sorted order		
		
		
		//System.out.println("HashMap after sorting by keys in ascending order ");
		
		TreeMap<String, Integer> sorted = new TreeMap<>(frequency);
		Set<Entry<String, Integer>> mappings = sorted.entrySet();
		
		for(Entry<String, Integer> mapping : mappings) {
			
			//System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
			
		}
		
		//System.out.println();
		//System.out.println();
		
		// Sorting HashMap by values
		// no direct way to sort HashMap by values
		// need to create comparator
		// that takes Map.Entry object and arranges them in order
		// of increasing or decreasing value
	
		List<Entry<String, Integer>> listOfEntries = new ArrayList<Entry<String, Integer>>(mappings);
		
		Collections.sort(listOfEntries, Collections.reverseOrder(valueComparator));
		
		LinkedHashMap<String, Integer> sortedbyValue = new LinkedHashMap<String, Integer>(listOfEntries.size());
		
		for(Entry<String, Integer> entry: listOfEntries) {
			
			sortedbyValue.put(entry.getKey(), entry.getValue());
			
		}
		
		//System.out.println("HashMap after sorting entries by values");
		Set<Entry<String, Integer>> entrySetSortedByValue = sortedbyValue.entrySet();
		
		for(Entry<String, Integer> mapping : entrySetSortedByValue) {
		//	System.out.println(mapping.getKey() + " ==> " + mapping.getValue());
			
		}
		
		
		//System.out.println();
		System.out.println("The top 20 word frequencies are: ");
		
		List<Entry<String, Integer>> sortedListOfEntries = new ArrayList<Entry<String, Integer>>(entrySetSortedByValue);
		
		for(int i = 0; i < 20; i++) {
			System.out.println(sortedListOfEntries.get(i));			
			
		}
	
						
				
		
	}
	
	static Comparator<Entry<String, Integer>> valueComparator = new Comparator<Entry<String, Integer>>(){
		
		@Override
		public int compare(Entry<String, Integer> e1, Entry<String, Integer> e2) {
			Integer v1 = e1.getValue();
			Integer v2 = e2.getValue();
			return v1.compareTo(v2);
			
		}
	};
	
		
	

	

}


