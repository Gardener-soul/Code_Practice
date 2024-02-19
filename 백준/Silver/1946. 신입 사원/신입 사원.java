import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
1. 서류시험 / 면접시험 성적 중 적어도 하나가 다른 지원자보다 떨어지면 안됌.
2. 아 미친 성적이 아니라 순위가 주어지는 거였음;;
    1) 서류순위로 순서를 정렬함
    2) 1등의 면접 순위가 기준
    3) 그 다음, 그 면접 순위보다 높은 순위가 등장했을 때, 그 순위가 기준이 됨
    4) 반복

입력 TC / 지원자의 숫자 / 서류심사 성적, 면접 순위
* */

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int TC = Integer.parseInt(st.nextToken());

        for(int testCase = 0; testCase<TC; testCase++) {
            st = new StringTokenizer(br.readLine());
            int men = Integer.parseInt(st.nextToken());
                int[] arr = new int[men];

            for (int i = 0; i < men; i++) {
                st = new StringTokenizer(br.readLine());
                int idx = Integer.parseInt(st.nextToken());
                int res = Integer.parseInt(st.nextToken());

                arr[idx - 1] = res;
            }

            int stan = arr[0];
            int cnt = 1;
            for(int i=1; i<men; i++){
                if(arr[i]<stan) {
                    cnt++;
                    stan = arr[i];
                }
            }
            System.out.println(cnt);
        }
    }
}
