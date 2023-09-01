import java.util.Arrays;
import java.util.Scanner;

public class Solution {

	static int[] card; //1~18
	static int[] arr1; // 규영
	static int[] arr2; // 인영
	
	static int scoreI;
	static int scoreG;
	static int win;
	static int lose;
	
	static void cardDiv(int[] arr) {
		int num=0;
		
		for(int i=0; i<18; i++) {
			for(int j=0; j<9; j++) {
				if(card[i]==arr1[j]) {
					card[i]=0;
				}
			}
		}
		
		for(int i=0; i<18; i++) {
			if(card[i]!=0) {
				arr2[num++] = card[i];
			}
		}
	}
	
	public static void perm(int idx) {
		if(idx == arr2.length) {
			//arr2가 결정.
			scoreI = 0; //인영이의 점수
			scoreG = 0; //규영이의 점수
			
			for(int i=0; i<9; i++) {
				if(arr1[i] > arr2[i]) {
					scoreG += arr1[i] + arr2[i];
				} else if (arr1[i] < arr2[i]) {
					scoreI += arr1[i] + arr2[i];
				}
			}
			
			if(scoreI>scoreG) {
				lose++;
			} else if (scoreI < scoreG) {
				win++;
			}

		}
		
		for(int i=idx; i<arr2.length; i++) {
			swap(i,idx);
			perm(idx+1);
			swap(idx,i);
		}
	}
	
	public static void swap(int a, int b) {
		int tmp = arr1[a];
		arr1[a] = arr1[b];
		arr1[b] = tmp;
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase <= T; testCase++) {
			card = new int[] {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18};
			arr1 = new int[9]; // 규영이의 카드 배열
			arr2 = new int[9]; // 인영이의 카드배열
			win = lose = 0;
			
			for(int i=0; i<9; i++) {
				arr1[i] = scanner.nextInt();
			} 
			
			cardDiv(arr1); //카드 나누는 메소드 생성 완료 ->arr2나옴
			perm(0);
						
			System.out.println("#" + testCase + " " + win + " " + lose);
			
		} //tc
		
	} //main

}