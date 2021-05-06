package queue;

import java.util.ArrayList;
import java.util.Queue;

/**
 * Description
 * :  Queue 를 구현하라
 *
 * @CreateBy: Bloo
 * @Date: 2021/05/06
 */

public class MyQueue<T> {
    ArrayList<T> arrayList = new ArrayList<> ();

    public void enqueue (T data) {
        if ( arrayList == null ) {
            arrayList = new ArrayList<> ();
        } else {
            arrayList.add ( data );
        }
    }

    public void dequeue (T data) {
        if ( data == null ) {
            System.out.println ("입력 데이터가 Null 입니다. ");
        }

        if (!arrayList.contains ( data ) && arrayList.size () > 0 ) {
            System.out.println ("더 이상 데이터가 존재하지 않거나, 없는 데이터 입니다.");
        } else {
            arrayList.remove ( data );
        }
    }

    public static void main ( String[] args ) {
        MyQueue<Integer> mq = new MyQueue<> ();
        mq.enqueue ( 1 );
        mq.enqueue ( 2 );
        mq.enqueue ( 3 );
        mq.arrayList.forEach ( System.out::println );

        // 데이터 삭제 실패
        mq.dequeue ( 4 );

        // 데이터 삭제 성공
        mq.dequeue ( 3 );

        mq.arrayList.forEach ( System.out::println );
    }
}
