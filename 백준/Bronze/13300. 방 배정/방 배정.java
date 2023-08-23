import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt(); // 수학여행에 참여하는 학생 수
		int K = scanner.nextInt(); // 한 방에 배정할 수 있는 사람 수.
		List<Integer> girl = new ArrayList<>();
		List<Integer> boy = new ArrayList<>();
		
		for(int i=0; i<N; i++) { //성별에 따라 값을 다르게 받고,
			int s=scanner.nextInt(); //성별 숫자를 하나 받고
			if(s==0) { // 그 숫자에 따라 여자 배열에 넣을지, 남자 배열에 넣을지 결정.
				girl.add(scanner.nextInt());
			} else if (s==1) {
				boy.add(scanner.nextInt());
			}
		} //배열 입력완료
		
		int[] gcnt = new int[7];
		int[] bcnt = new int[7];
		
		for(int i=1; i<7; i++) {
			for(int j=0; j<girl.size(); j++) {
				if(i==girl.get(j)) {
					gcnt[i]++;
				}
			}
		}
		for(int i=1; i<7; i++) {
			for(int j=0; j<boy.size(); j++) {
				if(i==boy.get(j)) {
					bcnt[i]++;
				}
			}
		}

		int room = 0;
		for(int i=1; i<7; i++) {
			if(gcnt[i]%2==1) {
				room+=gcnt[i]/2+1;
			} else if (gcnt[i]%2==0) {
				room+=gcnt[i]/2;
			}
		}
		for(int i=1; i<7; i++) {
			if(bcnt[i]%2==1) {
				room+=bcnt[i]/2+1;
			} else if (bcnt[i]%2==0) {
				room+=bcnt[i]/2;
			}
		}
		System.out.println(room);
	}//main
}