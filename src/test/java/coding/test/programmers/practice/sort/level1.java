package coding.test.programmers.practice.sort;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class level1 {
    /*
	K번째수

	배열 array의 i번째 숫자부터 j번째 숫자까지 자르고 정렬했을 때, k번째에 있는 수를 구하려 합니다.

	예를 들어 array가 [1, 5, 2, 6, 3, 7, 4], i = 2, j = 5, k = 3이라면

	array의 2번째부터 5번째까지 자르면 [5, 2, 6, 3]입니다.
	1에서 나온 배열을 정렬하면 [2, 3, 5, 6]입니다.
	2에서 나온 배열의 3번째 숫자는 5입니다.
	배열 array, [i, j, k]를 원소로 가진 2차원 배열 commands가 매개변수로 주어질 때,
	commands의 모든 원소에 대해 앞서 설명한 연산을 적용했을 때 나온
	결과를 배열에 담아 return 하도록 solution 함수를 작성해주세요.
	*/

    @Test
    public void test() throws Exception {
        int[] a = {1, 5, 2, 6, 3, 7, 4};
        int[][] c =  {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};
        try {
            String text = new ObjectMapper().writeValueAsString(solution2(a,c));
            System.out.println(text);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i=0; i<commands.length; i++) {
            int[] sliceArray = new int[commands[i][1] - commands[i][0]+1];
            int index = 0;
            for (int j=commands[i][0]-1; j < commands[i][1]; j++) {
                sliceArray[index] = array[j];
                index++;
            }
            Arrays.sort(sliceArray);
            answer[i] = sliceArray[commands[i][2]-1];
        }
        return answer;
    }

    public int[] solution2(int[] array, int[][] commands) {
        ArrayList<Integer> arr = new ArrayList();
        int[] answer = new int[commands.length];

        for (int i = 0; i < commands.length; i++) {
            for (int j = commands[i][0] - 1; j < commands[i][1]; j++) {
                arr.add(array[j]);
            }
            Collections.sort(arr);
            answer[i] = arr.get(commands[i][2]-1);
            arr.clear();
        }
        return answer;
    }

    public int[] solution3(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int[] temp = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(temp);
            answer[i] = temp[commands[i][2]-1];
        }

        return answer;
    }
}
