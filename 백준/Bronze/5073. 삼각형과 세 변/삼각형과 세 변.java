import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static boolean chkTri(int a, int b, int c) {
        int l = Math.max(a, Math.max(b, c)); // 가장 긴 변

        if (a == l) {
            if (l >= b + c) return false;
        } else if (b == l) {
            if (l >= a + c) return false;
        } else if (c == l) {
            if (l >= a + b) return false;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            // 종료 조건
            if (a == 0 && b == 0 && c == 0) break;

            // 삼각형 여부 확인
            if (!chkTri(a, b, c)) {
                System.out.println("Invalid");
                continue;
            }

            // 삼각형 종류 출력
            if (a == b && b == c) {
                System.out.println("Equilateral");
            } else if (a != b && a != c && b != c) {
                System.out.println("Scalene");
            } else {
                System.out.println("Isosceles");
            }
        }
    }
}
