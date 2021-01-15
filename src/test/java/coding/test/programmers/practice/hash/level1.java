package coding.test.programmers.practice.hash;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;

public class level1 {
    /* 완주하지 못한 선수 */

    @Test
    public void test() throws Exception {
        String p[] = {"leo", "kiki", "eden", "leo"};
        String c[] = {"kiki", "eden"};

        System.out.println(solution(p, c));
        System.out.println(solution2(p, c));
    }

    /* Array sort 사용 */
    public String solution(String[] participant, String[] completion) {
        String answer = "";
        String temp = "";

        Arrays.sort(participant);
        Arrays.sort(completion);

        int i = 0;

        while(i < completion.length){
            if(!completion[i].equals(participant[i])){
                temp = participant[i];
                break;
            }else{
                i++;
            }
        }

        if(!temp.equals("")){
            answer = temp;
        }else{
            answer = participant[participant.length-1];
        }
        return answer;
    }

    /* HashMap O(n) */
    public String solution2(String[] participant, String[] completion) {
        String answer = "";
        HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) hm.put(player, hm.getOrDefault(player, 0) + 1);
        for (String player : completion) hm.put(player, hm.get(player) - 1);
        for (String key : hm.keySet()) {
            if (hm.get(key) != 0){
                answer = key;
            }
        }
        return answer;
    }

}
