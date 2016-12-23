package Amazon.OA2;

import java.util.*;

class Connection {
	String node1;
	String node2;
	int cost;
	
	public Connection(String node1, String node2, int cost) {
		this.node1 = node1;
		this.node2 = node2;
		this.cost = cost;
	}
}

public class MinimumSpanningTree {

	private static int unionNumber;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Connection> connections = new ArrayList<>();
	    //下面的图是个苯环，中间加上了几根，如果想验证空表，去掉几根线就行。
	    connections.add(new Connection("A","B",6));
	    connections.add(new Connection("B","C",4));
	    connections.add(new Connection("C","D",5));
	    connections.add(new Connection("D","E",8));
	    connections.add(new Connection("E","F",2));
	    connections.add(new Connection("B","F",10));
	    connections.add(new Connection("E","C",9));
	    connections.add(new Connection("F","C",7));
	    connections.add(new Connection("B","E",3));
	    connections.add(new Connection("A","F",16));
	    
	    
	    ArrayList<Connection> res = findLowestPath(connections);
	    if (res.size() == 0) {
	    	System.out.println("Empty");
	    	return;
	    }
	    for (Connection c : res){
	        System.out.println(c.node1 + " -> " + c.node2 + " " + c.cost);
	    }
	}

	public static ArrayList<Connection> findLowestPath(ArrayList<Connection> connections) {
		if (connections == null || connections.size() == 0) {
			return new ArrayList<Connection>();
		}
		
		ArrayList<Connection> result = new ArrayList<>();
		/* map stores node/unionNumber pair */
		HashMap<String, Integer> map = new HashMap<>();
		
		/* sort the original connections list in ascending order */
		Collections.sort(connections, new Comparator<Connection>(){
			public int compare(Connection a, Connection b) {
				return a.cost - b.cost;
			}
		});
		
		unionNumber = 0;
		for (Connection c : connections) {
			String a = c.node1;
			String b = c.node2;
			/* check if a and b has already connected */
			if (union(map, a, b)) {
				result.add(c);
			}
		}
		
		/* check if every node belongs to one group */
		String node = connections.get(0).node1;
		int union = map.get(node);
		for (String str : map.keySet()) {
			if (map.get(str) != union) return new ArrayList<>();
		}
		
		/* finally, sort by node's name */
		Collections.sort(result, new Comparator<Connection>(){
			public int compare(Connection a, Connection b) {
				if (a.node1.equals(b.node1)) return a.node2.compareTo(b.node2);
				else return a.node1.compareTo(b.node1);
			}
		});
		
		return result;
	}
	
	/**
	 * Working like Union Find.
	 * 
	 * @param map
	 * @param a
	 * @param b
	 * @return
	 */
	private static boolean union(HashMap<String, Integer> map, String a, String b) {
		/* if both a and b are not in the map, then connect them and assign a new unionNumber */
		if (!map.containsKey(a) && !map.containsKey(b)) {
			map.put(a, unionNumber);
			map.put(b, unionNumber);
			unionNumber++;
			return true;
		}
		
		/* if only one is in the map, then add another into the same group */
		if (map.containsKey(a) && !map.containsKey(b)) {
			int AU = map.get(a);
			map.put(b, AU);
			return true;
		}
		if (!map.containsKey(a) && map.containsKey(b)) {
			int BU = map.get(b);
			map.put(a, BU);
			return true;
		}
		
		/* if both of them have group */
		int AU = map.get(a);
		int BU = map.get(b);
		
		/* if they are in the same group, return false. Because it will form a cirle */
		if (AU == BU) return false;
		
		for (String node : map.keySet()) {
			if (map.get(node) == BU) map.put(node, AU);
		}
		return true;
		
	}
}

