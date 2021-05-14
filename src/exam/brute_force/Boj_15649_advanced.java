package exam.brute_force;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 - 15650 번 N 과 M (1) - N 개 중 중복 없이 M 개를 순서 있게 나열 하기 1 <= M  <= N <= 8
 * <p>
 * 개선하기 - 현재는 for 문이 한 번더 돌면서 cand 와 selected[i] 같은지 비교해서 isUsed 체킹을 하기 때문에 시간 복잡도가 더 높다. - 이를 개선하기
 * 위해서 used[] 을 사용해서 개선하자
 */

public class Boj_15649_advanced {

    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int[] selected, used;

    static void input () {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
        used = new int[N + 1];
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
            for ( int cand = 1; cand <= N; cand++ ) {
                if ( used[cand] == 1 )
                    continue;
                selected[k] = cand;
                used[cand] = 1;

                rec_func(k+1);
                used[cand] = 0;
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
