package words;
package words;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Words {
    public static List<String> getUniqueWordsFromSentence(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return List.of();
        }

        Set<String> uniqueWords = Arrays.stream(sentence.trim().toLowerCase().split("\\s+"))
                                        .collect(Collectors.toSet());

        return List.copyOf(uniqueWords);
    }
}
