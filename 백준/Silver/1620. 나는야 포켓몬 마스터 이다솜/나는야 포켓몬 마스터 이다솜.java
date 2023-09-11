import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		HashMap<String, Integer> str = new HashMap<String, Integer>();
		HashMap<Integer, String> num = new HashMap<Integer, String>();
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<N+1; i++) {
			String s = br.readLine();
			
			str.put(s, i);
			num.put(i, s);
		}
	
		for(int i=0; i<M; i++) {
			
			String a = br.readLine();
			char c = a.charAt(0);
			
			if(c-'0'>=0 && c-'0'<=9) {
				sb.append(num.get(Integer.parseInt(a))+"\n");
			} else {
				sb.append(str.get(a)+"\n");
			}
			
		}
		System.out.println(sb);	
	}
}
