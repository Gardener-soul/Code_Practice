import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String str = scanner.next();
		int[] al = new int[26];
		str = str.toUpperCase();
		
		for(int i=0; i<str.length(); i++) {
			char s = str.charAt(i);
			
			al[s-'A']++;
		}
		
		int max=-1;
		char ch = '?';
		for(int i=0; i<26; i++) {
			if(max<al[i]) {
				max = al[i];
				ch = (char)(i + 'A');
			} 
			else if (al[i]==max) {
				ch='?';
			}
		}
		System.out.println(ch);
	}
}
