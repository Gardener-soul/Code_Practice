import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int tc = 1; tc<=T; tc++) {
			Queue<Integer> num = new LinkedList<>();
			Queue<Integer> idx = new LinkedList<>();
			int N = scanner.nextInt(); // 큐들의 길이
			int D = scanner.nextInt(); // 인덱스의 위치
			
			int cnt = 0;
			
			for(int i=0; i<N; i++) {
				num.offer(scanner.nextInt());
				idx.offer(i);
			}
			
			while(num.size()!=0) {
				int max = Collections.max(num);
				int a = num.peek();
				int d = idx.peek();
				
				if(max==a&&d==D) {
					cnt++;
					break;
				} else if(max==a&&d!=D){
					
					num.poll();
					idx.poll();
					cnt++;
					
				} else {
					
					num.offer(num.poll());
					idx.offer(idx.poll());
					
				}
			}
			System.out.println(cnt);
		} //tc
	}
	
}