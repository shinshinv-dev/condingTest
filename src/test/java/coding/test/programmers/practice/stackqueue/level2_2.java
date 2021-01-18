package coding.test.programmers.practice.stackqueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class level2_2 {
    /*
	기능개발


	프로그래머스 팀에서는 기능 개선 작업을 수행 중입니다.
	각 기능은 진도가 100%일 때 서비스에 반영할 수 있습니다.

	또, 각 기능의 개발속도는 모두 다르기 때문에 뒤에 있는 기능이 앞에 있는 기능보다 먼저 개발될 수 있고,
	이때 뒤에 있는 기능은 앞에 있는 기능이 배포될 때 함께 배포됩니다.

	먼저 배포되어야 하는 순서대로 작업의 진도가 적힌 정수 배열 progresses와 각 작업의 개발 속도가 적힌 정수 배열 speeds가 주어질 때
	각 배포마다 몇 개의 기능이 배포되는지를 return 하도록 solution 함수를 완성하세요.
	*/

    @Test
    public void test() throws Exception {
        int[] p = {93, 30, 55};
        int s[] = {1, 30, 5};

        System.out.println(solution(p, s));
        try {
            String text = new ObjectMapper().writeValueAsString(solution(p,s));
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new ConcurrentLinkedQueue<>();

        /* 소요되는 일수 계산 */
        for (int i=0; i<progresses.length; i++) {
            queue.add(
                    (100-progresses[i]) % speeds[i] == 0 ?
                            (100-progresses[i]) / speeds[i] :
                            (100-progresses[i]) / speeds[i] + 1
            );
        }

        ArrayList<Integer> list = new ArrayList<>();

        /* 처음 대기열 빼기 */
        int preFunction = queue.poll();
        int deployFunction = 1;

        while (!queue.isEmpty()) {
            int curFunction = queue.poll();
            if (preFunction >= curFunction) {
                deployFunction++;
            }
            else  {
                list.add(deployFunction);
                deployFunction = 1;
                preFunction = curFunction;
            }
        }
        list.add(deployFunction);
        int[] answer = new int[list.size()];
        for (int i=0; i<list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
