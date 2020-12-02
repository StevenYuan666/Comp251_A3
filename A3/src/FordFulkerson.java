import java.util.*;
import java.io.File;

public class FordFulkerson {
	
	//Helper function
	private static boolean hasNeighbour(ArrayList<Integer> visited, 
			Integer destination, Integer node, WGraph graph) {
		if(node == destination) {
			return true;
		}
		if(visited.contains(node)) {
			return false;
		}
		for(Edge e : graph.getEdges()) {
			Integer n1 = e.nodes[0];
			Integer n2 = e.nodes[1];
			if(n1 == node && !visited.contains(n2) && e.weight > 0) {
				ArrayList<Integer> newVisited = new ArrayList<Integer>();
				for(Integer n : visited) {
					newVisited.add(n);
				}
				newVisited.add(n1);
				boolean result = true && hasNeighbour(newVisited, destination, n2, graph);
				if(result) {
					return result;
				}
			}
		}
		return false;
	}

	public static ArrayList<Integer> pathDFS(Integer source, Integer destination, WGraph graph){
		ArrayList<Integer> path = new ArrayList<Integer>();
		/* YOUR CODE GOES HERE*/
		
		ArrayList<Integer> visited = new ArrayList<Integer>();
		ArrayList<Integer> stack = new ArrayList<Integer>();
		
		visited.add(source);
		path.add(source);
		stack.add(0, source);
		
		while(!stack.isEmpty()) {
			Integer node1 = stack.remove(0);
			Integer node2 = -1;
			int i;
			for(i = 0; i < graph.listOfEdgesSorted().size(); i ++) {
				Edge e = graph.listOfEdgesSorted().get(i);
				Integer v = e.nodes[0];
				Integer u = e.nodes[1];
				if(v == node1 && !visited.contains(u) 
						&& hasNeighbour(visited, destination, u, graph) && e.weight > 0) {
					node2 = u;
					break;
				}
			}
			if(node2 == -1) {
				if(path.get(path.size() - 1) == destination) {
					return path;
				}
				else {
					ArrayList<Integer> empty = new ArrayList<Integer>();
					return empty;
				}
			}
			else if(node2 == destination) {
				path.add(node2);
				return path;
			}
			else {
				visited.add(node2);
				path.add(node2);
				stack.add(0, node2);
			}
		}
		return path;
	} 
	
	public static String fordfulkerson( WGraph graph){
		String answer="";
		int maxFlow = 0;
		
		/* YOUR CODE GOES HERE		*/
		
		
		//use different graph to store the capacity, and residual graph
		//Initialization
		WGraph residual = new WGraph(graph);
		WGraph capacity = new WGraph(graph);
		Integer source = graph.getSource();
		Integer destination = graph.getDestination();
		for(Edge e : graph.getEdges()) {
			e.weight = 0;
		}
		
		ArrayList<Integer> path = pathDFS(source, destination, residual);
		while(path.contains(source) && path.contains(destination)) {
			
			int minimum = Integer.MAX_VALUE;
			
			for(int i = 0; i < path.size() - 1; i ++) {
				Integer node1 = path.get(i);
				Integer node2 = path.get(i + 1);
				Edge e = residual.getEdge(node1, node2);
				if(e != null && e.weight < minimum) {
					minimum = e.weight;
				}
			}
			
			for(int j = 0; j < path.size() - 1; j ++) {
				Integer node1 = path.get(j);
				Integer node2 = path.get(j + 1);
				Edge e = graph.getEdge(node1, node2);
				if(e != null) {
					graph.setEdge(node1, node2, e.weight + minimum);
				}
				else {
					e = graph.getEdge(node2, node1);
					graph.setEdge(node2, node1, e.weight - minimum);
				}
			}
			
			for(Edge edge : graph.getEdges()) {
				Integer node1 = edge.nodes[0];
				Integer node2 = edge.nodes[1];
				Edge f = graph.getEdge(node1, node2);
				Edge c = capacity.getEdge(node1, node2);
				if(f.weight <= c.weight) {
					residual.setEdge(node1, node2, c.weight - f.weight);
				}
				if(f.weight > 0) {
					Edge e = residual.getEdge(node2, node1);
				     if(e == null) {
				      Edge back = new Edge(node2, node1, f.weight);
				      residual.addEdge(back);
				     }
				     else {
				      residual.setEdge(node2, node1, f.weight);
				     }
				}
			}
			maxFlow += minimum;
			path = pathDFS(source, destination, residual);
		}
		
		answer += maxFlow + "\n" + graph.toString();	
		return answer;
	}
	

	 public static void main(String[] args){
		 
		 String file = args[0];
		 File f = new File(file);
		 WGraph g = new WGraph(file);
	         System.out.println(fordfulkerson(g));
	 }
}

