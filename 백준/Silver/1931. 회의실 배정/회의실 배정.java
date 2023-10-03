import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int[][] map = new int[N][2];
		int arr = 0;		
		
		for(int i=0; i<N; i++) {
						
			map[i][0] = scanner.nextInt();
			map[i][1] = scanner.nextInt();
		}
		
		Arrays.sort(map, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1]==o2[1]) {
					return o1[0] - o2[0];
				}
				return o1[1]-o2[1];
			}
			
		});
		
		int cnt = 0;
		int end = 0;
		
		for(int i=0; i<N; i++) {
			
			if(end<=map[i][0]) {
				end = map[i][1];
				cnt++;
			}
			
		}
		System.out.println(cnt);
		scanner.close();
	}
}