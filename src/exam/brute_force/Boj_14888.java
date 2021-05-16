package exam.brute_force;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;

import java.io.*;
import java.util.*;

/**
 * 백준 14888 - 연산자 끼워 넣기
 */
public class Boj_14888 {

    static StringBuilder sb = new StringBuilder();

    static int N, MAX, MIN;                    // 숫자의 개수, 최댓값, 최솟값
    static int[] nums, operators, order;       // 숫자, 연산자, 연산자 순서 기록 배열

    static void input () {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        nums = new int[N + 1];
        operators = new int[5];
        order = new int[N + 1];

        for ( int i = 1; i <= N; i++ ) {
            nums[i] = scan.nextInt();
        }

        for ( int i = 1; i <= 4 ; i++ ) {
            operators[i] = scan.nextInt();
        }

        MAX = Integer.MAX_VALUE;
        MIN = Integer.MIN_VALUE;
    }
    static int calculator() {
        // nums, order
        int value = nums[1];
        for ( int i = 1; i <=N-1 ; i++ ) {
            if (order[i] == 1)
                value =value + nums[i+1];
        }
        return value;
    }
    static void rec_func ( int k ) {
        if ( k == N ) {   // 모든 연산자들을 전부 나열하는 방법을 찾은 상

            // 정한 연산자 순서대로 계산해서 정답을 갱신하기
            // 완성돈 식에 맞게 맞게 계산을 해서 정답을 갱신하는 작업

        } else {    // K 번째 연산자는 무엇을 선택 할 것인가?

            // 4 가지의 연산자들 중에 뭘 쓸 것인지 선택하고 재귀호출 하기

        }
    }

    public static void main ( String[] args ) {
       input();
       rec_func(1);
       sb.append(MAX).append('\n').append(MIN);
        System.out.println(sb.toString());
    }


    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader () {
            br = new BufferedReader(new InputStreamReader(in));
        }

        public FastReader ( String s ) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next () {
            while ( st == null || ! st.hasMoreTokens() ) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch ( IOException e ) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt () {
            return parseInt(next());
        }

        Long nextLong () {
            return parseLong(next());
        }

        Double nextDouble () {
            return parseDouble(next());
        }
    }
}
