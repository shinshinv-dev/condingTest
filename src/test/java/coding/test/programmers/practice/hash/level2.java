package coding.test.programmers.practice.hash;

import org.junit.Test;

import java.util.Arrays;

public class level2 {
    /* 전화번호 목록 */
    /*
	문제 설명
	전화번호부에 적힌 전화번호 중, 한 번호가 다른 번호의 접두어인 경우가 있는지 확인하려 합니다.
	전화번호가 다음과 같을 경우, 구조대 전화번호는 영석이의 전화번호의 접두사입니다.

	구조대 : 119
	박준영 : 97 674 223
	지영석 : 11 9552 4421
	전화번호부에 적힌 전화번호를 담은 배열 phone_book 이 solution 함수의 매개변수로 주어질 때,
	어떤 번호가 다른 번호의 접두어인 경우가 있으면 false를 그렇지 않으면 true를 return 하도록 solution 함수를 작성해주세요.
    */

    @Test
    public void test() throws Exception {
        String p[] = {"119", "97674223", "1195524421"};
        System.out.println(solution(p));
    }

    /* n*n */
    public boolean solution(String[] phone_book) {
        for (int i = 0; i < phone_book.length; i++) {
            for (int j = 0; j < phone_book.length; j++)
                if ((i != j) && phone_book[j].startsWith(phone_book[i])) {
                    return false;
                }
        }

        return true;
    }

    /* n*n */
    public boolean solution2(String[] phone_book) {
        boolean answer = true;

        int i;
        int j;
        //마지막은 비교할 필요가 없으니 길이를 -1 로 해도 된다.
        for(i=0;i < phone_book.length-1;i++ ) {
            for(j = i+1 ; j< phone_book.length;j++) {
                if(phone_book[j].startsWith(phone_book[i]))
                    return false;
                //(i,j)는 (0,1),(0,2),(1,2)로 서로 비교하는데, 1,2가 각각 0,1로 시작하는지 알 수 있다.
                if(phone_book[i].startsWith(phone_book[j]))
                    return false;
                //i=0,1 일때 다른 친구들과도 비교를 해야 하기 때문에
            }
        }
        //for문을 통해 return를 못한다면 시작하는 부분이 없기 때문에
        return true;
    }

    /* Arrays.sort 확실하지 않음 */
    public boolean solution3(String[] phone_book) {
        boolean answer =true;
        Arrays.sort(phone_book);
        //sort시 String으로 숫자들이 나열되어 있어도 오름차순으로 정리됩니다.
        //sort 하면 가장 큰 수가 뒤로 가므로 뒤에 숫자로 부터 앞의 숫자가 시작하는지 확인할 필요가 없어지는 것 입니다.
        //["119", "97674223", "1195524421"]이 경우 sort 해도 이렇게 유지가 됩니다.
        for(int i=0; i<phone_book.length-1; i++ ){
            if(phone_book[i+1].startsWith(phone_book[i]))
            {answer= false; break;}
            //9767~이 119로 시작하는지, 119555~가 9767로 시작하는지 확인합니다.
        }
        return answer;
    }



}
