import java.util.Arrays;
import java.util.Scanner;

class Node{
	Node right;
	Node left;
	String data;
}

public class Solution {
	
	public static double eval(Node pos) {
		
		if(pos.left == null) {
			return Integer.parseInt(pos.data);
		}
		
		double a = eval(pos.left);
		double b = eval(pos.right);
		
		if(pos.data.equals("*")) {
			return a*b;
		} else if(pos.data.equals("-")) {
			return a-b;
		} else if(pos.data.equals("+")) {
			return a+b;
		} 
		return a/b;

	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		for(int testCase = 1; testCase <=10; testCase++) {
			int N = Integer.parseInt(scanner.nextLine());
			
			Node[] nodes = new Node[N+1];
			for(int i=1; i<N+1; i++) {
				nodes[i] = new Node();
			}
			
			for(int i=0; i<N; i++) {
				
				String[] inputNode = scanner.nextLine().split(" ");
				int nodeId = Integer.parseInt(inputNode[0]);
				nodes[nodeId].data = inputNode[1];
				
				if(inputNode.length >= 4) {
					
					int leftId = Integer.parseInt(inputNode[2]);
					int rightId = Integer.parseInt(inputNode[3]);
					nodes[nodeId].left = nodes[leftId];
					nodes[nodeId].right = nodes[rightId];
				
				}
			}
			System.out.println("#" + testCase + " " + (int)eval(nodes[1]));
		}
	}
	
}
