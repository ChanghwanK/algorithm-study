### **들어가며**

안녕하세요 이번 시간에는 기본 자료구조 중 하나인 Hash Table 에 대해서 이해하고 구현 해보겠습니다.

<br>

### **해쉬 테이블**

기본적인 구조는 key 에 value (데이터) 를 매핑할 수 있는 구조로 되어있습니다. 해쉬 테이블은 hashing 알고리즘을 통해 고정된 특정 길이의 값을 리턴 받는데요 이 녀석이 key가 되고 key 와 value 를 매핑하여 저장하게 됩니다. **따라서 key 를 통해서 바로 원하나는 데이터의 주소를 알 수 있기 때문에 저장 및 탐색 속도가 획기적으로 빠른 자료구조입니다.**

<br>

**해싱 로직**

![](https://images.velog.io/images/somday/post/d4a3b768-face-436a-9bd7-fd9da17e7866/1.png)

### 해쉬 테이블의 장단점과 주요 용도

**장점**

- 데이터 저장/읽기 속도가 빠릅니다. (검색 속도가 매우 빠름)
- 해쉬는 키에 대한 데이터가 있는지에 대한 **"중복 확인"** 이 쉽습니다.

**단점**

- 일반적으로 저장공간이 좀 더 많이 필요합니다.
- 여러 키에 해당하는 주소가 동일한 경우 충돌을 해결하기 위해 별도의 자료구조를 사용해야 합니다.

**주요 용도**

- 검색이 많이 필요한 시스템에 주로 사용됩니다.
- 저장, 삭제, 읽기가 빈번한 경우 사용됩니다.
- 캐쉬 구현시 중복 확인이 쉽기 때문에 사용됩니다.

<br>

### 구현

- 첫번째 구현 코드는 충돌에 대한 해결을 하지 않고 그냥 value 값을 업데이트 하는 코드입니다. 이렇게 구현한 이유는 먼저  Hash Table 에 대한 복잡도를 낮춰 이해도를 높이고 난 뒤 조금 더 복잡한 로직으로 접근을 하기 위해서 입니다.

![](https://images.velog.io/images/somday/post/2c7c5c5b-eb59-43c3-999f-7df8b33f7d7a/2.png)

<br>

**살펴보기**

저는 우선 해싱 함수 로직을 어떻게 짤것인가를 접근했습니다. 정말 다양한 알고리즘과 복잡한 알고리즘이 존재하지만 저는 여기서는 개념이 중요하기 때문에 제가 짤 수 있는 간단한 알고리즘으로 구성했습니다. 그냥 KEY 값의 가장 첫글자를 해쉬 테이블의 크기로  "%" 연산한 결과를 해싱 값으로 하고 이녀석을 주소값으로 설정하기로 했습니다.

다음으로 본격적으로 새로운 데이터를 저장하거나 검색을 하는 알고리즘을 작성했습니다. 새로운 데이터를 저장할 때 주의할 점은 일단 HashTable 객체가 Null 이 아니여야 합니다. 만약 Null 이라면 새롭게 Slot 객체를 생성해서 바로 새로운 데이터를 초기화 해줍니다.

그리고 Null 도 아니라면 이제 새로운 value를 초기화 하는 로직이 수행 됩니다. (지금은 충돌 방지를 해결하지 않고 업데이트 하는 로직입니다.)

<br>

**Slot**

> 슬롯은 Hash Table의 컬럼 하나하나를 의미 합니다.

<br>

다음으로 검색 로직을 살펴보겠습니다. 이녀석도 마찬가지로 먼저 Slot 이 Null이 아니여야 하기 때문에 Null 체크를 먼저 합니다. 그리고 Null 이라면 저장된 데이터가 없는 것이기 때문에 곧바로 Null 을 리턴하고 종료 합니다. Null 이 아니라면 key 값을 해싱하여 address 를 구한 뒤 해당 address 의 Slot 의 Value 를 리턴해주면 됩니다.

<br>

### **문제점**

지금까지 쭉 언급되었지만 이러한 경우는 충돌이 발생해서 기존의 데이터가 삭제되는 이슈가 발생합니다. 따라서 저장공간으로써의 역할을 다하지 못하는 자료구조 입니다. **이럴 때 해결하기 위한 기법으로 크게 Chaining 기법과 Linear Probing 기법이 있습니다.  여기서는 Chaining 기법을 이용해서 문제를 해결해보겠습니다.**

<br>

### **Chaining 기법으로 충돌 해결하기**

<br>

```java
public class MyHash2 {

    Slot[] hashTable;

    public MyHash2 ( int size ) {
        this.hashTable = new Slot[size];
    }

    static class Slot {
        String key;
        String value;
        Slot next;

        public Slot ( String key, String value ) {
            this.key = key;
            this.value = value;
            this.next = null;
        }
    }

    public int hashFunc ( String key ) {
        return ( int ) ( key.charAt(0) ) % this.hashTable.length;
    }

    public void saveNewValue ( String key, String value ) {
        int address = this.hashFunc(key);

        if ( hashTable[address] != null ) {
            Slot findSlot = hashTable[address];
            Slot prevSlot = hashTable[address];

            while ( findSlot != null ) {
                if ( findSlot.key == key ) {
                    findSlot.value = value;
                } else {
                    prevSlot = findSlot;
                    findSlot = prevSlot.next;
                }
            }
            prevSlot.next = new Slot(key, value);
        } else {
            hashTable[address] = new Slot(key, value);
        }
    }

    public String searchValue ( String key ) {
        int address = hashFunc(key);

        if ( hashTable[address] != null ) {
            Slot findSlot = hashTable[address];
            while ( findSlot != null ) {
                if ( findSlot.key == key ) {
                    return findSlot.value;
                } else {
                    findSlot = findSlot.next;
                }
            }
            return null;
        } else {
            return null;
        }
    }

    public static void main ( String[] args ) {
        MyHash2 myHash2 = new MyHash2(20);
        myHash2.saveNewValue("David", "010-1234-1234");
        myHash2.saveNewValue("Dany", "010-3494-3482");
        myHash2.saveNewValue("Doby", "010-2938-3948");
        myHash2.saveNewValue("Sophi", "010-9584-2939");

        System.out.println(myHash2.searchValue("David"));
    }
}
```

코드가 길어서 이미지가 아닌 실제 코드를 첨부합니다.

<br>

**살펴보기**

충돌 방지가 추가되면서 조금 복잡해졌습니다. 하지만 어려운 개념이 추가된 것은 아니고 이전 시간에 사용한 연결 리스트를 사용해서 체이닝을 구현합니다.  구현의 핵심 로직은 다음과 같습니다.

**" 먼저 address 를 구하고 address 에 이미 값이 있다면 연결 리스트를 이용해서 새로운 Slot을 생성하고 Pointer로 이전 Slot과  연결한다."**

이를 구현하기 위해  Slot 클래스에 key 와 next 라는 멤버변수가 추가되었습니다. key가 추가된 이유는 추후 검색에서  찾고자 하는 **key:value 를 정확히 찾기 위해서 key를 함께 저장해야 합니다.**  기존의 search 는 address 만 가지고 Slot 배열에 접근만 하는 것이기 때문에 정확한 Key 의 해싱 값이 같을 경우 정확한 key : value 쌍을 구할 수 없습니다.

이 알고리즘도 시작은 항상 hashTable[address] 값이 null 인지 체크부터 합니다. null 이라면   곧 바로 새로운 Slot 를 생성하고 로직을 종료 합니다. **이제 null 이 아니라면  "key:value" 데이터가 존재한다는 의미이고 곧 충돌이 되었음을 의미합니다.**

이제 현재 Slot 의 주소를 각각 findSlot 과 prevSlot 에 초기화 한 뒤 findSlot 이 null 인지 체크를 합니다.  이때 만약 같은 key를 가진 key:value 쌍이 들어왔다면 기존의 key에 새로운 value를 업데이트 해야 하기 때문에 if 문을 통해서 key 가 같은지 검사를 하고 같다면 value 를 업데이트 하고 끝이 납니다.

동일한 key 가 아니라면 다음 Slot 으로 넘어가게 되고 만약 끝까지 갔는데 동일한 key가 없다면 새로운 Slot 를 마지막 [Slot.next](http://slot.next) 에 연결해주면 새로운 충돌을 회피하고 새로운 key:value 쌍이 추가되게 됩니다.

**"검색"** 에서는 위의 구현 로직에서 findSlot의 key 가 인자로 들어온 key 와 같은지만 검사하는 if문을 통해서 같다면 찾고자 하는 key 가 있는 것이고 없다면 찾고자 하는 key 가 없기 때문에 바로 null을 리턴하도록 했습니다.

검색은 신규 데이터 추가로직이 이해가 된다면 비교적 간단했기 때문에 추가적인 설명을 작성하는 것은 반복만 되고 혼란이 올 수도 있기 때문에 데이터 추가 로직을 곰곰히 생각해보고 구현한다면 충분히 이해할 수 있는 로직입니다.


<br>
<br>

### **회고**

오늘은 Hash Table 에 대해서 학습을 했습니다. 사실 Hash Table 구현을 먼저 파이썬으로 진행 했던 적이 있는데요 파이썬에서는 문법이 익숙치 않아서 매우 구현이 힘들었던 기억이 있습니다. 하지만 역시 익숙한 자바에서 하니까 구현이 까다롭다는 생각이 들지 않았습니다.  하지만 구현 자체가 중요한 것이 아니라 해당 지식을 바탕으로 문제를 풀 때 어떤 자료구조를 사용할 것이가 판단을 하는 것이 중요하기 때문에 구현보다는 해쉬 테이블의 로직과 장단점을 다시 한번 되짚어보는게 좋을 것 같습니다.

이상입니다. 감사합니다!!!!