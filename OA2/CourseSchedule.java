package Amazon.OA2;

import java.util.*;

public class CourseSchedule {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] schedule_1 = new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}};
		int numCourses = 4;
		int[] res = findOrder(numCourses, schedule_1);
		for (int num : res) System.out.print(num + " ");
	}
	
	/**
	 * Idea -> Topological sort
	 * 
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	private static int[] findOrder(int numCourses, int[][] prerequisites) {
//		if (numCourses <= 0 || prerequisites == null || prerequisites.length == 0 ||
//				prerequisites[0].length != 2) return new int[0];
		
		HashMap<Integer, Integer> degree = new HashMap<>();
		HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
		
		/* 1. put all courses into degree map */
		for (int i = 0; i < numCourses; i++) degree.put(i, 0);
		
		/* 2. set up map and calculate each course's incoming degree */
		for (int[] pre : prerequisites) {
			int first = pre[1];
			int second = pre[0];
			
			HashSet<Integer> set = new HashSet<>();
			if (map.containsKey(first)) set = map.get(first);
			if (!set.contains(second)) {
				set.add(second);
				map.put(first, set);
				degree.put(second, degree.get(second) + 1);
			}
		}
		
		/* 3. initialize a queue, offering courses with zero degree */
		Queue<Integer> queue = new LinkedList<>();
		for (int key : degree.keySet()) {
			if (degree.get(key) == 0) queue.offer(key);
		}
		
		/* 4. do BFS to calculate the sequence */
		ArrayList<Integer> list = new ArrayList<>();
		while (!queue.isEmpty()) {
			int course = queue.poll();
			list.add(course);
			
			if (map.containsKey(course)) {
				for (int next : map.get(course)) {
					degree.put(next, degree.get(next) - 1);
					if (degree.get(next) == 0) queue.offer(next);
				}
			}
		}
		
		/* 5. if not all courses are in list, then there exists a cycle */
		if (list.size() != degree.size()) return new int[0];
		int[] res = new int[list.size()];
		int index = 0;
		for (int num : list) res[index++] = num;
		return res;
	}

}

