import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;

public class Tester {
	static int FF;
	static int BF;

	public static void main(String[] args) {
		
		//Tests of DFS
		System.out.println("-----Starting the tester for pathDFS function in FordFulkerson class-----");
		pathDFSTest1();
		pathDFSTest2();
		pathDFSTest3();
		pathDFSTest4();
		pathDFSTest5();
		pathDFSTest6();
		//Tests for FF
		System.out.println("-----Starting the tester for fordfulkerson function in FordFulkerson class-----");
		fordfulkersonTest1();
		fordfulkersonTest2();
		fordfulkersonTest3();
		fordfulkersonTest4();
		System.out.println("-----Complete the tester for the FordFulkerson class. Total Points : Pts " + FF + " / 10" + "-----");
		//Tests for BF
		System.out.println("-----Starting the tester for BellmanFord function in BellmanFord class-----");
		bellmanfordTest1();
		bellmanfordTest2();
		bellmanfordTest3();
		bellmanfordTest4();
		bellmanfordTest5();
		System.out.println("-----Starting the tester for shortestPath function in BellmanFord class-----");
		shortestpathTest1();
		shortestpathTest2();
		shortestpathTest3();
		shortestpathTest4();
		shortestpathTest5();
		System.out.println("-----Complete the tester for the BellmanFord class. Total Points : Pts " + BF + " / 10" + "-----");
	}

	
	public static void pathDFSTest1() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/ff2.txt";
		WGraph g = new WGraph(file);
		for(Edge e : g.getEdges()) {
			Integer node1 = e.nodes[0];
			Integer node2 = e.nodes[1];
			g.setEdge(node1, node2, 0);
		}
		ArrayList<Integer> path = FordFulkerson.pathDFS(g.getSource(), g.getDestination(), g);
		if(path.size() == 0) {
			FF ++;
			System.out.println("FordFulkerson.pathDFS Test1 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.pathDFS Test1 failed. Pts 0 / 1");
		}
	}
	
	public static void pathDFSTest2() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/ff2.txt";
		WGraph g = new WGraph(file);
		ArrayList<Integer> path = FordFulkerson.pathDFS(g.getSource(), g.getDestination(), g);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(3);
		result.add(5);
		if(path.equals(result)) {
			FF ++;
			System.out.println("FordFulkerson.pathDFS Test2 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.pathDFS Test2 failed. Pts 0 / 1");
		}
	}
	
	public static void pathDFSTest3() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/ff2.txt";
		WGraph g = new WGraph(file);
		g.setEdge(0, 1, 4);
		g.setEdge(1, 3, 0);
		g.setEdge(3, 5, 8);
		ArrayList<Integer> path = FordFulkerson.pathDFS(g.getSource(), g.getDestination(), g);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(2);
		result.add(4);
		result.add(3);
		result.add(5);
		if(path.equals(result)) {
			FF ++;
			System.out.println("FordFulkerson.pathDFS Test3 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.pathDFS Test3 failed. Pts 0 / 1");
		}
	}

	public static void pathDFSTest4() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/ff2.txt";
		WGraph g = new WGraph(file);
		g.setEdge(0, 1, 0);
		g.setEdge(1, 3, 0);
		g.setEdge(3, 5, 0);
		ArrayList<Integer> path = FordFulkerson.pathDFS(g.getSource(), g.getDestination(), g);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(2);
		result.add(4);
		result.add(5);
		if(path.equals(result)) {
			FF ++;
			System.out.println("FordFulkerson.pathDFS Test4 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.pathDFS Test4 failed. Pts 0 / 1");
		}
	}
	
	public static void pathDFSTest5() {
		WGraph g = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/ll.txt");
		ArrayList<Integer> path = FordFulkerson.pathDFS(g.getSource(), g.getDestination(), g);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(2);
		result.add(4);
		result.add(5);
		if(path.equals(result)) {
			FF ++;
			System.out.println("FordFulkerson.pathDFS Test5 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.pathDFS Test5 failed. Pts 0 / 1");
		}
	}
	
	public static void pathDFSTest6() {
		WGraph g = new WGraph("/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/mm.txt");
		ArrayList<Integer> path = FordFulkerson.pathDFS(g.getSource(), g.getDestination(), g);
		ArrayList<Integer> result = new ArrayList<Integer>();
		result.add(0);
		result.add(1);
		result.add(3);
		result.add(5);
		if(path.equals(result)) {
			FF ++;
			System.out.println("FordFulkerson.pathDFS Test6 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.pathDFS Test6 failed. Pts 0 / 1");
		}
	}
	
	//helper function to read from text file
	public static String take(File file){
		String result = "";
		try{
				BufferedReader br = new BufferedReader(new FileReader(file));
				String s = null;
				s = br.readLine();
				while(s !=null){
					String tmp = s;
					s = br.readLine();
					if(s != null) {
						result = result + tmp + "\n";
					}
					else {
						result = result + tmp;
					}
					
				}
				br.close();    
		}
		catch(Exception e){
			e.printStackTrace();
		}
		return result;
	}

	
	public static void fordfulkersonTest1() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/FFtest1.txt";
		WGraph g = new WGraph(file);
		String file2 = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/FFtest1out.txt";
		File result = new File(file2);
		String input = FordFulkerson.fordfulkerson(g);
		String output = take(result);
		if(input.equals(output)) {
			FF ++;
			System.out.println("FordFulkerson.fordfulkerson Test1 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.fordfulkerson Test1 failed. Pts 0 / 1");
		}
	}
	
	public static void fordfulkersonTest2() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/FFtest2.txt";
		WGraph g = new WGraph(file);
		String file2 = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/FFtest2out.txt";
		File result = new File(file2);
		String input = FordFulkerson.fordfulkerson(g);
		String output = take(result);
		if(input.equals(output)) {
			FF ++;
			System.out.println("FordFulkerson.fordfulkerson Test2 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.fordfulkerson Test2 failed. Pts 0 / 1");
		}
	}
	
	public static void fordfulkersonTest3() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/FFtest3.txt";
		WGraph g = new WGraph(file);
		String file2 = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/FFtest3out.txt";
		File result = new File(file2);
		String input = FordFulkerson.fordfulkerson(g);
		String output = take(result);
		if(input.equals(output)) {
			FF ++;
			System.out.println("FordFulkerson.fordfulkerson Test3 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.fordfulkerson Test3 failed. Pts 0 / 1");
		}
	}
	
	public static void fordfulkersonTest4() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/FFtest4.txt";
		WGraph g = new WGraph(file);
		String file2 = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/FFtest4out.txt";
		File result = new File(file2);
		String input = FordFulkerson.fordfulkerson(g);
		String output = take(result);
		if(input.equals(output)) {
			FF ++;
			System.out.println("FordFulkerson.fordfulkerson Test4 passed. Pts 1 / 1");
		}
		else {
			System.out.println("FordFulkerson.fordfulkerson Test4 failed. Pts 0 / 1");
		}
	}
	
	//这个还需要修改
	public static void bellmanfordTest1() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf1.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord result = new BellmanFord(g, 0);
			BF ++;
			System.out.println("BellmanFord.BellmanFord Test1 passed. Pts 1 / 1");
		} 
		catch (Exception e) {
			System.out.println("BellmanFord.BellmanFord Test1 failed. Pts 0 / 1");
		}
	}
	
	public static void bellmanfordTest2() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf2.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord result = new BellmanFord(g, 0);
			int[] d = {0, 3, -4};
			int[] pi = {-1, 2, 0};
			if(Arrays.equals(result.getDistances(), d) && 
					Arrays.equals(result.getPredecessors(), pi)) {
				BF ++;
				System.out.println("BellmanFord.BellmanFord Test2 passed. Pts 1 / 1");
			}
			else {
				System.out.println("BellmanFord.BellmanFord Test2 failed. Pts 0 / 1");
			}
		} 
		catch (Exception e) {
			System.out.println("BellmanFord.BellmanFord Test2 failed. Pts 0 / 1");
		}
	}
	
	public static void bellmanfordTest3() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf3.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord result = new BellmanFord(g, 0);
			/*
			for(int i = 0; i < result.getDistances().length; i ++) {
				System.out.println(result.getDistances()[i]);
			}
			for(int i = 0; i < result.getPredecessors().length; i ++) {
				System.out.println(result.getPredecessors()[i]);
			}
			*/
			System.out.println("BellmanFord.BellmanFord Test3 failed. Pts 0 / 1");
		} 
		catch (Exception e) {
			BF ++;
			System.out.println("BellmanFord.BellmanFord Test3 passed. Pts 1 / 1");
		}
	}
	
	public static void bellmanfordTest4() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf1.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord result = new BellmanFord(g, 8);
			int max = Integer.MAX_VALUE;
			int[] d = {max, max, max, max, max, max, max, max, 0};
			int[] p = {-1, -1, -1, -1, -1, -1, -1, -1, -1};
			if(Arrays.equals(result.getDistances(), d)
					&& Arrays.equals(result.getPredecessors(), p)) {
				BF ++;
				System.out.println("BellmanFord.BellmanFord Test4 passed. Pts 1 / 1");
			}
			else {
				System.out.println("BellmanFord.BellmanFord Test4 failed. Pts 0 / 1");
			}
		} 
		catch (Exception e) {
			System.out.println("BellmanFord.BellmanFord Test4 failed. Pts 0 / 1");
		}
	}
	
	public static void bellmanfordTest5() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf1.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord result = new BellmanFord(g, 3);
			int max = Integer.MAX_VALUE;
			int[] d = {max, max, max, 0, 7, 10, 11, 5, 13};
			int[] p = {-1, -1, -1, -1, 3, 4, 3, 3, 6};
			if(Arrays.equals(result.getDistances(), d)
					&& Arrays.equals(result.getPredecessors(), p)) {
				BF ++;
				System.out.println("BellmanFord.BellmanFord Test5 passed. Pts 1 / 1");
			}
			else {
				System.out.println("BellmanFord.BellmanFord Test5 failed. Pts 0 / 1");
			}
		} 
		catch (Exception e) {
			System.out.println("BellmanFord.BellmanFord Test5 failed. Pts 0 / 1");
		}
	}
	
	public static void shortestpathTest1() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf1.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord bb = new BellmanFord(g, 5);
			try {
				int[] result = bb.shortestPath(6);
			}
			catch(Exception ee) {
				BF ++;
				System.out.println("BellmanFord.shortestPath Test1 passed. Pts 1 / 1");
			}
		} 
		catch (Exception e) {
			System.out.println("BellmanFord.shortestPath Test1 failed. Pts 0 / 1");
		}
	}
	
	public static void shortestpathTest2() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf1.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord bb = new BellmanFord(g, 2);
			try {
				int[] result = bb.shortestPath(8);
				int[] path = {2, 5, 7, 8};
				if(Arrays.equals(result, path)) {
					BF ++;
					System.out.println("BellmanFord.shortestPath Test2 passed. Pts 1 / 1");
				}
				else {
					System.out.println("BellmanFord.shortestPath Test2 failed. Pts 0 / 1");
				}
			}
			catch(Exception ee) {
				System.out.println("BellmanFord.shortestPath Test2 failed. Pts 0 / 1");
			}
		} 
		catch (Exception e) {
			System.out.println("BellmanFord.shortestPath Test2 failed. Pts 0 / 1");
		}
	}
	
	public static void shortestpathTest3() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf1.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord bb = new BellmanFord(g, 1);
			try {
				int[] result = bb.shortestPath(7);
				int[] path = {1, 3, 7};
				if(Arrays.equals(result, path)) {
					BF ++;
					System.out.println("BellmanFord.shortestPath Test3 passed. Pts 1 / 1");
				}
				else {
					System.out.println("BellmanFord.shortestPath Test3 failed. Pts 0 / 1");
				}
			}
			catch(Exception ee) {
				System.out.println("BellmanFord.shortestPath Test3 failed. Pts 0 / 1");
			}
		} 
		catch (Exception e) {
			System.out.println("BellmanFord.shortestPath Test3 failed. Pts 0 / 1");
		}
	}
	
	public static void shortestpathTest4() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf1.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord bb = new BellmanFord(g, 1);
			try {
				int[] result = bb.shortestPath(5);
				int[] path = {1, 2, 5};
				if(Arrays.equals(result, path)) {
					BF ++;
					System.out.println("BellmanFord.shortestPath Test4 passed. Pts 1 / 1");
				}
				else {
					System.out.println("BellmanFord.shortestPath Test4 failed. Pts 0 / 1");
				}
			}
			catch(Exception ee) {
				System.out.println("BellmanFord.shortestPath Test4 failed. Pts 0 / 1");
			}
		} 
		catch (Exception e) {
			System.out.println("BellmanFord.shortestPath Test4 failed. Pts 0 / 1");
		}
	}
	
	public static void shortestpathTest5() {
		String file = "/Users/stevenyuan/Documents/McGill/U1/2020fall/Comp251/Assignment/Comp251_A3/A3/src/bf1.txt";
		WGraph g = new WGraph(file);
		try {
			BellmanFord bb = new BellmanFord(g, 7);
			try {
				int[] result = bb.shortestPath(1);
			}
			catch(Exception ee) {
				BF ++;
				System.out.println("BellmanFord.shortestPath Test5 passed. Pts 1 / 1");
			}
		} 
		catch (Exception e) {
			System.out.println("BellmanFord.shortestPath Test5 failed. Pts 0 / 1");
		}
	}
}
