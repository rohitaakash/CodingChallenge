import java.util.ArrayList;
import java.util.List;

public class MissingWords {

    public static void main(String[] args) {
        String s = "I am using HackerRank to improve programming";
        String t = "am HackerRank to improve";

        System.out.println(missingWords(s, t));
    }

    public static List<String> missingWords(String s, String t) {
        List<String> missingWords = new ArrayList<>();
        String[] sentenceWords = s.split("\\s");
        String[] subsequenceWords = t.split("\\s");
        for (int i = 0, j = 0; i < sentenceWords.length; i++) {
            if (j < subsequenceWords.length && sentenceWords[i].equals(subsequenceWords[j])) {
                j++;
            } else {
                missingWords.add(sentenceWords[i]);
            }
        }
        return missingWords;
    }
}
