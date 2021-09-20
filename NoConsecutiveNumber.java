
import java.util.*;

public class NoConsecutiveNumber {
    public static void main(String[] args) {
        Solution2 solution = new Solution2();
        int[] arr = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(solution.solution(arr));
    }
}

class Solution {
    public int[] solution(int[] arr) {
        //배열 갯수 찾기
        //count = 배열 길이(중복되지 않는 수의 갯수)
        int count = 1; //arr의 첫번째 숫자는 무조건 answer에 들어감으로 count 1로 시작
       //뒤의 숫자가 앞의 숫자랑 다르면 count++
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                count++;
            }
        }
        //count 수만큼 answer배열 만듬
        int[] answer = new int[count];
        //arr의 첫번째 수는 무조건 answer에 들어감
        answer[0] = arr[0];
        int temp = 1;
        //arr의 뒤의 숫자가 앞의 숫자랑 다르면 answer에 넣음
        //answer은 이미 하나의 숫자(arr의 젤 앞의 숫자)가 들어가 있으므로
        //answer[1]부터 시작
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                answer[temp] = arr[i];
                temp++;
            }
        }
        return answer;
    }
}

class Solution2{
    public int[] solution(int[] arr){
        ArrayList<Integer> tempList = new ArrayList<>();
        //arr안의 수는 무조건 0~9사이임
        //tempNum=10으로 해서, arr의 첫번째 수는 무조건 리스트에 들어가게함
        int tempNum =10;
        for(int num : arr){
            //두번째수가 첫번째수랑 다르면~
            if(num!=tempNum){
                tempList.add(num);
                //tempNum을 첫번째수로 바꿈
                tempNum=num;
            }
        }

        //tempList의 크기만한 answer배열을 만듬
        int[] answer = new int[tempList.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=tempList.get(i);
        }
        return answer;
    }
}