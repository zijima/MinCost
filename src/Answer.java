import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Answer {
	static int nodeCount = 10000;
	static int arcCount = 0;
	static String supply = "23";
	static String demand = "-23";
	static String lastNode = "20001";
	static String overallNode = "20002";
	static List<String> list = null;
	public static void main(String[] args) {
		list = new ArrayList<String>();
		
		addNodeInfo();
		
		addArcInfo();
		
		addOverallInfo();
		try{
			// Create file 
			FileWriter fstream = new FileWriter("sample.inp");
			BufferedWriter out = new BufferedWriter(fstream);
			for (String string : list) {
				out.write(string);
				out.write("\n");
			}
			//Close the output stream
			out.close();
		}catch (Exception e){//Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
	}
	//c arc has <tail> <head> <capacity l.b.> <capacity u.b> <cost>
	//a 1 2 0 4  1
	private static void addArcInfo() {
		String arcInfo = "";
		//source node to each node
		for (int i = 1; i <= nodeCount; i++) {
			arcInfo = "a " + 0 + " " + i + " 0" + " 1" + " -1";
			list.add(arcInfo);
			arcCount++;
		}
		
		//each node to sink node
		for (int i = 1; i <= nodeCount; i++) {
			arcInfo = "a " + Integer.toString(i + 10000) + " " + lastNode + " 0" + " 1" + " 0";
			list.add(arcInfo);
			arcCount++;
		}
		
		//arc between copied node
		for (int i = 1; i <= nodeCount; i++) {
			arcInfo = "a " + i + " " + Integer.toString(i + 10000) + " 0" + " 1" + " 0";
			list.add(arcInfo);
			arcCount++;
		}
		
		//arc between node i and j if i divides j
		for (int i = 1; i <= nodeCount; i++) {
			for (int j = i + 1; j <= nodeCount; j++) {
				if(j % i == 0){
					arcInfo = "a " + Integer.toString(i + 10000) + " " + j + " 0" + " 1" + " -1";
					list.add(arcInfo);
					arcCount++;
				}
			}
		}
	}
	private static void addNodeInfo() {
		String source = "n 0 " + supply;
		String sink = "n " + lastNode + " " + demand;
		list.add(source);
		list.add(sink);
		String nodeInfo = "";
		for (int i = 1; i <= nodeCount * 2; i++) {
			nodeInfo = "n " + i + " 0";
			list.add(nodeInfo);
		}
	}
	private static void addOverallInfo() {
		String overall = "p min " + overallNode + " " + arcCount;
		list.add(0, overall);
	}
}
