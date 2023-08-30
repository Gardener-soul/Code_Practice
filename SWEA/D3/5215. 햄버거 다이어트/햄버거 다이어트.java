import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	static int N; // 음식 개수
	static int L; // 최대 칼로리
	static int[] kcal; //칼로리
	static int[] score; //점수
	static boolean[] chk; //chk배열
	static int max;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			
			max=-1;
			N = scanner.nextInt();
			L = scanner.nextInt();
			kcal = new int[N];
			score = new int[N];
			chk = new boolean[N];
			
			for(int i=0; i<N; i++) {
				score[i] = scanner.nextInt();
				kcal[i] = scanner.nextInt();
			}
			
			ksum(0);
			
			System.out.println("#" + testCase + " " + max);
			
		}
		
	}
	
	static void ksum(int idx) {
	
		if(idx==N) {
			int ksum = 0; // 칼로리 점수
			int sc = 0; //스코어 점수
			for(int i=0; i<N; i++) {
				if(chk[i]) {
					sc+=score[i];
					ksum+=kcal[i];
				}
			}
			
			if(ksum<=L) {
				max = Math.max(max, sc);
			}
			
			return;
		} 
		
		chk[idx] = false;
		ksum(idx+1);
		
		chk[idx] = true;
		ksum(idx+1);
		
	}
	
}