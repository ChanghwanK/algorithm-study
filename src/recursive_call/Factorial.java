package recursive_call;

import java.util.Scanner;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/12
 */
public class Factorial {
    static int N;

    public static void main ( String[] args ) {
       input();
       System.out.println(factorial(N));
    }

    static void input() {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
    }

    static int factorial(int number) {
        int result = number;

        if ( number > 1 ) {
            result *= factorial(number-1);
        }
        return result;
    }
}
