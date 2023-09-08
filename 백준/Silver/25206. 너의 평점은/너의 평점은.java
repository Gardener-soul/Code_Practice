import java.util.HashMap;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		String[][] arr = new String[20][2];
		HashMap<String,Double> map = new HashMap<String,Double>();

		map.put("A+", 4.5);
		map.put("A0", 4.0);
		map.put("B+", 3.5);
		map.put("B0", 3.0);
		map.put("C+", 2.5);
		map.put("C0", 2.0);
		map.put("D+", 1.5);
		map.put("D0", 1.0);
		map.put("F", 0.0);
		
		for(int i=0; i<20; i++) {
			scanner.next();
			arr[i][0] = scanner.next();
			arr[i][1] = scanner.next();
		}

		double hak = 0;
		double sum = 0;
		
		for(int i=0; i<20; i++) {
			if(!arr[i][1].equals("P")) {
				hak+=(map.get(arr[i][1]) * Double.parseDouble(arr[i][0]));
				sum+=Double.parseDouble(arr[i][0]);
			}
		}
		hak = hak/sum;
		System.out.printf("%.6f", hak);
	}
}