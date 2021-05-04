package chap_array02;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/04
 */

public class PrimeNumber {

    public static void showPrimeNumberOf (int number) {
        int count = 0;
        for ( int num = 2; num <= number ; num++ ) {
            int i;
            for ( i = 2; i < num; i++) {
                count++;
                if ( num % i == 0 ) {
                    break;
                }
            }
            if ( num == i ) {
                System.out.print (num + " " );
            }
        }
        System.out.println ("나눗셈을 수행한 횟수: " + count);
    }

    public static void main ( String[] args ) {
        PrimeNumber.showPrimeNumberOf ( 100 );
    }
}
