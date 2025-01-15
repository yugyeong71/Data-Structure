package linkedList.circular;

public class CircularLinkedList<T> {

	private Node<T> tail; // 마지막 노드 정보

	private int number; // 총 노드 개수

	public CircularLinkedList() {
		number = 0;
		tail = new Node(-1);
		tail.next = tail;
	}

	/**
	 * 특정 위치의 Node 찾기
	 */
	public Node<T> findNode(int index) {
		if (index > number - 1 || index < -1) throw new IllegalArgumentException(); // 올바르지 않은 index 요청

		Node<T> node = tail.next;

		for (int i = 0; i <= index; i++) {
			node = node.next; // 다음 노드 저장
		}

		return node;
	}

	/**
	 * 특정 위치에 Node 추가
	 */
	public void addIndex(int index, T data) {
		if (index > number || index < 0) throw new IndexOutOfBoundsException(); // 올바르지 않은 index 요청

		Node<T> prevNode = findNode(index - 1); // 추가하려는 위치의 이전 노드
		Node<T> currNode = new Node<T>(data, prevNode.next); // 새 노드 생성
		prevNode.next = currNode; // 추가하려는 위치의 이전 노드가 가리키는 다음 노드는 새 노드

		if (index == number) { // 맨 마지막에 추가하는 경우
			tail = currNode;
		}

		number++; // 총 노드 개수 추가
	}

	/**
	 * 특정 위치 Node 삭제
	 */
	public void removeIndex(int index) {
		if (index > number - 1 || index < 0) throw new IllegalArgumentException(); // 올바르지 않은 index 요청

		Node<T> prevNode = findNode(index - 1); // 삭제하려는 노드의 이전 노드
		Node<T> removedNode = prevNode.next; // 삭제하려는 노드
		Node<T> nextNode = removedNode.next; // 삭제하려는 노드의 다음 노드

		prevNode.next = nextNode; // 이전 노드가 가리키는 다음 노드를 삭제하려는 노드의 다음 노드로 변경

		if (prevNode.next == null) { // 삭제하려는 노드가 맨 끝 노드인 경우
			tail = prevNode;
		}

		// 노드 삭제
		removedNode.next = null;
		removedNode.data = null;
		number--;
	}

	/**
	 * 특정 요소 값 가져오기
	 */
	public T get(int index) {
		if (index > number - 1 || index < 0) throw new IllegalArgumentException(); // 올바르지 않은 index 요청

		return findNode(index).data;
	}

	/**
	 * 특정 요소 값 바꾸기
	 */
	public void set(int index, T data) {
		if (index > number - 1 || index < 0) throw new IllegalArgumentException(); // 올바르지 않은 index 요청

		Node<T> currNode = findNode(index);
		currNode.data = data;
	}

	/**
	 * 리스트 길이 출력하기
	 */
	public int length() {
		return number;
	}

	/**
	 * 모든 요소 출력하기
	 */
	public void printList() {
		Node<T> node = tail.next;

		for (int i = 0; i < number; i++) {
			node = node.next;
			System.out.println(node.data);
		}
	}

}
