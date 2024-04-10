package linkedList.singly;

/**
 * 단일 연결 리스트 예제
 */
public class MainSingleLinkedList {
    public static void main(String[] args) {
        SingleLinkedList<String> singleLinkedList = new SingleLinkedList<>();
        singleLinkedList.addHead("HEAD 데이터 추가"); // 맨 앞에 노드 추가하기
        singleLinkedList.addTail("TAIL 데이터 추가"); // 맨 뒤에 노드 추가하기
        singleLinkedList.addIndex(1, "중간에 데이터 추가"); // 특정 위치에 노드 추가하기

        System.out.println(singleLinkedList.findNode(1)); // 특정 위치의 노드 찾기
        System.out.println(singleLinkedList.getNodeData(2)); // 특정 위치의 노드 데이터 보기

        System.out.println("==============모든 요소 출력하기=================");
        singleLinkedList.printList(); // 모든 요소 출력하기


        singleLinkedList.removeHead(); // 맨 앞에 노드 삭제하기
        singleLinkedList.removeIndex(1); // 특정 위치 노드 삭제하기

        System.out.println("==============삭제 후, 모든 요소 출력하기=================");
        singleLinkedList.printList(); // 모든 요소 출력하기
    }
}
