package words;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return new ArrayList<>();
        }

        // Remove punctuation and convert to lowercase
        String[] words = sentence.replaceAll("[^a-zA-Z ]", "").toLowerCase().split("\\s+");

        // Collect unique words
        List<String> uniqueWords = Arrays.stream(words)
                .distinct()
                .collect(Collectors.toList());

        return uniqueWords;
    }
}
