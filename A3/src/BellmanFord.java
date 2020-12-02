import java.util.*;

public class BellmanFord{

    private int[] distances = null;
    private int[] predecessors = null;
    private int source;

    class BellmanFordException extends Exception{
        public BellmanFordException(String str){
            super(str);
        }
    }

    class NegativeWeightException extends BellmanFordException{
        public NegativeWeightException(String str){
            super(str);
        }
    }

    class PathDoesNotExistException extends BellmanFordException{
        public PathDoesNotExistException(String str){
            super(str);
        }
    }

    BellmanFord(WGraph g, int source) throws NegativeWeightException{
        /* Constructor, input a graph and a source
         * Computes the Bellman Ford algorithm to populate the
         * attributes 
         *  distances - at position "n" the distance of node "n" to the source is kept
         *  predecessors - at position "n" the predecessor of node "n" on the path
         *                 to the source is kept
         *  source - the source node
         *
         *  If the node is not reachable from the source, the
         *  distance value must be Integer.MAX_VALUE
         */
    	
    	//Part of Initialization
    	this.source = source;
    	this.distances = new int[g.getNbNodes()];
    	for(int i = 0; i < distances.length; i++) {
    		//If directly set to MAX, it would mess the relaxing process up
    		this.distances[i] = 100000000;
    	}
    	distances[source] = 0;
    	
    	this.predecessors = new int[g.getNbNodes()];
    	//set -1 as Nil
    	for(int i = 0; i < predecessors.length; i ++) {
    		this.predecessors[i] = -1;
    	}
    	
    	//main part of the BellmanFord algorithm
    	for(int i = 0; i < g.getNbNodes() - 1; i ++) {
    		for(Edge e : g.getEdges()) {
    			Integer u = e.nodes[0];
    			Integer v = e.nodes[1];
    			//relaxing an edge
    			if (distances[v] > distances[u] + e.weight) {
    				distances[v] = distances[u] + e.weight;
    				predecessors[v] = u;
    			}
    		}
    	}
    	for(Edge e : g.getEdges()) {
    		Integer u = e.nodes[0];
    		Integer v = e.nodes[1];
    		if(distances[v] > distances[u] + e.weight) {
    			throw new NegativeWeightException("You have reachable negative-weight cycles");
    		}
    	}
    	for(int i = 0; i < distances.length; i ++){
    		if(this.distances[i] == 100000000) {
        		this.distances[i] = Integer.MAX_VALUE;
    		}
    	}
    }

    public int[] shortestPath(int destination) throws PathDoesNotExistException{
        /*Returns the list of nodes along the shortest path from 
         * the object source to the input destination
         * If not path exists an Error is thrown
         */
    		ArrayList<Integer> path = new ArrayList<Integer>();
    		path.add(destination);
    		int cur = destination;
    		while(path.get(0) != this.source) {
    			if(cur != -1) {
    				path.add(0, this.predecessors[cur]);
        			cur = this.predecessors[cur];
    			}
    			else {
    				throw new PathDoesNotExistException("The Shortest path to such destination does not exist");
    			}
    		}
    		int[] result = new int[path.size()];
    		for(int i = 0; i < result.length; i ++) {
    			result[i] = path.get(i);
    		}
    		return result;
    }

    public void printPath(int destination){
        /*Print the path in the format s->n1->n2->destination
         *if the path exists, else catch the Error and 
         *prints it
         */
        try {
            int[] path = this.shortestPath(destination);
            for (int i = 0; i < path.length; i++){
                int next = path[i];
                if (next == destination){
                    System.out.println(destination);
                }
                else {
                    System.out.print(next + "-->");
                }
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }

    public static void main(String[] args){

        String file = args[0];
        WGraph g = new WGraph(file);
        try{
            BellmanFord bf = new BellmanFord(g, g.getSource());
            bf.printPath(g.getDestination());
        }
        catch (Exception e){
            System.out.println(e);
        }

   }
    
   //helper method for the tester
   public int[] getDistances() {
	   return this.distances;
   }
   public int[] getPredecessors() {
	   return this.predecessors;
   }
}

