import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class DeliveryProblem {

    public static void main(String[] args) {
        List<Integer> temp = new ArrayList<>();
        List<List<Integer>> allLocations = new ArrayList<>();
        temp.add(1);
        temp.add(2);
        allLocations.add(temp);

        temp = new ArrayList<>();
        temp.add(3);
        temp.add(4);
        allLocations.add(temp);

        temp = new ArrayList<>();
        temp.add(1);
        temp.add(-1);
        allLocations.add(temp);
        System.out.println(ClosestXdestinations(3, allLocations, 2));
    }
    public static List<List<Integer>> ClosestXdestinations(int numDestinations,
                                                    List<List<Integer>> allLocations,
                                                    int numDeliveries)
    {
        // WRITE YOUR CODE HERE
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>(numDeliveries, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                return (o2.get(0)*o2.get(0) + o2.get(1)*o2.get(1)) - (o1.get(0)*o1.get(0) + o1.get(1)*o1.get(1));
            }
        });

        for(int i=0; i<numDestinations; i++) {
            if(i < numDeliveries) pq.add(allLocations.get(i));
            else {
                if(!pq.isEmpty() && getDistance(pq.peek()) > getDistance(allLocations.get(i))) {
                    pq.poll();
                    pq.add(allLocations.get(i));
                }
            }
        }

        return new ArrayList<>(pq);
    }

    private static double getDistance(List<Integer> coord) {
        return Math.sqrt(coord.get(0)*coord.get(0) + coord.get(1)*coord.get(1));
    }
}
