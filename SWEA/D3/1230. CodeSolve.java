import java.util.LinkedList;
import java.util.Scanner;
 
public class Solution {
 
    public static void main(String[] args) {
         
        Scanner scanner = new Scanner(System.in);
        for(int testCase = 1; testCase <= 10; testCase++) {
            LinkedList<Integer> list = new LinkedList<>();
            int N = scanner.nextInt(); //원본 암호문의 길이 (정답을 이만큼만 출력하세요~)
             
            for(int i=0; i<N; i++) {
                list.add(scanner.nextInt());
            } // 현재 최초 암호문 생성 완료
             
            int C = scanner.nextInt();//암호문의 개수
            for(int c=0; c<C; c++) { //C만큼 들어오는 ,,
                String how = scanner.next(); //의미 없는 I 받기               
                if (how.equals("I")) {
                    int start = scanner.nextInt(); //시작값이 들어옴
                    int end = scanner.nextInt(); //끝값이 들어옴
                     
                    for(int i = start; i<start+end; i++) {
                        list.add(i, scanner.nextInt()); //더할 암호문
                    }
                     
                } else if (how.equals("D")) {
                    int start = scanner.nextInt(); //앞에서부터 x번째 암호문 지울거임
                    int delete = scanner.nextInt(); //삭제할 암호문 개수
                     
                    while(delete!=0) {
                        list.remove(start-1);
                        delete--;
                    }
                     
                } else if (how.equals("A")) {
                    int add = scanner.nextInt(); //몇개 암호문 덧붙일건지 입력받음
                     
                    while(add!=0){
                        list.add(scanner.nextInt()); //덧붙일 암호문
                        add--;
                    }
                }
            }
            System.out.print("#" + testCase);
            for(int i=0; i<10; i++) {
                System.out.print(" " + list.get(i));
            }
            System.out.println();
        } //tc
    } //main
}
