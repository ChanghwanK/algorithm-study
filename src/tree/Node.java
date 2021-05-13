package tree;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/13
 */
public class Node {
    Node left;
    Node right;
    int data;

    public Node (int data) {
        this.left = null;
        this.right = null;
        this.data = data;
    }
}
