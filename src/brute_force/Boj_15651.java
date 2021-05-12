package brute_force;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * [ 문제 ]
 *   - N 개의 숫자 중 M 개를 고른 모든 수열을 출력
 *   - 이때 오름 차순으로 출력하고 같은 수에 대한 중복을 허용한다.
 */
public class Boj_15651 {
    static StringBuilder sb = new StringBuilder();
    static int N, M;
    static int [] selected;

    public static void main ( String[] args ) {
        input();
        rec_func(1);
        System.out.println(sb.toString());
    }

    static void input() {
        FastReader scan = new FastReader();
        N = scan.nextInt();
        M = scan.nextInt();
        selected = new int[M + 1];
    }

    static void rec_func (int k) {
        if (k == M + 1) {
            for ( int i = 0; i <= M; i++ ) {
                sb.append(selected[i]).append(' ');
            }
            sb.append('\n');
        } else {
            for ( int cand = 1; cand <= N ; cand++ ) {
                selected[k] = cand;
                rec_func(k+1);
                selected[k] = 0;
            }
        }
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader () {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        public FastReader (String s) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(s)));
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
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
        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine () {
            String str = "";
            try {
                str = br.readLine();
            } catch ( IOException e ) {
                e.printStackTrace();
            }

            return str;
        }
    }
}
