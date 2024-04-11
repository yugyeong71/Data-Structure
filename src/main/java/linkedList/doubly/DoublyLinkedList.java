package linkedList.doubly;

import java.util.NoSuchElementException;

public class DoublyLinkedList<T> {

    private Node<T> head; // 첫번째 노드 정보

    private Node<T> tail; // 마지막 노드 정보

    private int number; // 총 노드 개수

    /**
     * 특정 위치의 Node 찾기
     */
    public Node<T> findNode(int index) {
        if (index < 0 || index >= number) throw new IndexOutOfBoundsException(); // 올바르지 않은 index 요청

        Node<T> node;

        if (index > number / 2) { // 뒤에서부터 찾기 (index 값이 tail 에 가깝기 때문에 더 효율적)
            node = tail;
            for (int i = number - 1; i > index; i--) {
                node = node.prev;
            }
        } else { // 앞에서부터 찾기 (index 값이 head 에 가깝기 때문에 더 효율적)
            node = head;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
        }

        return node;
    }

    /**
     * Node 의 Data 추출
     */
    public T getNodeData(int index) {
        return findNode(index).data;
    }

    /**
     * 연결리스트 맨 앞에 Node 추가
     */
    public void addHead(T data) {
        Node<T> newNode = new Node<T>(data); // 새 노드 생성
        newNode.next = head; // 새 노드의 다음 노드는 head

        if (head != null) { // 기존 head 의 이전 노드는 새 노드
            head.prev = newNode;
        }

        head = newNode; // head 는 새 노드
        number++; // 총 노드 개수 추가

        if (head.next == null) { // 다음 노드가 존재하지 않는 경우
            tail = head; // 새 노드는 head, tail
        }
    }

    /**
     * 연결리스트 맨 끝에 Node 추가
     */
    public void addTail(T data) {
        Node<T> newNode = new Node<T>(data); // 새 노드 생성

        if (number == 0) { // 빈 연결리스트에 노드를 추가하는 경우
            addHead(data);
            return;
        }

        tail.next = newNode; // tail 의 다음 노드는 새 노드
        newNode.prev = tail; // 새 노드의 이전 노드는 기존 tail
        tail = newNode; // 새 노드는 tail
        number++; // 총 노드 개수 추가
    }

    /**
     * 특정 위치에 Node 추가
     */
    public void addIndex(int index, T data) {
        if (index > number || index < 0) throw new IndexOutOfBoundsException(); // 올바르지 않은 index 요청

        if (index == 0) { // 맨 앞에 추가하는 경우
            addHead(data);
            return;
        }

        if (index == number) { // 맨 마지막에 추가하는 경우
            addTail(data);
            return;
        }

        Node<T> prevNode = findNode(index - 1); // 추가하려는 위치의 이전 노드
        Node<T> nextNode = prevNode.next; // 추가하려는 위치

        Node<T> newNode = new Node<T>(data); // 새 노드 생성

        prevNode.next = newNode; // 이전 노드의 다음 노드는 새 노드

        newNode.prev = prevNode; // 새 노드의 이전 노드는 이전 노드
        newNode.next = nextNode; // 새 노드의 다음 노드는 추가하려는 위치의 다음 노드

        nextNode.prev = newNode; // 다음 노드의 이전 노드는 새 노드
        number++; // 총 노드 개수 추가
    }

    /**
     * 연결리스트 맨 앞에 Node 삭제
     */
    public void removeHead() {
        if (head == null) throw new NoSuchElementException(); // 빈 연결리스트의 삭제 요청인 경우

        Node<T> nextNode = head.next;

        // 노드 삭제
        head.data = null;
        head.next = null;

        if (nextNode != null) {
            nextNode.prev = null;
        }

        head = nextNode; // 삭제 후, head 는 기존 head 의 다음 노드
        number--;

        if(number == 0) { // 삭제한 노드가 유일한 노드인 경우, tail 도 Null
            tail = null;
        }
    }

    /**
     * 특정 위치 Node 삭제
     */
    public void removeIndex(int index) {
        if (index == 0) { // 맨 앞 노드 삭제인 경우
            removeHead();
        }

        if (index >= number || index < 0) throw new IndexOutOfBoundsException(); // 올바르지 않은 index 요청

        Node<T> prevNode = findNode(index - 1); // 삭제하려는 노드의 이전 노드
        Node<T> removedNode = prevNode.next; // 삭제하려는 노드
        Node<T> nextNode = removedNode.next; // 삭제하려는 노드의 다음 노드

        prevNode.next = nextNode; // 이전 노드가 가리키는 다음 노드를 삭제하려는 노드의 다음 노드로 변경

        // 노드 삭제
        removedNode.next = null;
        removedNode.prev = null;
        removedNode.data = null;

        if (nextNode != null) {
            nextNode.prev = prevNode;
        } else {
            tail = prevNode; // 삭제하려는 노드가 맨 끝 노드인 경우
        }

        number--;
    }

    /**
     * 모든 요소 출력하기
     */
    public void printList() {
        Node<T> setHead = head;
        while (setHead != null) {
            System.out.println(setHead.data);
            setHead = setHead.next;
        }
    }
}
