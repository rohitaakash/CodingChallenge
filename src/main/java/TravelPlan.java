import java.util.ArrayList;
import java.util.List;

public class TravelPlan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//        int[] nums= {1,2,2,4,4,3};
        int[] nums = { 2, 1, 1, 3, 2, 1, 1, 3 };
//        int[] nums = { 7, 5, 2, 7, 2, 7, 4, 7 };
        int length=nums.length;
        List<Integer> distinctList=new ArrayList<Integer>();
        for(int i=0;i<length;i++) {
        	 if(!distinctList.contains(nums[i]))
        	      distinctList.add(nums[i]);
        }
        List<Integer> masterList=distinctList;
        List<Integer> tempList=new ArrayList<Integer>();
        int returnRange=0;
        for(int i=0;i<length;i++) {
        	   
        	   
        	   if(tempList.contains(nums[i])) {
        		   while(Integer.parseInt(tempList.get(0)+"")==nums[i]) {
        			   tempList.remove(0);
        		   }
        		   tempList.add(nums[i]);
        		   int size=tempList.size();
        		   distinctList.removeAll(tempList);
        		   if(distinctList.isEmpty()) {
        			   if(returnRange==0)
        			      returnRange=size;
        			   else if (size<returnRange)
        				   returnRange=size;
        			   distinctList=masterList;
        		   }
        	   }else {
        		   
        		   tempList.add(nums[i]);
        		   int size=tempList.size();
        		   distinctList.removeAll(tempList);
        		   if(distinctList.isEmpty()) {
        			   if(returnRange==0)
         			      returnRange=size;
         			   else if (size<returnRange)
         				   returnRange=size;
        			   distinctList=masterList;
        		   }
        	   }
        }
        System.out.println(returnRange);
	}

}