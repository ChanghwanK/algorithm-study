package search;

import java.util.Scanner;

/**
 * [소개]
 * - for 문을 이용한 선형 검색을 구현한 알고리즘 코드 입니다
 *
 * @CreateBy: Bloo
 * @Date: 2021/05/05
 */
public class SeqSearch2 {
    static int seqSearch (int [] array, int key) {
        for ( int i : array ) {
            if ( i == key ) {
                return i;
            }
        }
        return -1;
    }

    public static void main ( String[] args ) {
        int [] array = {6,4,3,5,2,1};
        int idx = SeqSearch.seqSearch (array, 3 );

        if ( idx != -1 ) {
            System.out.println ("key 값의 위치는 " + idx + " 번째에 위치 합니다.");
        } else {
            System.out.println ("해당 키 값은 배열에 존재하지 않습니다.");
        }
    }
}
