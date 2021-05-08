### **들어가며**

안녕하세요 이번에는 대표적인 자료구조 중 하나인 링크드 리스트를 이해하고 구현해보겠습니다. 링크드 리스트는 구현이 다른 자료구조들에 비해서 꽤나 복잡한 편입니다. 그 이유는 다양한 상황이 존재하고 또 '포인터' 라는 개념을 활용하기 때문인데요 이제부터 이를 학습해보겠습니다.

<br>

### 링크드 리스트의 구조

- 링크드 리스트는 우리나라말로 **'연결리스트'** 라고 합니다.
- 배열은 순차적으로 연결된 공간에 데이터를 나열하는 데이터 구조인 반면에 링크드 리스트는 떨어진 곳에 존재하는 데이터를 **'포인터' 를 이용해 연결하여 관리하는 데이터 구조를 가집니다.**

<br>

### **용어**

- **Node: 링크드 리스트를 이루는 데이터의 저장 단위 이며 데이터 값과 포인터로 구성 되어있습니다.**
- **Pointer: 각 노드 안에서, 다음이나 이전의 노드와의 연결 정보를 가지고 있는 공간 입니다. 여기서 연결 정보는 노드의 주소 공간이 됩니다.**

<br>

**일반적인 링크드 리스트의 형태**

![](https://images.velog.io/images/somday/post/a2d3c8f9-3de1-4552-bb2b-234526c05eb6/0.png)

<br>

**이제 간단하게 링크드 리스트를 구현해보겠습니다.**

- 최대한 간단하게 작성해서 링크드 리스트의 원리에 집중하겠습니다.

<br>

**Node 클래스 구현**

![](https://images.velog.io/images/somday/post/dac6bb5c-0677-413a-b1e8-ae4fba9b2d83/1.png)

<br>

**살펴보기**

Node 클래스 자체는 간단한 구조 입니다. Node가 Data 와 다음 Node의 위치를 가지고 있는 Pointer 로 이루어져 있기 때문에 Data 와 다음 Node 의 주소를 가질 수 있는 Node 객체를 멤버 변수로 가집니다.

그리고 최초의 Node는 다음 Node가 없기 때문에 null 상태로 초기화 되어있어야 합니다.


<br>

**Node와 Node 연결하기**

- 즉, 이제 Node 클래스를 생성하고 하나는 HEAD 노드로 하고 하나는 다음 노드로 설정하는 코드를 작성해보겠습니다.

<br>

**코드**

![](https://images.velog.io/images/somday/post/c5c6bae2-c1c3-429a-a1f0-43c625e7152f/2.png)


첫번째 생성되는 node를 head 라고 지정해주고 head의 next 에는 다음 노드를 초기화해주면 연결리스트를 구현할 수 있습니다. **이제 이를 Linked List 라는 클래스에서 데이터를 추가하는 기능 삭제하는 기능 등등을 추가하며 Linked List 클래스를 만들어 보겠습니다.**

<br>

### Linked List 클래스 구현

- 일단 제가 구현한 코드는 Single Linked List 입니다.
- 그리고 해당 클래스의 길이가 길기 때문에 하나의 기능별로 따로 분리해서 보겠습니다.


<br>

**먼저 새로운 노드를 넣는 addNode 메서드 입니다.**

**코드**

![](https://images.velog.io/images/somday/post/8f3d403d-4f8d-4aea-860b-13a4cc47cefb/3.png)


<br>

**살펴보기**

새로운 노드를 넣는 로직은 간단합니다. 먼저 head 가 null 인지 검사를 합니다. 사실 head 는 무조건 Null 일 수 없다고 가정하면 if 조건은 필요가 없습니다. 다만 저는 addNode를 실행할 때 첫번째 head 노드도 생겼으면 해서 초기화를 null 로 했으며 null 일때 첫번째 Node 가 head 값이 되도록 했습니다.

그 다음 로직은 이제 [node.next](http://node.next) 가 null 인 node 를 찾고 next 에 새로운 Node를 할당하는 로직 입니다.  여기서 node = this.head 를 하는 로직이 있는데 이 이유는 head 의 값을 알아야 다음 다음으로 검사를 할 수 있기 때문에 node 를 head 로 초기화 합니다.

<br>

### 노드 찾기

- 두 번째로 살펴볼 로직은 찾고자 하는 data 를 가진 Node가 있는지 찾는 것입니다.

**코드**

![](https://images.velog.io/images/somday/post/83b256b0-909c-427b-98ee-d5db45a264bf/4.png)


<br>

**살펴보기**

data 를 찾기 위해서 먼저 head 가 null 이 아니여야 함으로 head 가 null 인지 검사 합니다. 그리고 시작부분을 찾아야 검사를 할 수 있으니 node = this.head를 통해 head 값을 설정해줍니다. 그리고 나서 next 가 null 이 아닐때 까지 검사를 하며 node의 data 찾고자 하는 data 인지 검사하고 맞다면 node 를 리턴하도록 합니다.

그리고 쭉 검사를 했지만 찾고자 하는 data 가 없다면 node가 없는 것이기 때문에 null 을 리턴하도록 했습니다.

<br>

### 새로운 값을  Node 사이에 넣기

- 링크드 리스트는 새로운 값을 사이에 넣을 수 있는 특징이 있습니다. 따라서 이를 구현해보겠습니다.

**코드**

![](https://images.velog.io/images/somday/post/a0ba8fe1-46e2-4237-b0ac-dd35376ea5b9/5.png)


<br>

**살펴보기**

새로운 노드를 기존의 노드 사이에 넣기 위해서는 먼저 사이 값을 찾아야 합니다.

![](https://images.velog.io/images/somday/post/9ce3272e-f9dc-4ad6-b44d-b40dc8cfaa07/6.png)


그러기 위해서는 위와 같은 구조가 되어야 하기 때문에 21 이라는 값을 가진 Node 가 있는지 부터 검사해야 합니다. 따라서 searchNode() 메서드를 실행해서  pointer 를 변경할 Node 를 가져 옵니다.

그리고 가져온 Node 의 Pointer 를 새롭게 input 되는 Node 로 주소 변경을 해주고 새롭게 input 되는 node의 pointer 에는 기존 node 의 포인터가 가르키던 next 의 주소를 초기화 해주면 됩니다.

<br>

**정리**

1. pointer 를 변경할 Node 를 먼저 조회한다.
2. 있다면 기존 pointer 를 임의의 Node 에 초기화 한다. (나중에 다시 연결을 하기 위해서)
3. 이제 [node.next](http://node.next) 값을 새롭게 input 되는 node 로 초기화 한다.
4. 마지막으로 임의의 노드로 빼놓은 기존의 next 값을 새롭게 input 되는 node의 next 값으로 설정한다.

<br>

### 노드 삭제하기

- 마지막으로 알아볼 기능은 Node 를 삭제하는 것입니다.

**코드**

![](https://images.velog.io/images/somday/post/bc4af3b2-04bd-4206-95a6-d950f1ea9c2e/7.png)

<br>

**살펴보기**

**먼저 흐름은 다음과 같습니다.**

1. head가 null 인지 검사
2. head가 null 이 아니라면 head 값 부터 삭제할 Node 인지 검사를 진행
3. 만약 삭제 하고자 하는 Node가 head 라면 head 값을 기존의 head 의 next 로 설정
4. 다음으로 삭제 할 값이 head 도 아니라면 next 가 null 이 아닐때 까지 Node를 탐색
5. [node.next.data](http://node.next.data) == delData 인 node 를 찾는다면 node.next 값을 node.next의 next 로 설정 하고 true 리턴
6. 삭제할 node 와 일치하는 node가 없다면 false 리턴하고 종료

여기서 5번 로직이 약간 이해하기 어려울 수 있는데요 그림으로 보겠습니다.

![](https://images.velog.io/images/somday/post/3c5e671b-10e9-4075-a146-b2c32fb1dee2/8.png)

<br>

**18 Node 삭제 명령이 들어왔기 때문에 앞의 2번 Node의 Pointer 값을 21번 Node 로 설정하는 것이 node.next.next로 값을 설정한느 것이라 할 수 있습니다.**

<br>
<br>

**전체코드**

```java
package linked_list;

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
```

<br>
<br>
<br>

### **회고**

오늘은 Single Linked List에 대해서 알아보았습니다. 로직자체가 막 어렵거나 하지는 않지만 약간 주의가 필요한 전체 코드 입니다. 하지만 하나하나 기능을 곱씹어 보며 작성해보고 테스트 해본다면 충분히 작성할 수 있는 코드 였습니다. 여기서 저한테 가장 애매모 했던 것은 **"삭제 로직" 에서 5번 흐름이 가장 애매모 했고 가장 실수를 많이 했던 부분이 while 문을 돌때 node = [node.next](http://node.next) 하는 것을 까먹어서 while 문이 제대로 돌지 않았던 것이 가장 실수를 많이 했던 부분인거 같습니다.** 이 부분은 자주 작성해보면 익숙해지면서 완화 될 부분이라 생각하며 오늘의 자료구조 스터디를 마무리 하겠습니다.


<br>
<br>

**감사합니다.**