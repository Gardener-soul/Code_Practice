import java.util.Scanner;

public class Main {
	
	static int cnt;
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int T = scanner.nextInt();
		for(int testCase = 1; testCase <=T; testCase ++) {
			
			cnt = 0;
			String s = scanner.next();
			
			System.out.print(isPalindrome(s) + " " + cnt);
			System.out.println();
		}
		
	}
	
	public static int recursion(String s, int l, int r){
        cnt++;
		
		if(l >= r) return 1;
        else if(s.charAt(l) != s.charAt(r)) return 0;
        else return recursion(s, l+1, r-1);
    }
	
    public static int isPalindrome(String s){
        return recursion(s, 0, s.length()-1);
    }
	
}