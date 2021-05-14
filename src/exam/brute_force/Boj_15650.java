package exam.brute_force;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 15650 번 N 과 M (2) - N 개 중 중복 없이 M 개를 순서 있게 나열 하기 1 <= M  <= N <= 8
 */
public class Boj_15650 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void input () {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    // M 개를 모두 선택 or 미 선택
    static void rec_func ( int k ) {
        if ( k == M + 1 ) {
            // selected [1....M] 배열이 새롭게 탐색된 결
            for ( int i = 1; i <= M; i++ ) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            for ( int cand = selected[k - 1] + 1; cand <= N; cand++ ) {
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
