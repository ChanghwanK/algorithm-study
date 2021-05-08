package linked_list;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/08
 */
public class MyLinkedList<T> {
    private Node<T> head = null;

    public void addNode ( T data ) {
        if ( head == null ) {
            head = new Node<> ( data );
        } else {
            Node<T> node = this.head;
            while ( node.next != null ) {
                node = node.next;
            }
            node.next = new Node<> (data);
        }
    }

    public void showAllNodes() {
        if ( head != null ) {
            Node<T> node = this.head;
            System.out.println (node.data);
            while ( node.next != null ) {
                // System.out.println (node.data);
                node = node.next;
                System.out.println (node.data);
            }
        }
    }

    public Node<T> searchNode (T data) {
        if ( head != null ) {
            Node<T> node = this.head;
            while ( node.next != null ) {
                if ( node.data == data ) {
                    return node;
                } else {
                    node = node.next;
                }
            }
        }
        return null;
    }

    public void putNewNodeInBetween ( T newData, T existData ) {
        Node<T> searchedNode = this.searchNode ( existData );

        if ( searchedNode == null ) {
            this.addNode ( newData );
        } else {
            Node<T> nextNode = searchedNode.next;
            searchedNode.next = new Node<> ( newData );
            searchedNode.next.next = nextNode;
        }
    }

    public boolean delNode ( T delData ) {
        if ( this.head == null ) {
            return false;
        } else {
            Node<T> node = this.head;
            if ( node.data == delData ) {
                this.head = this.head.next;
                return true;
            }  else {
                while ( node.next != null ) {
                    if ( node.next.data == delData ) {
                        node.next = node.next.next;
                        return true;
                    }
                    node = node.next;
                }
                return false;
            }
        }
    }
}
