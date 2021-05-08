package linked_list;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/08
 */

public class Node<T> {
    T data;
    Node<T> next = null;

    public Node ( T data ) {
        this.data = data;
    }

    public static void main ( String[] args ) {
        Node<Integer> head = new Node<> ( 1 );
        Node<Integer> node = new Node<> ( 2 );

        head.next = node;

        System.out.println (head.data);
        System.out.println (head.next.data);
    }
}



