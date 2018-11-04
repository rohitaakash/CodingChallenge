import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class L857MinimumCostToHireKWorkers {

    public static void main(String[] args) {
        int[] quality = {10, 20, 5};
        int[] wages = {70, 50, 30};
        System.out.println(minCostToHireWorkersGreedy(quality, wages, 2));
        System.out.println(minCostToHireWorkersHeap(quality, wages, 2));
    }

    private static double minCostToHireWorkersGreedy(int[] quality, int[] wage, int K) {
        double ans = 1e9;
        for (int i = 0; i < quality.length; i++) {
            double rate = (double) wage[i] / quality[i];
            double[] prices = new double[quality.length];
            int n = 0;
            for (int j = 0; j < quality.length; j++) {
                double price = rate * quality[j];
                if (price >= wage[j])
                    prices[n++] = price;
            }

            if (n < K) continue;

            Arrays.sort(prices, 0, n);
            double currAns = 0.0;
            for (int j = 0; j < K; j++) {
                currAns += prices[j];
            }
            ans = Math.min(ans, currAns);
        }
        return ans;
    }

    private static double minCostToHireWorkersHeap(int[] quality, int[] wage, int K) {
        //Create a data structure to store both quality and wage of a worker
        Worker[] workers = new Worker[quality.length];
        for(int i=0; i<quality.length; i++) {
            workers[i] = new Worker(quality[i], wage[i]);
        }

        //Sort them in ascending order of their quality
        Arrays.sort(workers);

        //Create a max heap to store K min qualities
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        double qualitySum = 0.0, ans = 1e9;
        for(Worker worker: workers) {
            //Calculate cumulative sum of the quality
            qualitySum += worker.quality;
            pq.offer(worker.quality);
            if(pq.size() > K) {
                //Remove the contribution if worker's quality is not being considered
                qualitySum = qualitySum - pq.poll();
            }

            if(pq.size() == K) {
                //Compute minimum of ans and amount if a worker with current ratio were to be made the driving person
                ans = Math.min(ans, worker.getRatio() * qualitySum);
            }
        }
        return ans;
    }


}

class Worker implements Comparable<Worker>{
    int quality;
    int wage;

    Worker(int quality, int wage) {
        this.quality = quality;
        this.wage = wage;
    }

    public double getRatio() {
        return (double) wage/quality;
    }

    @Override
    public int compareTo(Worker other) {
        return Double.compare(getRatio(), other.getRatio());
    }
}
