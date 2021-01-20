package coding.test.programmers.practice.sort;

import org.junit.Test;

import java.util.Arrays;

public class level2_1 {
    /*
	가장 큰 수

	0 또는 양의 정수가 주어졌을 때, 정수를 이어 붙여 만들 수 있는 가장 큰 수를 알아내 주세요.

	예를 들어, 주어진 정수가 [6, 10, 2]라면
	[6102, 6210, 1062, 1026, 2610, 2106]를 만들 수 있고,
	이중 가장 큰 수는 6210입니다.

	0 또는 양의 정수가 담긴 배열 numbers가 매개변수로 주어질 때,
	순서를 재배치하여 만들 수 있는 가장 큰 수를 문자열로 바꾸어
	return 하도록 solution 함수를 작성해주세요.
	*/

    @Test
    public void test() throws Exception {
        int[] n = {6, 10, 2};
        int[] n2 = {3, 30, 34, 5, 9};
        System.out.println(solution(n2));
    }

    public String solution(int[] numbers) {
        String answer = "";

        String[] item = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            item[i] = String.valueOf(numbers[i]);
        }
        /*
        Arrays.sort(item, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return ((o2 + o1).compareTo(o1 + o2));
            }
        });
        */

        /*
        Comparator<String> comp = (o1, o2) -> (o2 + o1).compareTo(o1 + o2);
        Arrays.sort(item, comp);
        */

        Arrays.sort(item, (o1, o2) -> (o2 + o1).compareTo(o1 + o2));
        if (item[0].equals("0")) {
            return "0";
        }
        for (String numberString : item) {
            answer += numberString;
        }
        return answer;
    }
}
