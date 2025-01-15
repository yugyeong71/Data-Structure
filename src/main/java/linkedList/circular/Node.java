package linkedList.circular;

public class Node<T> {

	public T data; // 값을 담고 있는 데이터

	public Node<T> next; // 다음 노드 정보

	public Node (T newItem) {
		data = newItem;
		next = null;
	}

	public Node (T newItem, Node<T> nextNode) {
		data = newItem;
		next = nextNode;
	}

}
