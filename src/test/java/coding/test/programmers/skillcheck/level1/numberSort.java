package coding.test.programmers.skillcheck.level1;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;

public class numberSort {

    /* 숫자타입을 내림 차순으로 정렬 112345 -> 543211 */

    @Test
    public void test () throws Exception{
        System.out.println(solution(112345));

    }

    public long solution(long n) {

        long answer = 0;

        String nStr= String.valueOf(n);
        /**
         * Collections.reverseOrder()를 사용하기 위해 Integer로 선언
         */
        Integer[] arrs = new Integer[nStr.length()];

        for (int i = 0; i < nStr.length(); i++) {
            arrs[i] = nStr.charAt(i) - 48;
        }

        /**
         * 내림차순 정렬
         */
        Arrays.sort(arrs, Collections.reverseOrder());

        for (int i = 0; i < arrs.length; i++) {
            answer += arrs[i] * Math.pow(10, arrs.length - 1 - i);
        }
        return answer;
    }

    /* Sol 2 */
//    public class ReverseInt {
//        String res = "";
//        public int reverseInt(int n){
//            res = "";
//            Integer.toString(n).chars().sorted().forEach(c -> res = Character.valueOf((char)c) + res);
//            return Integer.parseInt(res);
//        }
//
//        // 아래는 테스트로 출력해 보기 위한 코드입니다.
//        public static void  main(String[] args){
//            ReverseInt ri = new ReverseInt();
//            System.out.println(ri.reverseInt(118372));
//        }
//    }
}
