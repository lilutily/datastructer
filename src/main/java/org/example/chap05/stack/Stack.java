package org.example.chap05.stack;

class Node<E> {
    private E item; // 저장할 값

    private Node<E> link; // 스택의 다음 노드를 가리킬 포인터

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getLink() {
        return link;
    }

    public void setLink(Node<E> link) {
        this.link = link;
    }
}

public class Stack<E> {

    // 스택의 맨 위 노드를 감시할 노드
    private Node<E> top;

    public Stack() {
        this.top = new Node<>();
    }

    // 스택이 비었는지 확인
    public boolean isEmpty() {
        return top.getLink() == null; // top이 바라보고 있는 링크가 없으면 null
    }

    // 스택의 자료 삽입
    public void push(E item) {
        // 새 노드 생성
        Node<E> newNode = new Node<>();
        newNode.setItem(item); // 노드에 값 저장
        // 탑의 링크가 바뀌기 전에 가지고 있던 링크를 준다

        // 새 노드는 기존의 top 노드가 감시하고 있던 노드를 연결한다
        newNode.setLink(top.getLink());

        // top 노드는 새로운 노드를 감시한다.
        top.setLink(newNode);
    }

    // 스택에서 자료 제거
    public E pop() {
        // 스택이 비었으면 수행 할 수 없음
        if(isEmpty()) {
            System.out.println("stack is empty");
            return null;
        } else {
            // 리턴할 데이터 가져오기
            // 스택은 마지막에 들어온 데이터만 삭제해야됨
            E data = top.getLink().getItem(); // 사라져야될 데이터 의 값을 가져옴

            // top이 제거될 노드의 다음 노드를 감시하도록 설정
            top.setLink(top.getLink().getLink());
            return data;
        }
    }

    public E peek() {
        // 스택이 비었으면 수행 할 수 없음
        if(isEmpty()) {
            System.out.println("stack is empty");
            return null;
        } else {
            // 리턴할 데이터 가져오기
            // 스택은 마지막에 들어온 데이터만 삭제해야됨
            E data = top.getLink().getItem(); // 사라져야될 데이터 의 값을 가져옴
            return data;
        }
    }
}
