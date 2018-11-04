public class L299BullsAndCows {

    public static void main(String[] args) {
        String secret = "1122", guess = "2211";
//        String secret = "1123", guess = "0111";
//        String secret = "11", guess = "11";
        System.out.println(getHint(secret, guess));
        System.out.println(getHintOptimized(secret, guess));
    }

    public static String getHint(String secret, String guess) {
        StringBuilder sb = new StringBuilder();
        int bulls = 0, cows = 0;

        boolean[] exactMatch = new boolean[secret.length()];
        boolean[] foundMatch = new boolean[secret.length()];

        for(int i=0; i<guess.length(); i++) {
            if(secret.charAt(i) == guess.charAt(i)) {
                exactMatch[i] = true;
                bulls++;
            }

        }
        sb.append(bulls).append("A");

        for(int i=0; i<guess.length(); i++) {
            if(!exactMatch[i]) {
                int index = -2, ind = -1;
                while(index == -2) {
                    ind = secret.indexOf(guess.charAt(i), ind+1);
                    if(ind!=-1 && (exactMatch[ind] || foundMatch[ind])) index = -2;
                    else index = ind;
                }
                if(index != -1 && !foundMatch[index]) {
                    cows++;
                    foundMatch[ind] = true;
                }
            }
        }

        sb.append(cows).append("B");
        return sb.toString();
    }

    private static String getHintOptimized(String secret, String guess) {
        int bulls = 0, cows = 0;
        int[] numbers = new int[10];
        for (int i = 0; i<secret.length(); i++) {
            if (secret.charAt(i) == guess.charAt(i)) bulls++;
            else {
                if (numbers[secret.charAt(i) - '0'] ++ < 0) cows++;
                if (numbers[guess.charAt(i) - '0'] -- > 0) cows++;
            }
        }
        return bulls + "A" + cows + "B";
    }
}
