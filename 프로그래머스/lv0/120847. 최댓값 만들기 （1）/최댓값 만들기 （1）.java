import java.util.Arrays;

class Solution {
    public int solution(int[] numbers) {
        int answer = 0;
        Arrays.sort(numbers);
        
        answer=numbers[numbers.length-1]*numbers[numbers.length-2];
        
        return answer;
    }
}
/*
<정렬>
1. 버블 정렬
2. 선택 정렬
----------- n2
3. 힙 정렬(tree)
4. 퀵 정렬 (nlogn n2 / 아 이런게 있구나 아 그렇구나 합병정렬 해야지)
5. 합병 정렬(병합 정렬)
---------- nlogn


5 | 4  |8 | 7 | 1 | 2 | 8 | 9
4 5 | 7 8
4 5 7 8 | 1 2 8 9
1 2 4 5 7 8 8 9

시간 제약

시간 복잡도 BigO
for(int i = 0; i < 5; i++) 5번
n번

최고차항의 차수
n2 + n => n2
2n => 
n n2 n3 longn nlogn

정렬: 5 4 3 2 1
4 3 2 1 5

for(int i = 0; i < n; i++){
    for(int j = 0; j < n - 1; j++){
        if(arr[j] > arr[j + 1]){
            int tmp = arr[j];
            arr[j] = arr[j + 1];
            arr[j + 1] = tmp;
        }
}
}*/