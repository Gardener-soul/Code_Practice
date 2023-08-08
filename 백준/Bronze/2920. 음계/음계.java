import java.util.Scanner;

public class Main {
 
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int[] doremi = new int[8];
		for(int i=0; i<8; i++) {
			doremi[i]=sc.nextInt();
		} //doremi배열 생성
		
		int asc=0;
		int des=0;
		for(int i=1; i<8; i++) {
			if(doremi[i-1]-doremi[i]==-1) {
				asc++;
			} else if(doremi[i-1]-doremi[i]==1) {
				des++;
			}
		}
		
		if(asc==7) {
			System.out.println("ascending");
		} else if(des==7) {
			System.out.println("descending");
		} else {System.out.println("mixed");}
	}
}