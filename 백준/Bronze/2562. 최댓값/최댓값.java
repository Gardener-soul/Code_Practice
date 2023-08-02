import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		List<Integer> arr = new ArrayList<>();
		for(int i=0; i<9; i++) {
			int n = sc.nextInt();
			arr.add(n);
		}
		
		int max = 0;
		
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i)>max) {
				max = arr.get(i);
			}
		}
		System.out.println(max);
		for(int i=0; i<arr.size(); i++) {
			if(arr.get(i)==max) {
				System.out.println(i+1);
			}
		}
	}
}