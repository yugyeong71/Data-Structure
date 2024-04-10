package linkedList.singly;

public class Node<T> {
    T data; // 값을 담고 있는 데이터

    Node<T> next; // 다음 노드 정보

    public Node(T data) {
        this.data = data;
    }
}
