import java.util.Random;

public class RandomizedSet {
    
    private int[] random;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        random = new int[0];
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        for(int i=0; i<random.length; i++){
            if(random[i] == val) return false;
        }
        
        int[] temp = random;
        random = new int[random.length+1];
        
        for(int i=0; i<temp.length; i++){
            random[i] = temp[i];
        }
        
        random[random.length-1] = val;
        return true;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        boolean flag = false;
        int index = 0;
        for(int i=0; i<random.length; i++){
            if(random[i] == val){
                flag = true;
                index = i;
            }
        }
        
        if(flag){
            int[] temp = random;
            random = new int[random.length-1];
            for(int i=0, j=0; i<temp.length; i++){
                if(i==index){
                    continue;
                }else{
                    random[j] = temp[i];
                    j++;
                }
            }
            return true;
        }else{
            return false;
        }
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        Random rand = new Random();
        int i = rand.nextInt(random.length);
        return random[i];
    }
    
    public void printRandom() {
    	for(int i=0; i<random.length; i++) {
    		System.out.print(random[i] + " ");
    	}
    	System.out.println();
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub

		RandomizedSet rs = new RandomizedSet();
		System.out.println(rs.insert(1));
		System.out.println(rs.remove(2));
		System.out.println(rs.insert(2));
		
		rs.printRandom();
		
		System.out.println(rs.getRandom());
		System.out.println(rs.remove(1));
		
		rs.printRandom();
		
		System.out.println(rs.insert(2));
		
		rs.printRandom();
	}
}
