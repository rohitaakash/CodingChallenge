import java.util.*;

interface Master {
    public int guess(String word);
}

public class L843GuessTheWord implements Master{
    static String[] wordlist={"acckzz","ccbazz","eiowzz","abcczz"};

    public static void main(String[] args) {
        findSecretWordMinimax(wordlist, new L843GuessTheWord());
    }

    private static void findSecretWordRandom(String[] wordlist, Master master) {
        for (int i = 0, score = 0; i < 10 && score < 6; i++) {
            String currGuess = wordlist[new Random().nextInt(wordlist.length)];
            score = master.guess(currGuess);
            List<String> newWordList = new ArrayList<>();
            for (int j = 0; j < wordlist.length; j++) {
                if (match(currGuess, wordlist[i]) >= score)
                    newWordList.add(wordlist[j]);
            }
            wordlist = newWordList.toArray(new String[0]);
        }
    }

    private static void findSecretWordMinimax(String[] wordlist, Master master) {
        for (int i = 0, score = 0; i < 10 && score < 6; i++) {
            Map<String, Integer> zeroMatch = new HashMap<>();
            for (String a : wordlist) {
                for (String b : wordlist) {
                    if (match(a, b) == 0)
                        zeroMatch.put(a, zeroMatch.getOrDefault(a, 0) + 1);
                }
            }

            int minZeroMatch = Integer.MAX_VALUE;
            String minZeroMatchWord = wordlist[0];
            for(String word: zeroMatch.keySet()) {
                if(zeroMatch.get(word) < minZeroMatch) {
                    minZeroMatchWord = word;
                    minZeroMatch = zeroMatch.get(word);
                }
            }
            score = master.guess(minZeroMatchWord);
            if(score == 6) {
                System.out.println("Secret Found " + minZeroMatchWord);
                return;
            }
            List<String> newWordList = new ArrayList<>();
            for(String word: wordlist) {
                if(match(minZeroMatchWord, word) == score)
                    newWordList.add(word);
            }
            wordlist = newWordList.toArray(new String[0]);
        }

        System.out.println("Secret Not Found");

    }

    private static int match(String a, String b) {
        int count = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) == b.charAt(i))
                count++;
        }
        return count;
    }

    @Override
    public int guess(String word) {
        String secret = "acckzz";
        boolean found = false;
        for(int i=0; i<wordlist.length; i++) {
            if(wordlist[i].equals(word)) {
                found = true;
                break;
            }

        }
        if(!found) return -1;

        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (secret.charAt(i) == word.charAt(i))
                count++;
        }
        return count;
    }
}
