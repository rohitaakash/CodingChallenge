public class L135Candy {

    public static void main(String[] args) {
//        int[] ratings = {1, 0, 2};
        int[] ratings = {1, 2, 2};
        System.out.println(candy(ratings));
    }

    /* Ref: https://leetcode.com/problems/candy/discuss/42770/One-pass-constant-space-Java-solution */
    private static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int total = 1, prev = 1, descSeqCount = 0;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] >= ratings[i-1]) {
                if (descSeqCount > 0) {
                    total += descSeqCount*(descSeqCount+1)/2; // arithmetic progression
                    if (descSeqCount >= prev) total += descSeqCount - prev + 1; // increase total to avoid max in decreasing sequence to have a lower peak value
                    descSeqCount = 0; // reset since a nn-decreasing sequence has started
                    prev = 1; // reset prev since prev non-decreasing sequence won't affect
                }
                prev = ratings[i] == ratings[i-1] ? 1 : prev+1; // regular check previous candy case
                total += prev; // update total
            } else descSeqCount++; // increase count for number for elements in decreasing sequence
        }
        if (descSeqCount > 0) { // if we were descending at the end
            total += descSeqCount*(descSeqCount+1)/2;
            if (descSeqCount >= prev) total += descSeqCount - prev + 1;
        }
        return total;
    }
}
