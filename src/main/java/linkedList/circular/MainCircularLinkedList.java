package linkedList.circular;

/**
 * 원형 연결 리스트 예제
 */
public class MainCircularLinkedList {
	public static void main(String[] args) {
		CircularLinkedList<Integer> circularLinkedList = new CircularLinkedList<>();
		circularLinkedList.addIndex(0, 100);
		circularLinkedList.addIndex(1, 200);
		circularLinkedList.addIndex(2, 300);

		System.out.println("==============모든 요소 출력하기=================");
		circularLinkedList.printList();

		circularLinkedList.removeIndex(0);
		System.out.println("=========Index 0 제거 후 모든 요소 출력하기=========");
		circularLinkedList.printList();

		System.out.println("==============리스트 길이 출력하기=================");
		System.out.println(circularLinkedList.length());

		System.out.println("==============Index 0 값 출력하기=================");
		System.out.println(circularLinkedList.get(0));

		circularLinkedList.set(0, 1000);
		System.out.println("====Index 0 값 1000으로 설정하고 모든 요소 출력하기====");
		circularLinkedList.printList();

	}
}
