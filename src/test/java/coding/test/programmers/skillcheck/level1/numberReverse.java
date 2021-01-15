package coding.test.programmers.skillcheck.level1;

import org.junit.Test;

public class numberReverse {
    @Test
    public void test() throws Exception {
        System.out.println(numberReverse(12345));
    }

    public int numberReverse(int num){
        int result=0;
        while(num!=0){
            result= result * 10 + num % 10;
            num /= 10;
        }
        return result;
    }
}
