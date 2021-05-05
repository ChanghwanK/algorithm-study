package search;

/**
 * [소개]
 * - 보초법을 이용하여 선형 알고리즘의 시간 복접도를 개선한 알고리즘 입니다.
 *
 * @CreateBy: Bloo
 * @Date: 2021/05/05
 */
public class SeqSearchSen {
    static int seqSearch (int [] array, int key) {
        int i = 0;
        int n = array.length + 1;
        array[n] = key;                     // 보초값 설정

        while ( array[ i ] != key ) {
            i++;
        }
        return i == n ? -1 : i;             // 만약 i 가 보초값의 index 번호 까지 갔다면 배열에 key 가 없는 것이기 때문에 -1 을 리턴 아니라면 i (key 의 위치) 를 리턴
    }

    public static void main ( String[] args ) {
        int [] array = {6,4,3,5,2,1};
        int idx = SeqSearch.seqSearch (array, 1 );

        if ( idx != -1 ) {
            System.out.println ("key 값의 위치는 " + idx + " 번째에 위치 합니다.");
        } else {
            System.out.println ("해당 키 값은 배열에 존재하지 않습니다.");
        }

    }
}
