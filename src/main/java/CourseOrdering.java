import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class CourseOrdering {

	public boolean canFinish(int numCourses, int[][] prerequisites) {

		boolean[] visited = new boolean[numCourses];
		ArrayList<Integer> stackElements = new ArrayList<>();
		HashMap<Integer, ArrayList<Integer>> adjList = new HashMap<>();
		
		ArrayList<Integer> newList;
		for (int i = 0; i < prerequisites.length; i++) {
			if(!adjList.containsKey(prerequisites[i][1])) {
				newList = new ArrayList<>();
				newList.add(prerequisites[i][0]);
				adjList.put(prerequisites[i][1], newList);
			}else {
				newList = adjList.get(prerequisites[i][1]);
				newList.add(prerequisites[i][0]);
				adjList.put(prerequisites[i][1], newList);
			}
		}
		
		for (int i = 0; i < visited.length; i++) {
			if(visited[i] == false) {
				topologicalSort(adjList, visited, i, new HashSet<>(), stackElements);
			}
		}
		
		return stackElements.size() == numCourses;
	}

	public void topologicalSort(HashMap<Integer, ArrayList<Integer>> adjList, boolean[] visited, int key, HashSet<Integer> parent, ArrayList<Integer> stackElements) {
		visited[key] = true;
		parent.add(key);
		if(adjList.containsKey(key)) {
			for(Integer i: adjList.get(key)) {
				if(!parent.contains(i)) {
					if(visited[i] == false) {
						topologicalSort(adjList, visited, i, parent, stackElements);
					}
				}else {
					return;
				}
			}
		}
		parent.remove(key);
		stackElements.add(key);
	}
	
	public static void main(String[] args) {
		int numCourses = 4;
		int[][] prerequisites = {{1,0}, {2,0}, {0,2}};
		
		CourseOrdering co = new CourseOrdering();
		System.out.println(co.canFinish(numCourses, prerequisites));
	}

}
