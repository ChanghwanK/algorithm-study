package exam.brute_force;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 15651 N 과 M (3) [ 문제 ] - N 개의 숫자 중 M 개를 고른 모든 수열을 출력 - 이때 오름 차순으로 출력하고 같은 수에 대한 중복을 허용한다.
 */
public class Boj_15651 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void input () {
        Main.FastReader scan = new Main.FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    // M 개를 모두 선택 or 미 선택
    static void rec_func ( int k ) {
        // M 개를 모두 선택 완료
        if ( k == M + 1 ) {
            // selected [1....M] 배열이 새롭게 탐색된 결
            for ( int i = 1; i <= M; i++ ) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            // K 번째 원소에 1 번부터 N 까지의 숫자가 차례대로 들어올 수 있다.
            for ( int cand = 1; cand <= N; cand++ ) {
                selected[k] = cand;
                rec_func(k + 1);
            }
        }
    }

    public static void main ( String[] args ) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    static class FastReader {

        BufferedReader br;
        StringTokenizer st;

        public FastReader () {
            br = new BufferedReader(new InputStreamReader(System.in));
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
            return Integer.parseInt(next());
        }

        Long nextLong () {
            return Long.parseLong(next());
        }

        Double nextDouble () {
            return Double.parseDouble(next());
        }
    }
}
