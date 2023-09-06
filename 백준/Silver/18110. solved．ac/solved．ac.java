import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); //난이도 의견의 개수
		int[] arr = new int[n];
		
		for(int i=0; i<n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		Arrays.sort(arr); //크기순 정렬
		
		int cnt = (int) Math.round(n*0.15);
		
		double sum = 0;
		for(int i=cnt; i<n-cnt; i++) {
			sum+=arr[i];
		}
		
		System.out.println((int) Math.round(sum / (n-cnt*2)));
	} //main
}
