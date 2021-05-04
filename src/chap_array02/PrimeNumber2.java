package chap_array02;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/04
 */
public class PrimeNumber2 {
    public static void showPrimeNumberOf (int number) {
        int counter = 0;                // 곱셈과 나눗셈의 횟수
        int ptr = 0;                    // 찾은 소수의 개수
        int [] prime = new int[500];    // 소수를 저장할 배열

        prime[ptr++] = 2;
        prime[ptr++] = 3;

        for ( int n = 5; n <= number ; n+=2 ) {       // 대상은 홀수만
            boolean flag = false;
            for ( int i = 1; prime[i] * prime[i] <= n ; i++ ) {
                counter+=2;
                if ( n % prime[ i ]  == 0 ) {
                    flag = true;
                    break;
                }
            }
            if ( !flag ) {
                prime[ptr++] = n;
                counter++;
            }
        }

        for ( int i = 0; i < ptr; i++ ) {
            System.out.print (prime[i] + " ");
        }

        System.out.println ();
        System.out.println ("곱셈과 나눗셈을 수행한 횟수:" + counter);
    }

    public static void main ( String[] args ) {
        PrimeNumber2.showPrimeNumberOf ( 1000 );
    }
}
