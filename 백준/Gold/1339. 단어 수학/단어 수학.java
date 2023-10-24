import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<n; i++) {
			// Char 배열을 선언하여, 읽어온 String들을 char배열에 넣어놓음.
			char[] ch = br.readLine().toCharArray();
			// 반복문의 읽는 방식을 큰 숫자부터 작은 숫자까지 가도록 함. (제곱을 위해서)
			for(int j=ch.length-1; j>=0; j--) {
				//pow 값을 줌, 자릿값에 해당하는 숫자부터 하나씩 깎는다.
				int pow = (int)Math.pow(10, ch.length-1-j);
				// getOrDefault : (A,B) A가 있다면 Default 값을 설정.
				map.put(ch[j]-'A', map.getOrDefault(ch[j]-'A', 0)+pow);
			}
		}
		
		// map.keySet : Map의 KEY 값을 다 keyList에 넣음.
		List<Integer> keyList = new ArrayList<>(map.keySet());
		// 크기순으로 정렬
		Collections.sort(keyList, (o1,o2) -> (map.get(o1) - map.get(o2)));
		
		int total=0;
		// 9부터 시작하지만, 작은 숫자부터 하나씩 더해주기 위해 초기 num값을 설정
		int num = 10-map.size();  
		for(int key : keyList) {
			// Map에 해당하는 key값을 받아오고 num을 곱하고, 하나씩 더함.
			total += map.get(key)*num;
			num++;
		}
		System.out.println(total);
	}
}