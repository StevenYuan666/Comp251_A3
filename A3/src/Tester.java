import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

public class Tester {
	static int FF;

	public static void main(String[] args) {
		
		//Tests of DFS
		System.out.println("-----Starting the tester for pathDFS function in FordFulkerson class-----");
		pathDFSTest1();
		pathDFSTest2();
		pathDFSTest3();
		pathDFSTest4();
		pathDFSTest5();
		pathDFSTest6();
		System.out.println("-----Starting the tester for fordfulkerson function in FordFulkerson class-----");
		fordfulkersonTest1();
		fordfulkersonTest2();
		fordfulkersonTest3();
		fordfulkersonTest4();
		System.out.println("-----Complete the tester for the FordFulkerson class. Total Points : Pts " + FF + " / 10" + "-----");
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
	
}
