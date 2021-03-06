### 들어가며

이번에는 기초 자료구조중 하나며 method call 에서 자주 사용되는 STACK 에 대해서 알아보겠습니다.

<br>

### **스택**

스택은 꼭 알아둬야 할 자료구조 중 하나 입니다. 스택의 특징은 크게 두 가지로 볼 수 있습니다.

1. **데이터를 제한적으로 접근할 수 있는 구조이다.**
2. **가장 나중에 쌓은 데이터를 가장 먼저 빼낼 수 있는 데이터 구조**

**즉, 한쪽 끝에서만 자료를 넣거나 뺼 수 있으며 앞선 시간에 살펴본 Queue 와는 반대로 LIFO (Last In First Out) 정책을 사용합니다.**

<br>

**스택 그림**

![](https://images.velog.io/images/somday/post/d6fae1e1-3d42-4aa2-8da8-ab67ce4a25ff/Stack.png)


**주요 기능**

- push(): 데이터를 스택에 넣기
- pop(): 데이터를 스택에서 제거

주요 기능은 간단합니다. 데이터를 저장하기 위해서  데이터를 입력 받는 것을 PUSH 라고 하며 반대로 꺼내는 것을 POP 이라고 합니다. **스택이 사용되는 곳**은 대표적으로 위에서 언급 했듯이 **컴퓨터 내부의 프로세스 구조의 함수 동작 방식에서 활용 되는 쉽게 말하면 재귀 함수에서 사용 되는 구조 입니다.**

<br>

### 스택의 장단점

이러한 자료구조는 장단점이 있기는 하지만 이게 정답과 같은 장단점은 아닙니다. 구현과 실행환경에 따라 단점이 될 수도 있고 장점이 될 수도 있기 때문입니다. 그래서 참고적으로 한 번 알아보겠습니다.

**장점**

- 구조가 단순해서, 구현이 쉽다.
- 데이터 저장/읽기 속도가 빠르다.

**단점**

- 데이터 최대 갯수를 미리 정해야 한다.
- 저장 공간의 낭비가 발생할 수 있다.

<br>

### 구현

![](https://images.velog.io/images/somday/post/2962475c-c69f-4abf-8307-d64510dab3db/2.png)


<br>

**결과**

![](https://images.velog.io/images/somday/post/3e564f32-4095-4276-a88c-8d7c21573ea8/3.png)


<br>
<br>

### **회고**

이번 시간에는 간단하게 Stack 을 구현해보았습니다. 제가 구현한 Stack 은 가장 간단한 Stack 입니다. 실제로 보다 복잡하게 구현한다면 stack 사이즈도 미리 정하고 stack 이 Full 상태인지도 체크하는 로직이 필요할 것입니다. 하지만 코딩 테스트를 준비하는데 있어서 이러한 문제보다는 보다 개념을 정확히 파악하는게 중요하다고 판단해서 복잡한 구현은 잠시 미루고 보다 개념에 집중 했습니다.

<br>
<br>

감사합니다.