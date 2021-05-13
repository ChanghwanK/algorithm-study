package tree;

/**
 * @CreateBy: Bloo
 * @Date: 2021/05/13
 */
public class NodeMgnt {
    Node head = null;

    // 새로운 노드 추가
    public void insertNode (int inputData) {
        if (head == null) {
            head = new Node (inputData);
        } else {
            Node findNode = head;
            while (true) {
                if (inputData < findNode.data) {
                    if (findNode.left != null) {
                        findNode = findNode.left;
                    } else {
                        findNode.left = new Node(inputData);
                        break;
                    }
                } else {
                    if (findNode.right != null) {
                        findNode = findNode.right;
                    } else {
                        findNode.right = new Node (inputData);
                        break;
                    }
                }
            }
        }
    }
    // Node 탐색 기능
    public Node searchNode (int searchData) {
        if (this.head == null) {
            return null;
        } else {
            Node findNode = this.head;
            while (findNode != null) {
                if (findNode.data == searchData) {
                    return findNode;
                } else if (searchData < findNode.data) {
                    findNode = findNode.left;
                } else {
                    findNode = findNode.right;
                }
            }
            return null;
        }
    }

    // Node 삭제 기능
    public boolean delete (int deleteData) {
        boolean searched = false;
        Node currParentNode = this.head;
        Node currNode = this.head;

        if (this.head == null) {
            return false;
        } else {
            // node 가 head node 만 있을 때
            if (this.head.data == deleteData && this.head.left == null && this.head.right == null) {
                this.head = null;
                return true;
            }

            // 삭제할 노드 조회
            while (currNode != null) {
                if (currNode.data == deleteData) {
                    searched = true;
                    break;
                } else if (deleteData < currNode.data) {
                    currParentNode = currNode;
                    currNode = currNode.left;
                } else {
                    currParentNode = currNode;
                    currNode = currNode.right;
                }
            }
            // 삭제할 노드를 발견 못함
            if (searched == false) {
                return false;
            }
        }
        // 삭제 node 가 leaf_node 인 경우
        if (currNode.left == null && currNode.right == null) {
            if (deleteData < currNode.data) {
                currParentNode.left = null;
            } else {
                currParentNode.right = null;
            }
            return true;
            // 삭제 할 Node 가 childNode 를 한 개 가지고 있을 경우 (왼쪽)
        } else if (currNode.left != null && currNode.right == null) {
            if (deleteData < currNode.data) {
                currParentNode.left = currNode.left;
            } else {
                currParentNode.right = currNode.right.left;
            }
            return true;


            // 삭제 할 Node 가 childNode 를 한 개 가지고 있을 경우 (오른쪽)
        } else if (currNode.left == null && currNode.right != null) {
            if (deleteData < currNode.data) {
                currParentNode.left = currNode.right;
            } else {
                currParentNode.right = currNode.right;
            }
            return true;

            // 삭제할 Node 의 Child Node를 두 개 모두 가지고 있을 경우
        } else {
            // 삭제할 Node 가 Parent Node 왼쪽에 있는 경우
            if (deleteData < currParentNode.data) {
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (currNode.left != null) {
                    changeParentNode = currNode;
                    changeNode = currNode.left;
                }

                if (changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                } else {
                    changeParentNode.left = null;
                }

                currParentNode.left = changeNode;
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;
            } else {
                // 삭제할 Node 의 오른쪽 자식 중 가장 작은 값 찾기
                Node changeNode = currNode.right;
                Node changeParentNode = currNode.right;
                while (changeNode.left != null) {
                    changeParentNode = changeNode;
                    changeNode =changeNode.left;
                }

                if (changeNode.right != null) {
                    changeParentNode.left = changeNode.right;
                } else {
                    changeParentNode.left = null;
                }

                currParentNode.right = changeNode;
                changeNode.right = currNode.right;
                changeNode.left = currNode.left;
            }
            return true;
        }
    }

    public static void main ( String[] args ) {

    }
}