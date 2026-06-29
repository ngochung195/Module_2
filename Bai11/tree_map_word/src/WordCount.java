import java.util.Map;
import java.util.TreeMap;

public class WordCount {
    public static void main(String[] args) {
        String text = "Hoc lap trinh tai CodeGym rat vui. Hoc lap trinh khong kho neu cham chi.";

        Map<String, Integer> wordMap = new TreeMap<>();

        String[] words = text.split("\\s+");

        for (String word : words) {
            word = word.toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()]", "");

            if (word.isEmpty()) {
                continue;
            }

            if (wordMap.containsKey(word)) {
                wordMap.put(word, wordMap.get(word) + 1);
            } else {
                wordMap.put(word, 1);
            }
        }

        System.out.println("Ket qua: ");
        for (Map.Entry<String, Integer> entry : wordMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue() + " lan");
        }
    }
}