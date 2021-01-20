package coding.test.programmers.practice.sort;

import org.junit.Test;

import java.util.Arrays;

public class level2_2 {
    /*
	H-Index

	H-Index는 과학자의 생산성과 영향력을 나타내는 지표입니다.
	어느 과학자의 H-Index를 나타내는 값인 h를 구하려고 합니다.
	위키백과에 따르면, H-Index는 다음과 같이 구합니다.

	어떤 과학자가 발표한 논문 n편 중,
	h번 이상 인용된 논문이 h편 이상이고 나머지 논문이 h번 이하 인용되었다면
	h의 최댓값이 이 과학자의 H-Index입니다.

	어떤 과학자가 발표한 논문의 인용 횟수를 담은 배열 citations가 매개변수로 주어질 때
	 이 과학자의 H-Index를 return 하도록 solution 함수를 작성해주세요.
	 */

    @Test
    public void test() throws Exception {
        int[] c = {3, 0, 6, 1, 5};
        System.out.println(solution(c));
    }

    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = citations.length;
        for (int i=citations.length-1; i>=0; i--) {
            int remain = citations.length - i;
            if (citations[i] <= remain) {
                answer = citations[i] == remain ? citations[i] : remain - 1;
                break;
            }
        }
        return answer;
    }

    public int solution2(int[] citations) {
        Arrays.sort(citations);
        int max = 0;
        for(int i = citations.length-1; i > -1; i--){
            int min = (int)Math.min(citations[i], citations.length - i);
            if(max < min) max = min;
        }

        return max;
    }
}
