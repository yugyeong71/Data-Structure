package linkedList.doubly;

/**
 * 이중 연결 리스트 예제
 */
public class MainDoublyLinkedList {
    public static void main(String[] args) {
        DoublyLinkedList<String> mainDoublyLinkedList = new DoublyLinkedList();
        mainDoublyLinkedList.addHead("HEAD 데이터 추가"); // 맨 앞에 노드 추가하기
        mainDoublyLinkedList.addTail("TAIL 데이터 추가"); // 맨 뒤에 노드 추가하기
        mainDoublyLinkedList.addIndex(1, "중간에 데이터 추가"); // 특정 위치에 노드 추가하기

        System.out.println(mainDoublyLinkedList.findNode(1)); // 특정 위치의 노드 찾기
        System.out.println(mainDoublyLinkedList.getNodeData(2)); // 특정 위치의 노드 데이터 보기

        System.out.println("==============모든 요소 출력하기=================");
        mainDoublyLinkedList.printList(); // 모든 요소 출력하기


        mainDoublyLinkedList.removeHead(); // 맨 앞에 노드 삭제하기
        mainDoublyLinkedList.removeIndex(1); // 특정 위치 노드 삭제하기

        System.out.println("==============삭제 후, 모든 요소 출력하기=================");
        mainDoublyLinkedList.printList(); // 모든 요소 출력하기
    }
}
