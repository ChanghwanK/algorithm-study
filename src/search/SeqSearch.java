package search;

import java.util.Scanner;

/**
 * [소개]
 * - While 문을 이용한 선형 검색을 구현한 알고리즘 코드 입니다/
 *
 * @CreateBy: Bloo
 * @Date: 2021/05/05
 */
public class SeqSearch {
    static int seqSearch (int [] array, int key) {
        int i = 0;

        while ( true  ) {
            if ( i == array.length ) {
                return -1;
            }

            if ( array[i] == key ) {
                return i;   // 검색 성공 (배열의 인덱스를 반환)
            }

            i++;
        }
    }

    public static void main ( String[] args ) {
        Scanner stdIn = new Scanner ( System.in );
        int [] array = {6,4,3,5,2,1};
        System.out.print ("배열 [");
        for ( int a : array ) {
            System.out.print ( a + " " );
        }

        System.out.println ("] 에서 key 의 위치는 어디인가??? ");

        int idx = SeqSearch.seqSearch ( array, 3 );

        if ( idx == -1 ) {
            System.out.println ("그 값을 가진 요소가 없습니다.");
        } else {
            System.out.println (idx + " 번째에 위치 합니다. ");
        }
    }
}
