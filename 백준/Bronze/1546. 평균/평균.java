import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		double[] num = new double[N];
		for(int i=0; i<N; i++) {
			num[i] = scanner.nextDouble();
		}
		
		double max = -1;
		for(int i=0; i<N; i++) {
			if(max < num[i]) {
				max = num[i];
			}
		}
		
		double sum = 0;
		for(int i=0; i<N; i++) {
			num[i] = num[i]/max * 100;
			sum+=num[i];
		}
		double avg = 0;
		avg = sum / N;
		System.out.println(avg);
	}
}