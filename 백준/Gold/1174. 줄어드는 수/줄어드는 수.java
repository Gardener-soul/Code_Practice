import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {

	static int N;
	static int[] nums = {9,8,7,6,5,4,3,2,1,0};
	static List<Long> arr= new ArrayList<>();
	
	public static void makeNum(long num, int idx) {
		
		if(!arr.contains(num)) arr.add(num);
		if(idx>=10) return;
		
		makeNum((num*10) + nums[idx], idx+1);
		makeNum(num, idx+1);
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		N = scanner.nextInt();
		
		makeNum(0,0);
		
		arr.sort(null);
		
		if(N>arr.size()) {
			System.out.println(-1);
		} else {
			System.out.println(arr.get(N-1));
		}
	}
}