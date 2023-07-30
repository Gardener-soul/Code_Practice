import java.util.*;

public class Main{
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
//		int N = sc.nextInt();
		int[] n = new int [28];
		int[] arr = new int[30];
		
		for(int i=0; i<28; i++) {
			n[i]+=sc.nextInt();
		}
		sc.close();
		for(int i=0; i<28; i++) {
			for(int j=1; j<=30; j++) {
				if(n[i]==j) {
					arr[j-1]+=1;
				}
			}
		}
		for(int i=0; i<arr.length; i++) {
			if(arr[i]==0) {
				System.out.println(i+1);
			}
		}
	}
}