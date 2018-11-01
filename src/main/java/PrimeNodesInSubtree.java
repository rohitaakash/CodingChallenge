import java.util.Set;

public class PrimeNodesInSubtree {

    public static void main(String[] args) {

    }

    public static boolean[] primesLessThan(int N, boolean[] isPrime) {

        for(int i=0; i<isPrime.length; i++) {
            isPrime[i] = true;
        }

        for(int i=2; i*i<=N; i++) {
            if(isPrime[i]) {
                for(int j = i*2; j<=N; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;

    }
}
