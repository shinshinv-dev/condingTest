package coding.test.programmers.practice.stackqueue;

import org.junit.Test;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class level2_4 {
    /*
	프린터

	일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다.
	이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
	이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

	1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
	2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
	3. 그렇지 않으면 J를 인쇄합니다.
	예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

	내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

	현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,

	내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.
	*/

    @Test
    public void test() throws Exception {
        //int[] p = {2, 1, 3, 2};
        int[] p = {1, 1, 9, 1, 1, 1};
        int l = 0;
        System.out.println(solution(p, l));
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int item : priorities) {
            queue.offer(item);
        }

        Arrays.sort(priorities);
        int length = priorities.length - 1;

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == priorities[length - answer]) {
                answer++;
                location--;
                if (location < 0) {
                    break;
                }
            } else {
                queue.offer(cur);
                location--;
                if (location < 0) {
                    location = queue.size() - 1;
                }
            }
        }
        return answer;
    }
}
