package coding.test.programmers.skillcheck.level1;

import org.junit.Test;

public class primeNumber {

    @Test
    public void test() throws Exception {
        System.out.println(isPrime(3));
    }

    public boolean isPrime(int num) {
        for(int i=2; i*i<=num; i++){
            if(num % i == 0) return false;
        }
        return true;
    }
}
