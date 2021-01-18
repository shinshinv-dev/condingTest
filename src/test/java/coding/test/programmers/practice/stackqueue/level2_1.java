package coding.test.programmers.practice.stackqueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.Stack;

public class level2_1 {
    /*
    주식가격

    초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때,
    가격이 떨어지지 않은 기간은 몇 초인지를 answerurn 하도록 solution 함수를 완성하세요.

    */

    @Test
    public void test() throws Exception {
        int p[] = {1, 2, 3, 2, 3};
        System.out.println(solution(p));
        try {
            String text = new ObjectMapper().writeValueAsString(solution(p));
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer[]> stack = new Stack<>();

        for (int i = prices.length - 2; i >= 0; i--) {
            System.out.println("i = " + i);
            int day = 0;

            while (!stack.isEmpty() && stack.peek()[0] >= prices[i]) {
                day += stack.pop()[1];
            }

            answer[i] = stack.push(new Integer[]{prices[i], day + 1})[1];
            try {
                String text = new ObjectMapper().writeValueAsString(stack);
                System.out.println("Stack");
                System.out.println(text);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return answer;
    }
}
