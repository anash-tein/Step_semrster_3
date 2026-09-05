import java.util.LinkedHashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
 
public class StopWordFilteredWordFrequency {
 
    private static final List<String> STOP_WORDS =
            Arrays.asList("the", "was", "and", "a", "is", "of", "in");
 
    static void printFilteredWordFrequency(String feedback) {
        // Normalize: lowercase and strip punctuation (periods, commas)
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
 
        String[] words = cleaned.split("\\s+");
 
        // LinkedHashMap preserves first-occurrence order, useful for stable tie ordering
        Map<String, Integer> frequency = new LinkedHashMap<>();
 
        for (String word : words) {
            if (word.isEmpty() || STOP_WORDS.contains(word)) {
                continue;
            }
            frequency.put(word, frequency.getOrDefault(word, 0) + 1);
        }
 
        List<Map.Entry<String, Integer>> entries = new ArrayList<>(frequency.entrySet());
 
        // Stable sort by count descending; ties keep their first-occurrence order
        entries.sort(new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> a, Map.Entry<String, Integer> b) {
                return b.getValue() - a.getValue();
            }
        });
 
        for (Map.Entry<String, Integer> entry : entries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
 
    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }
}
 
