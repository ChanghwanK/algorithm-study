package stack;

import java.util.ArrayList;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/08
 */

public class MyStack<T> {

    private ArrayList<T> stack = new ArrayList<> ();

    public void push (T data) {
        stack.add ( data );
    }

    public T pop () {
        return stack.remove ( stack.size () - 1 );
    }

    public boolean isEmpty() {
        return stack.isEmpty ();
    }

    public void showStackData() {
        for ( T data : stack ) {
            System.out.println (data + " ");
        }
    }

    public static void main ( String[] args ) {
        MyStack<Integer> myStack = new MyStack<> ();

        // PUSH
        myStack.push ( 1 );
        myStack.push ( 2 );

        // 확인
        myStack.showStackData ();

        // POP
        myStack.pop ();

        myStack.showStackData ();
    }
}
