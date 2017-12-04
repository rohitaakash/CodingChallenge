import java.util.Stack;

public class CourseSchedule {
	public int[] findOrder(int numCourses, int[][] prerequisites) {
        boolean[][] visited = new boolean[numCourses][2]; 
        Stack<Integer> dfsStack = new Stack<>();
        int[] order = new int[numCourses];
       
        for(int i=0; i<numCourses; i++){
            if(!visited[i][0]){
                topologicalSort(i, prerequisites, visited, dfsStack);
            }
        }
        
        if(dfsStack.size()!=numCourses){
            return new int[0];
        }
        
        for(int i=0; !dfsStack.isEmpty(); i++){
            order[i] = dfsStack.pop();
        }
    
        return order;
    }
    
    public void topologicalSort(int courseNumber, int[][] prerequisites, boolean[][] visited, Stack<Integer> dfsStack){
        visited[courseNumber][0] = true;
        visited[courseNumber][1] = true;
        for(int i=0; i<prerequisites.length; i++){
            if(prerequisites[i][1] == courseNumber && visited[prerequisites[i][0]][1]) return;            
            else if(prerequisites[i][1] == courseNumber && !visited[prerequisites[i][0]][0]) {
            	topologicalSort(prerequisites[i][0], prerequisites, visited, dfsStack);                
            }
        }
        visited[courseNumber][1] = false;
        dfsStack.push(courseNumber);
    }
    
    public static void main(String[] args) {
    	CourseSchedule cs = new CourseSchedule();
    	int[][] prerequisites = {{1,0}, {0,1}};
    	
    	int[] result = cs.findOrder(2, prerequisites);
    	
    	for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
    	
    }
    
}