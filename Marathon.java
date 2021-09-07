import java.util.Arrays;
import java.util.HashMap;

public class Marathon {
    public static void main(String[] args) {
        String[] participant = {"leo", "kiki", "eden"};
        String[] completion = {"eden", "kiki"};

        Solution2 s = new Solution2();
        System.out.println(s.solution2(participant, completion));
    }

}

//Hash를 이용
class Solution {
    public String solution(String[] participant, String[] completion) {
        String answer;
        HashMap<String, Integer> hm = new HashMap<>();
        //참가선수 이름 별 hashcode를 이용하여 hashmap에 저장하려했지만, hashmap은 중복된 key값을 지원하지 않으므로 불가(동명이인 처리 불가)
        //(선수이름, 몇명)의 형태로 hashmap에 저장
        for (String participants : participant) {
            //아직 참가자이름이 hashmap에 없으면 기본값 0을 가져오고 +1, 참가자이름이 이미 hashpmap에 있다면, 그값(지금까지 몇명 있는지)+1
            hm.put(participants, hm.getOrDefault(participants, 0) + 1);
        }
        //완주한 선수들은 hashmap에서 -1한다.
        for (String completions : completion) {
            hm.put(completions, hm.get(completions) - 1);
        }
        //완주 못한 선수는 hashmap에 value값으로 1이 남을것이다.
        for (String participants : hm.keySet()) {
            if (hm.get(participants) == 1) {
                return participants;
            }
        }

        return null;

    }
}

//배열을 sort해서 다른 부분 찾기
class Solution2 {
    public String solution2(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);
        for (int i = 0; i < completion.length; i++) {
            if (!participant[i].equals(completion[i])) {
                return participant[i];
            }
        }
        //completion의 마지막 선수까지 participant 똑같으면, 결국 participant의 마지막 선수가 미완료자임.
        return participant[participant.length - 1];
    }
}
