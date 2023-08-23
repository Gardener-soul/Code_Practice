import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		LinkedList<Integer> num = new LinkedList<>();
		for(int i=0; i<9; i++) {
			num.add(scanner.nextInt());
		}
		
		int sum=0;
		for(int i=0; i<9; i++) {
			sum+=num.get(i);
		}
		
all:		for(int i=0; i<8; i++) {
			for(int j=i+1; j<=8; j++) {
				if(sum-(num.get(i)+num.get(j)) == 100) {
					num.remove(num.get(i));
					num.remove(num.get(j-1));
					break all;
				}
			}
		}
		Collections.sort(num);
		for(int i=0; i<num.size(); i++) {
			System.out.println(num.get(i)+" ");
		}
	}
}