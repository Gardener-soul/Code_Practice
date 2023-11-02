import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int K = Integer.parseInt(st.nextToken()); // 가지고 있는 랜선의 개수
		int N = Integer.parseInt(st.nextToken()); // 잘라야 하는 랜선의 수
		
		int[] arr = new int[K];
		
		long max = 0;
		for(int i=0; i<K; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(max<arr[i]) max = arr[i];
		}
		max++;
		
		long min = 0;
		long mid = 0;
		while(min<max) { // min이 max보다 커지기 전까지 구한다.
			
			// 범위 내에서 중간 길이를 구한다.
			mid=(min+max)/2;
			
			long cnt = 0;
			
			// 이분 탐색에서 사용하는 값은 중간값.
			for(int i=0; i<K; i++) {
				cnt+=(arr[i]/mid);
			}
			
			/* Upper Bound 형식 (이분 탐색에는 2개 있음)
			 * 
			 * cnt보다 N이 작다면, 자르고자 하는 길이를 줄여야함. (더 짧게 잘라야함)
			 * max 값을 줄여서 mid값을 낮춘다.
			 * 그게 아니라면, 최솟값을 mid 값보다 하나 더 올려서 mid 값을 높인다.
			 * */
			if(cnt<N) {
				max = mid;
			} else {
				min = mid +1;
			}
		}
		//upper bound에서 얻어진 값의 -1이 구하고자 하는 랜선의 최대 길이가 된다.
		System.out.println(min-1);
	}
}