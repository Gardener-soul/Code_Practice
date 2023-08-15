import java.util.Scanner;
 
public class Solution {
    public static void main(String[] args) {
         
//      File file = new File("src/input.txt");
//      Scanner scanner = new Scanner(file);
         
        Scanner scanner = new Scanner(System.in);
         
        for(int testCase = 1; testCase<=10; testCase++) {
            char[][] map = new char[100][100];
            scanner.nextInt();//의미없는 tc 번호
            for(int i=0; i<100; i++) {
                map[i]=scanner.next().toCharArray();
            } //map 배열 생성 완료 // 담김 확인 완료
             
            //행 구하기, 범위 설정 어떻게?
            int rmax = -1;
            for(int len=100; len>0; len--) {
                for(int i=0; i<100; i++) {
                    for(int j=0; j<100-len+1; j++) {
                        StringBuilder sb = new StringBuilder();
                        for(int k=0; k<len; k++) {
                            sb.append(map[i][j+k]);
                        }
                        String str1 = String.valueOf(sb);
                        sb.reverse();
                        String str2 = String.valueOf(sb);
                        if(str1.equals(str2)&&rmax < str1.length()) {
                            rmax = str1.length();
                        }
                    }
                }
            }
             
            int cmax = -1;
            for(int len=100; len>0; len--) {
                for(int j=0; j<100; j++) {
                    for(int i=0; i<100-len+1; i++) {
                        StringBuilder sb = new StringBuilder();
                        for(int k=0; k<len; k++) {
                            sb.append(map[i+k][j]);
                        }
                        String str3 = String.valueOf(sb);
                        sb.reverse();
                        String str4 = String.valueOf(sb);
                        if(str3.equals(str4)&&cmax < str3.length()) {
                            cmax = str3.length();
                        }
                    }
                }
            }
        System.out.println("#" + testCase + " " + Math.max(rmax,cmax));
        } //testCase
    }//main
}
