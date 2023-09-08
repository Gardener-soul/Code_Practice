import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		String[] cro = {"dz=","c=", "c-","d-","lj","nj","s=","z="};
		Scanner scanner = new Scanner(System.in);
		String al = scanner.next();
		int cnt = al.length();
		
//		if(al.contains("dz=")) {
//			al = al.replace("dz=","o");
//		}
		
		for(int i=0; i<cro.length; i++) {
			if(al.contains(cro[i])) {
				al = al.replace(cro[i], "o");
			}
		}
		
		System.out.println(al.length());
	}
	
}