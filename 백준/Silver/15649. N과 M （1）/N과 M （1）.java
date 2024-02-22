import java.util.Scanner;

public class Main {

    static int N,M;
    static int[] arr, res;
    static boolean[] chk;

    public static void perm(int idx){
        if(idx==M){
            for(int i=0; i<M; i++){
                System.out.print(res[i] + " ");
            }
            System.out.println();
            return;
        }

        for(int i=0; i<N; i++){
            if(chk[i]) continue;

            res[idx] = arr[i];
            chk[i] = true;
            perm(idx+1);
            chk[i] = false;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        N = scanner.nextInt();
        M = scanner.nextInt();
        arr = new int[N];
        res = new int[M];
        chk = new boolean[N];

        for(int i=0; i<N; i++){
            arr[i] = i+1;
        }

        perm(0);
    }
}
