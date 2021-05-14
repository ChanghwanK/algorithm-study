package exam.brute_force;

import static java.lang.Double.parseDouble;
import static java.lang.Integer.parseInt;
import static java.lang.Long.parseLong;
import static java.lang.System.in;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 15652 - N 과 M (4)
 * <p>
 * - 같은 수를 여러 번 골라도 된다 - 중복 허용 - 고른 수열은 비내림차순 - 오름 차순 이거나 같을 수 있다
 * - 즉  >>>> 2 3 혹은 2 2 가능 (3 2) 불가
 */
public class Boj_15652 {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected;

    static void input () {
        Main.FastReader scan = new Main.FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    static void rec_func ( int k ) {
        if ( k == M + 1 ) {
            for ( int i = 1; i <= M; i++ ) {
                sb.append(selected[i]).append(" ");
            }
            sb.append("\n");
        } else {
            // 가능한 숫자 start: 이전에 사용된 숫자 (k-1) 의 값보단 크거나 같아야 한다. (오름차순이니)
            int start = selected[k - 1];
            if ( start == 0 ) {
                start = 1;
            }
            // start 숫자 계산이 핵심
            for ( int cand = start; cand <= N; cand++ ) {
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
